package org.cata.produit.Web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.cata.produit.Dao.IProduitRepository;
import org.cata.produit.Entity.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProduitController {

	@Autowired
	private IProduitRepository iproduitrepository;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String chercher(
			Model model,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="mc", defaultValue="") String motCle) {
		//afficher la liste de produit
		//chercher un produit par mot cle
		Page<Produit> PageProduit=  iproduitrepository.findByDesignationContains(motCle, PageRequest.of(page, 5));
		model.addAttribute("listeproduit",PageProduit.getContent());
		model.addAttribute("pages", new int[PageProduit.getTotalPages()]);
		model.addAttribute("currentpage", page);
		model.addAttribute("motcle", motCle);
		return "Produit";
	}
	
	@RequestMapping(value="/supprimer",method=RequestMethod.GET)
	public String supprimer(Long ref,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="mc", defaultValue="") String motCle) {
		iproduitrepository.deleteById(ref);
		return "redirect:/index?page="+page+"&mc="+motCle;
	}
	
	@RequestMapping(value="/formProduit")
	public String form(Model model) {
		model.addAttribute("produit", new Produit());
		return "formProduit";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Model model,@Valid Produit P,BindingResult bindingResult,String mode) {
		if(bindingResult.hasErrors() && mode.equals("ajoute")) return "formProduit";// retourne vers la formulaire sans fait le save
		if(bindingResult.hasErrors() && mode.equals("edit")) return "editProduit";
		iproduitrepository.save(P);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/modifier",method=RequestMethod.GET)
	public String modifier(Long ref,Model model) {
		Produit P=iproduitrepository.findById(ref).get();
		model.addAttribute("produit", P);
		return "editProduit";
	}
}
