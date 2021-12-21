package org.springframework.samples.petclinic.product;

import java.util.List;


public class ProductService {
	
	private ProductRepository productRepository;
	
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public List<ProductType> findAllProductTypes(){
        return productRepository.findAllProductTypes();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productRepository.findProductsCheaperThan(price);
    }

    public ProductType getProductType(String typeName) {
        return productRepository.getProductType(typeName);
    }

    public Product save(Product p){
        return null;       
    }

    
}
