package hdn.example.catservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ProduitMongo
 */


@Document(collection = "products")
@TypeAlias("productmongo")
@Data
@EqualsAndHashCode(callSuper=false)
public class ProductMongo extends Product{

	private static final long serialVersionUID = 6857647927697629648L;
	
	@Id
	private String id;
	
	private String designation;
	
}

