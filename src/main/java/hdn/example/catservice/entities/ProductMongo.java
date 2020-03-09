package hdn.example.catservice.entities;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * ProduitMongo
 */


@Document(collection = "products")
@TypeAlias("productmongo")
public class ProductMongo extends Product{

	private static final long serialVersionUID = 6857647927697629648L;
	
	
}

