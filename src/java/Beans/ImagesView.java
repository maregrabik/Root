import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ImagesView {

    private List<String> images;
    private List<String> imagesP1;

    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 2; i++) {
            images.add("pobyt" + i + ".png");
        }
        imagesP1 = new ArrayList<String>();
        for (int i = 1; i <= 2; i++) {
            imagesP1.add("p1" + i + ".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }

    public List<String> getImagesP1() {
        return imagesP1;
    }

    public String getP1Description(String s) {

        Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

        System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.print(locale.toLanguageTag());
        if (locale.toLanguageTag().equals("en")) {

            switch (s) {

                case ("p11.jpg"):
                    return "This is an example of basic datamart structure that we used to create at first phase of our work";

                case ("p12.jpg"):
                    return "The basic view of an exploring cube from SAS guide tool";

            }

        } else {
            switch (s) {
                case ("p11.jpg"):
                    return "Przykład struktury podstawowego datamartu tworzonego przeze mnie w pierwszej czesci projektu";

                case ("p12.jpg"):
                    return "Podstawowy widok kostki przeglądanej w narzedziu SAS guide";
            }
        }
    return "it's a picture of thousand sunsets";
    }
}
