package hdn.example.catservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hdn.example.catservice.daojpa.ProduitRepository;
import hdn.example.catservice.entities.Product;
import hdn.example.catservice.entities.ProductJpa;


/**
 * ProduitRestController
 */
@RestController
@CrossOrigin(origins = "*")
public class ProduitRestController implements ProductRestController<ProductJpa> {

    @Autowired
    private ProduitRepository<Product> produitRepository;

    @GetMapping(value = "/listProduits")
    public List<ProductJpa> listProduits() {
        return produitRepository.findAll();
    }

    @GetMapping(value = "/listProduits/{id}")
    public Product getProduit(@PathVariable(name = "id") Integer id) {
        return produitRepository.findById(id).get();
    }

    @PutMapping(value = "/listProduits/{id}")
    public Product updateProduit(@PathVariable(name = "id") Integer id, @RequestBody ProductJpa product) {
        return produitRepository.save(product);
    }

    @PostMapping(value = "/listProduits")
    public Product creerProduit(@RequestBody ProductJpa product) {
        return produitRepository.save(product);
    }

    @DeleteMapping(value = "/listProduits/{id}")
    public void deleteProduit(@PathVariable(name = "id") Integer id) {
        produitRepository.deleteById(id);
    }

}