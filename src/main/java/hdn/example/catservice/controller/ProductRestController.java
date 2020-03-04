package hdn.example.catservice.controller;

import java.util.List;

import hdn.example.catservice.entities.Product;

public interface ProductRestController<T extends Product> {

	    public List<T> listProduits();

	    public Product getProduit(Long id) ;

	    public Product updateProduit( Long id,  T product) ;

	    public Product creerProduit( T product);

	    public void deleteProduit(Long id);
}
