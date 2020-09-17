package org.cata.produit;

import org.cata.produit.Dao.IProduitRepository;
import org.cata.produit.Entity.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CataMvcProduitApplication implements CommandLineRunner{
	
	@Autowired
	private IProduitRepository iproduitrepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CataMvcProduitApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		iproduitrepository.save(new Produit("Livre",2000,5));
		iproduitrepository.save(new Produit("cahier",250,4));
		iproduitrepository.save(new Produit("stylo",560,3));
		iproduitrepository.save(new Produit("gomme",230,6));
		iproduitrepository.findAll().forEach(p->{
			System.out.println(p.getDesignation());
			});
	}


}
