import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ImagesView {

    private List<String> images;

    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 2; i++) {
            images.add("pobyt" + i + ".png");
        }
    }

    public List<String> getImages() {
        return images;
    }
    
    public String getDescription(String s){
  
        return "Generated description for each image";
    }
}
