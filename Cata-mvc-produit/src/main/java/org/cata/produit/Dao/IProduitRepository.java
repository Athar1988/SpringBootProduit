package org.cata.produit.Dao;

import java.util.List;

import org.cata.produit.Entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface IProduitRepository extends JpaRepository<Produit,Long>{

	
	public Page<Produit>  findByDesignationContains(String motclé, Pageable pageable); 
}
