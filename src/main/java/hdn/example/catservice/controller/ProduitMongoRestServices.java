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

import hdn.example.catservice.daomongo.ProduitMongoRepository;
import hdn.example.catservice.entities.Produit;

/**
 * ProduitMongoRestServices : pour la base MongoDB
 */

@RestController
@CrossOrigin(origins = "*")
public class ProduitMongoRestServices {

    @Autowired(required = false)
    private ProduitMongoRepository produitMongoRepository;

    @GetMapping(value = "/produitsMongoDB")
    public List<Produit> listProduits() {
        return produitMongoRepository.findAll();
    }

    @GetMapping(value = "/produitsMongoDB/{id}")
    public Produit getProduit(@PathVariable(name = "id") Long id) {
        return produitMongoRepository.findById(id).get();
    }

    @PutMapping(value = "/produitsMongoDB/{id}")
    public Produit updateProduit(@PathVariable(name = "id") Long id, @RequestBody Produit produit) {
        return produitMongoRepository.save(produit);
    }

    @PostMapping(value = "/produitsMongoDB")
    public Produit creerProduit(@RequestBody Produit produit) {
        return produitMongoRepository.save(produit);
    }

    @DeleteMapping(value = "/produitsMongoDB/{id}")
    public void deleteProduit(@PathVariable(name = "id") Long id, @RequestBody Produit produit) {
    	produitMongoRepository.deleteById(id);
    }


}