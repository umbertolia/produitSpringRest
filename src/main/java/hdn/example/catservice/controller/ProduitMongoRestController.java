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
import hdn.example.catservice.entities.Product;
import hdn.example.catservice.entities.ProductMongo;

/**
 * ProduitMongoRestController : pour la base MongoDB
 */


@RestController
@CrossOrigin(origins = "*")
public class ProduitMongoRestController implements ProductRestController<ProductMongo> {

    @Autowired
    private ProduitMongoRepository<Product> produitMongoRepository;

    @GetMapping(value = "/listProduitsMongoDB")
    public List<ProductMongo> listProduits() {
        return produitMongoRepository.findAll();
    }
    
    @GetMapping(value = "/listProduitsMongoDBPageable")
    public Page<ProductMongo> listProduitsParPage(@RequestParam String page, @RequestParam String size) {
    	final Pageable pageableRequest = PageRequest.of(Integer.valueOf(page), Integer.valueOf(size));
        return produitMongoRepository.findAll(pageableRequest);
    }
    
    
    @GetMapping(value = "/listProduitsMongoDB/{id}")
    public Product getProduit(@PathVariable(name = "id") Integer id) {

        return produitMongoRepository.findById(id).get();
    }

    @PutMapping(value = "/listProduitsMongoDB/{id}")
    public Product updateProduit(@PathVariable(name = "id") Integer id, @RequestBody ProductMongo productMongo) {
        return produitMongoRepository.save(productMongo);
    }

    @PostMapping(value = "/listProduitsMongoDB")
    public Product creerProduit(@RequestBody ProductMongo productMongo) {
        return produitMongoRepository.save(productMongo);
    }

    @DeleteMapping(value = "/listProduitsMongoDB/{id}")
    public void deleteProduit(@PathVariable(name = "id") Integer id) {
    	produitMongoRepository.deleteById(id);
    }


}