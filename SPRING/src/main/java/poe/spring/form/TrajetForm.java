package poe.spring.form;

import java.util.Date;

import poe.spring.model.Trajet;

public class TrajetForm {

	private String villeDepart;
	private String villeArrivee;
	private Date dateDepart;
	private Double prix;
	private int nbPlace;

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public Trajet trajetFormToTrajet() {

		Trajet trajet = new Trajet();
		trajet.setVilleDepart(this.villeDepart);
		trajet.setVilleArrivee(this.villeArrivee);
		trajet.setDateDepart(this.dateDepart);
		trajet.setPrix(this.prix);
		trajet.setNbPlace(this.nbPlace);

		return trajet;
	}

}
