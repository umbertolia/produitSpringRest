package hdn.example.catservice.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import hdn.example.catservice.entities.Produit;

@RepositoryRestResource(path = "produits")
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    @RestResource(path = "byDesignation")
    public List<Produit> findByDesignationContains(@Param("des") String des);

    @RestResource(path = "byDesignationPage")
    public Page<Produit> findByDesignationContains(@Param("des") String des, Pageable pageable);
}
