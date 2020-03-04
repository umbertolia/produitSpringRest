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
import hdn.example.catservice.entities.ProductJpa;

/**
 * ProduitRestController
 */

@RestController
@CrossOrigin(origins = "*")
public class ProduitRestController {

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping(value = "/listProduits")
    public List<ProductJpa> listProduits() {
        return produitRepository.findAll();
    }

    @GetMapping(value = "/listProduits/{id}")
    public ProductJpa getProduit(@PathVariable(name = "id") Long id) {
        return produitRepository.findById(id).get();
    }

    @PutMapping(value = "/listProduits/{id}")
    public ProductJpa updateProduit(@PathVariable(name = "id") Long id, @RequestBody ProductJpa ProductJpa) {
        return produitRepository.save(ProductJpa);
    }

    @PostMapping(value = "/listProduits")
    public ProductJpa creerProduit(@RequestBody ProductJpa ProductJpa) {
        return produitRepository.save(ProductJpa);
    }

    @DeleteMapping(value = "/listProduits/{id}")
    public void deleteProduit(@PathVariable(name = "id") Long id, @RequestBody ProductJpa ProductJpa) {
        produitRepository.deleteById(id);
    }


}