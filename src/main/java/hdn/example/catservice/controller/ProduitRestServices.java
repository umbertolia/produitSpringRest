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

import hdn.example.catservice.dao.ProduitRepository;
import hdn.example.catservice.entities.Produit;

/**
 * ProduitRestServices
 */

@RestController
@CrossOrigin(origins = "*")
public class ProduitRestServices {

    @Autowired(required = false)
    private ProduitRepository produitRepository;

    @GetMapping(value = "/listProduits")
    public List<Produit> listProduits() {
        return produitRepository.findAll();
    }

    @GetMapping(value = "/listProduits/{id}")
    public Produit getProduit(@PathVariable(name = "id") Long id) {
        return produitRepository.findById(id).get();
    }

    @PutMapping(value = "/listProduits/{id}")
    public Produit updateProduit(@PathVariable(name = "id") Long id, @RequestBody Produit produit) {
        return produitRepository.save(produit);
    }

    @PostMapping(value = "/listProduits")
    public Produit creerProduit(@RequestBody Produit produit) {
        return produitRepository.save(produit);
    }

    @DeleteMapping(value = "/listProduits/{id}")
    public void deleteProduit(@PathVariable(name = "id") Long id, @RequestBody Produit produit) {
        produitRepository.deleteById(id);
    }


}