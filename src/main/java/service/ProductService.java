package service;

import entity.Product;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ProductService {

    @Transactional
    public Product add(Product product){
        product.persist();
        return product;
    }

    public Product findById(Long id){
        return Product.findById(id);
    }

    public List<Product> findAll(){
        return Product.listAll();
    }

    @Transactional
    public String deleteById(Long id){
        Product product = Product.findById(id);
        if (product != null) {
            product.delete();
            return "Ürün silindi : " + id;
        } else {
            return "Ürün bulunamadı : " + id;
        }
    }

    @Transactional
    public Product update(Long id, Product updatedProduct){
        Product existingProduct = Product.findById(id);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            return existingProduct;
        } else {
            return null;
        }
    }
}
