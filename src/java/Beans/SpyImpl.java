package Beans;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.CellEntry;
import com.google.gdata.data.spreadsheet.CellFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class SpyImpl implements interfaces.Spy {

    HttpServletRequest request;

    public SpyImpl() {
    }

    @Override
    public void saveTrace(HttpServletRequest requestP) {
        String ipAddress = requestP.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            saveInDocLog("Unknown adress");
        } else {
            saveInDocLog(ipAddress);
        }
    }

    private void saveInDocLog(String ipAddress) {

        SpreadsheetService service = new SpreadsheetService("spreadsheetservice");

        try {

            service.setUserCredentials("horaczy.marek@gmail.com", "***");

            URL metafeedUrl = new URL("https://spreadsheets.google.com/feeds/spreadsheets/private/full");
            SpreadsheetFeed feed = service.getFeed(metafeedUrl, SpreadsheetFeed.class);

            List<SpreadsheetEntry> spreadsheets = feed.getEntries();
            for (int i = 0; i < spreadsheets.size(); i++) {
                SpreadsheetEntry entry = spreadsheets.get(i);
                System.out.println("\t" + entry.getTitle().getPlainText());
            }
            WorksheetEntry worksheet = spreadsheets.get(0).getWorksheets().get(1);

            URL cellFeedUrl = worksheet.getCellFeedUrl();
            CellFeed cellFeed = service.getFeed(cellFeedUrl, CellFeed.class);

            CellEntry cellEntry = new CellEntry(cellFeed.getEntries().size(), 1, ipAddress);
            cellFeed.insert(cellEntry);
            cellEntry = new CellEntry(cellFeed.getEntries().size(), 2, new Date().toString());
            cellFeed.insert(cellEntry);

        } catch (AuthenticationException ex) {
            System.out.println("Error");
        } catch (IOException | ServiceException e) {
        }

    }

    public void start() {
        HttpServletRequest requestC = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        saveTrace(requestC);
    }
}
