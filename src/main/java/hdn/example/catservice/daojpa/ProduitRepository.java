package hdn.example.catservice.daojpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import hdn.example.catservice.entities.Produit;

@CrossOrigin(origins = "*")
@RepositoryRestResource(path = "produits")
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    @RestResource(path = "byDesignation")
    public List<Produit> findByDesignationContains(@Param("des") String des);

    @RestResource(path = "byDesignationPage")
    public Page<Produit> findByDesignationContains(@Param("des") String des, Pageable pageable);
}
