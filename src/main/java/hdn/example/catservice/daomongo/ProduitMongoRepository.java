/**
 * 
 */
package hdn.example.catservice.daomongo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import hdn.example.catservice.entities.Product;
import hdn.example.catservice.entities.ProductMongo;

/**
 * @author Gandalf
 *
 */

@CrossOrigin(origins = "*")
@RepositoryRestResource(path = "products", collectionResourceRel = "products")
public interface ProduitMongoRepository<T extends Product> extends MongoRepository<ProductMongo, BigInteger> {

	@RestResource(path = "byDesignationPage")
	public List<T> findByDesignationContains(@Param("des") String des, Pageable pageable);

}
