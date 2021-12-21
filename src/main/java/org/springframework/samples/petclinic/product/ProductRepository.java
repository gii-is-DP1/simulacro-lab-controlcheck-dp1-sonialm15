package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, Integer>{
	@Query("SELECT * FROM Product")
	public List<Product> findAll();
    
    @Query("SELECT product.productType FROM Product product")
    public List<ProductType> findAllProductTypes();
    
    @Query("SELECT p.productType FROM Product p WHERE p.name==name")
    public ProductType getProductType(String name);
    
    @Query("SELECT * FROM Product p WHERE p.price<price")
    public List<Product> findProductsCheaperThan(Double price);
    
    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p);
}
