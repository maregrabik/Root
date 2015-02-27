
package Beans;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
@ManagedBean
@RequestScoped
public class EditorView {
     
    private String text;
 
    public String getText() {
        return text;
    }
 
    public void setText(String text) {
        this.text = text;
    }
    
    public void send(){
        
    }
}