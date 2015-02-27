package Beans;
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
    private List<String> imagesCert;
    public List<String> imagesCar;

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
        
         imagesCert = new ArrayList<String>();
        for (int i = 1; i <= 5; i++) {
            imagesCert.add("cert" + i + ".png");
        }
        
           imagesCar = new ArrayList<String>();
        for (int i = 1; i <= 5; i++) {
            imagesCar.add("carShop" + i + ".png");
        }
        
    }

    public List<String> getImages() {
        return images;
    }

    public List<String> getImagesP1() {
        return imagesP1;
    }
    
     public List<String> getImagesCert() {
        return imagesCert;
    }
     

    public String getP1Description(String s) {

        //get locales
        Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        
        //return picture description according to locales
        //todo: change it to get it cia lang properties
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

    /**
     * @return the imagesCar
     */
    public List<String> getImagesCar() {
        return imagesCar;
    }

    /**
     * @param imagesCar the imagesCar to set
     */
    public void setImagesCar(List<String> imagesCar) {
        this.imagesCar = imagesCar;
    }
}
