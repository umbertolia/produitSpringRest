package hdn.example.catservice.controller;

import java.util.List;

import hdn.example.catservice.entities.Product;

public interface ProductRestController<T extends Product> {

	    public List<T> listProduits();

	    public Product getProduit(Integer id) ;

	    public Product updateProduit( Integer id,  T product) ;

	    public Product creerProduit( T product);

	    public void deleteProduit(Integer id);
}
