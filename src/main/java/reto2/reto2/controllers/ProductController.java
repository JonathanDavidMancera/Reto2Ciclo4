package reto2.reto2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reto2.reto2.models.ProductModel;
import reto2.reto2.services.ProductService;

@RestController
@RequestMapping("/api/cleaningproduct")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired ProductService productService;

    @GetMapping("/all")
    public List <ProductModel> listarProductos() {
        return productService.obtenerProductos();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductModel guardar(@RequestBody ProductModel producto) {
        return productService.guardarProducto(producto);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductModel actualizarProducto(@RequestBody ProductModel producto) {
        return productService.guardarProducto(producto);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String borrarProductoPorReferencia(@PathVariable("reference") String reference) {
        boolean valido = productService.eliminarProducto(reference);
        if (valido) {
            return "";
        } else {
            return "";
        }
    }

}
