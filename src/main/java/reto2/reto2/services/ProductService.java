package reto2.reto2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto2.reto2.models.ProductModel;
import reto2.reto2.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> obtenerProductos() {
        return (List<ProductModel>) productRepository.findAll();
    }

    public ProductModel guardarProducto(ProductModel producto) {
        return productRepository.save(producto);
    }

    public boolean eliminarProducto(String producto) {
        try {
            productRepository.deleteById(producto);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
