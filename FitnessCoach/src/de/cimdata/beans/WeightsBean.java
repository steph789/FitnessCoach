package de.cimdata.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import de.cimdata.hibernate.Weights;
import de.cimdata.hibernate.WeightsHome;


@ManagedBean
@SessionScoped
public class WeightsBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Weights weights;
	private WeightsHome weightshome;
	
	@ManagedProperty(value = "#{userBean}")
	private UserBean userBean;
	
	
	
	
	//private long userid;
	
	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public WeightsBean() {
		weights = new Weights(userBean.getUser().getUserId());
		weightshome = new WeightsHome();
	}
	
	public String enterNewEight() {
		weightshome.attachWeight(weights);
		
		return "newentry";
	}

	public Weights getWeights() {
		return weights;
	}

	public WeightsHome getWeightshome() {
		return weightshome;
	}

	public void setWeights(Weights weights) {
		this.weights = weights;
	}

	public void setWeightshome(WeightsHome weightshome) {
		this.weightshome = weightshome;
	}
	
	
	
	
}
