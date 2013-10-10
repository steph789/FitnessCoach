package de.cimdata.util;

import javax.el.ELContext;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesHelper {
	
	public static void setMSG(String id, String msg){
		FacesMessage fm = new FacesMessage(msg);
		fm.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(id, fm);
	}
	
	
	/*
	 * Beispiel:
	 * PersonBean personBean = (PersonBean)FacesHelper.getManagedBean("personBean");
	 */
	public static Object getManagedBean(final String beanName) {
	    FacesContext fc = FacesContext.getCurrentInstance();
	    Object bean;
	    
	    try {
	        ELContext elContext = fc.getELContext();
	        bean = elContext.getELResolver().getValue(elContext, null, beanName);
	    } catch (RuntimeException e) {
	        throw new FacesException(e.getMessage(), e);
	    }

	    if (bean == null) {
	        throw new FacesException("Managed bean with name '" + beanName
	            + "' was not found. Check your faces-config.xml or @ManagedBean annotation.");
	    }

	    return bean;
	}
}
