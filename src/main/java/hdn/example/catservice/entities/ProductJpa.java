package hdn.example.catservice.entities;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Produit
 */

@Entity
@Table(name = "Product")
public class ProductJpa extends Product {

	private static final long serialVersionUID = 2083534115856188791L;
	
}

