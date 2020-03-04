/**
 * 
 */
package hdn.example.catservice.daomongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import hdn.example.catservice.entities.Produit;

/**
 * @author Gandalf
 *
 */


@CrossOrigin(origins = "*")
@RepositoryRestResource(path = "products", collectionResourceRel = "products")
public interface ProduitMongoRepository extends MongoRepository<Produit, Long> {
	
	/* @RestResource(path = "byDesignationPage")
	    public List<Produit> findByDesignationContains(@Param("des") String des, Pageable pageable);
*/

}
