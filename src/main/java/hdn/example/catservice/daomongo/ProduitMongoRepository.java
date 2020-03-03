/**
 * 
 */
package hdn.example.catservice.daomongo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import hdn.example.catservice.entities.Produit;

/**
 * @author Gandalf
 *
 */


@CrossOrigin(origins = "*")
@RepositoryRestResource(path = "produitsMongoDB", collectionResourceRel = "produitsMongoDB")
public interface ProduitMongoRepository extends MongoRepository<Produit, Long> {
	
	@Override
	default List<Produit> findAll() {
		
		return new ArrayList<Produit>();
	}
	
	
	/* @RestResource(path = "byDesignationPage")
	    public List<Produit> findByDesignationContains(@Param("des") String des, Pageable pageable);
*/

}
