package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, Integer>{
	@Query("SELECT p FROM Product p")
	public List<Product> findAll();
    
    @Query("SELECT p FROM ProductType p")
    public List<ProductType> findAllProductTypes();
    
    @Query("SELECT p FROM ProductType p WHERE p.name=?1")
    public ProductType getProductType(String name);
    
    @Query("SELECT p FROM Product p WHERE p.price<?1")
    public List<Product> findProductsCheaperThan(Double price);
    
    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p);
}
