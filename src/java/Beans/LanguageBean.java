/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
 
@ManagedBean(name="language")
@SessionScoped
public class LanguageBean implements Serializable{
 
	private static final long serialVersionUID = 1L;
 
	private String localeCode;
 
	private static Map<String,Object> countries;
	static{
		countries = new LinkedHashMap<String,Object>();
		countries.put("English", Locale.forLanguageTag("EN")); //label, value
		countries.put("Polski", Locale.forLanguageTag("PL"));
              
	}
 
	public Map<String, Object> getCountriesInMap() {
		return countries;
	}
 
 
	public String getLocaleCode() {
           String x = FacesContext.getCurrentInstance()
        			.getViewRoot().getLocale().toLanguageTag();
		return x;
	}
 
 
	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}
 
	//value change event listener
	public void countryLocaleCodeChanged(ValueChangeEvent e){
 
		String newLocaleValue = e.getNewValue().toString();
 
		//loop country map to compare the locale code
                for (Map.Entry<String, Object> entry : countries.entrySet()) {
 
        	   if(entry.getValue().toString().equals(newLocaleValue)){

        		FacesContext.getCurrentInstance()
        			.getViewRoot().setLocale((Locale)entry.getValue());
 
        	  }
               }
	}
 
}
