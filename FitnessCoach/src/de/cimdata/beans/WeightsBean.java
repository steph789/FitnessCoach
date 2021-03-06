package de.cimdata.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartSeries;

import de.cimdata.hibernate.Weights;
import de.cimdata.hibernate.WeightsHome;
import de.cimdata.util.FacesHelper;


@ManagedBean
@RequestScoped
public class WeightsBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Weights weights;
	private Weights selectedWeight = new Weights();
	private WeightsHome weightshome;
	private List<Weights> listAllWeights;
	private CartesianChartModel linearModel;
	private UserBean userBean;
	private Long weightId;



	public WeightsBean() {
		userBean = (UserBean)FacesHelper.getManagedBean("userBean");
		weights = new Weights(userBean.getUser().getUserId());
		weightshome = new WeightsHome();
		listAllWeights = weightshome.findWeightsByID(userBean.getUser().getUserId());
		createLinearModel();
	}
	
	public String enterNewWeight() {
		weightshome.attachWeight(weights);
		return "reporting";
	}
	
	public String removeEntry()	{
		System.out.println("+++++++++++++++++++++++++++ remove entry");
		//weightId = weights.getWeightsId();
		weightshome.deleteWeight(selectedWeight.getWeightsId());
		System.out.println("+++++++++++++++++++++++++++ remove entry");
		return "newentry";
	}

	private void createLinearModel() {  
        linearModel = new CartesianChartModel();  
  
        LineChartSeries series = new LineChartSeries();  
        series.setLabel("Gewicht"); 
        
        for (Weights w : listAllWeights) {
           	series.set(w.getDate(), w.getWeight());
		}
		linearModel.addSeries(series);
    }
	
	public UserBean getUserBean() {
		return userBean;
	}
	
	public Weights getWeights() {
		return weights;
	}

	public WeightsHome getWeightshome() {
		return weightshome;
	}

	public List<Weights> getListAllWeights() {
		listAllWeights = weightshome.findWeightsByID(userBean.getUser().getUserId());
		return listAllWeights;
	}
	
	public CartesianChartModel getLinearModel() {  
        return linearModel;  
    }

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public void setWeights(Weights weights) {
		this.weights = weights;
	}

	public void setWeightshome(WeightsHome weightshome) {
		this.weightshome = weightshome;
	}

	public void setListAllWeights(List<Weights> listAllWeights) {
		this.listAllWeights = listAllWeights;
	}

	public Weights getSelectedWeight() {
		return selectedWeight;
	}

	public void setSelectedWeight(Weights selectedWeight) {
		this.selectedWeight = selectedWeight;
	}

	public Long getWeightId() {
		return weightId;
	}

	public void setWeightId(Long weightId) {
		this.weightId = weightId;
	}
	
	
}
