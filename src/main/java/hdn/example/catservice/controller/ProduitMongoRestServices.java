package hdn.example.catservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hdn.example.catservice.daomongo.ProduitMongoRepository;
import hdn.example.catservice.entities.Produit;

/**
 * ProduitMongoRestServices : pour la base MongoDB
 */

@RestController
@CrossOrigin(origins = "*")
public class ProduitMongoRestServices {

    @Autowired
    private ProduitMongoRepository produitMongoRepository;

    @GetMapping(value = "/listProduitsMongoDB")
    public List<Produit> listProduits() {
        return produitMongoRepository.findAll();
    }
    
    @GetMapping(value = "/listProduitsMongoDBPageable")
    public Page<Produit> listProduitsParPage(@RequestParam int pageNumber, @RequestParam int size) {
    	final Pageable pageableRequest = PageRequest.of(pageNumber, size);
        return produitMongoRepository.findAll(pageableRequest);
    }
    
    
    @GetMapping(value = "/listProduitsMongoDB/{id}")
    public Produit getProduit(@PathVariable(name = "id") Long id) {
        return produitMongoRepository.findById(id).get();
    }

    @PutMapping(value = "/listProduitsMongoDB/{id}")
    public Produit updateProduit(@PathVariable(name = "id") Long id, @RequestBody Produit produit) {
        return produitMongoRepository.save(produit);
    }

    @PostMapping(value = "/listProduitsMongoDB")
    public Produit creerProduit(@RequestBody Produit produit) {
        return produitMongoRepository.save(produit);
    }

    @DeleteMapping(value = "/listProduitsMongoDB/{id}")
    public void deleteProduit(@PathVariable(name = "id") Long id, @RequestBody Produit produit) {
    	produitMongoRepository.deleteById(id);
    }


}