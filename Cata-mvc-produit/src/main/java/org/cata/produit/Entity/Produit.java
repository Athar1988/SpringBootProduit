package org.cata.produit.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="PRODUIT")
public class Produit implements Serializable{
	@Id
	@Column(name="reference")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long reference;
	@NotNull
	@Size(min = 5, max = 70)
	@Column(name="designation")
	private String designation;
	@DecimalMin("100")
	@Column(name="prix")
	private double prix;
	@Column(name="quantite")
   private int quantite;
	public Long getIdProduit() {
		return reference;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(String designation, double prix, int quantite) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}
	public Long getReference() {
		return reference;
	}
	public void setReference(Long reference) {
		this.reference = reference;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public void setIdProduit(Long ref) {
		this.reference = ref;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
}
