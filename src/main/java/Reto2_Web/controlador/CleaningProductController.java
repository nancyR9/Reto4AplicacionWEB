/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.controlador;

import Reto2_Web.modelo.CleaningProduct;
import Reto2_Web.servicio.CleaningProductService;
import java.util.List;
import java.util.Optional;
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

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/cleaningprod")
@CrossOrigin("*")
public class CleaningProductController {
    @Autowired
    private CleaningProductService cleaningProdService;

    @GetMapping("/all")
    public List<CleaningProduct> getAll() {
        return cleaningProdService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CleaningProduct> getCleaningProd(@PathVariable("id") Integer id) {
        return cleaningProdService.getCleaningProd(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CleaningProduct cleanProd) {
        cleaningProdService.save(cleanProd);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct update(@RequestBody CleaningProduct cleanProd) {
        return cleaningProdService.update(cleanProd);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return cleaningProdService.delete(id);
    }
    
     @GetMapping("/price/{price}")
    public List<CleaningProduct> getByPrice(@PathVariable("price") double price){
        return cleaningProdService.getByPrice(price);
    }

    @GetMapping("/description/{description}")
    public List<CleaningProduct> getByDescriptionContains(@PathVariable("description") String description){
        return cleaningProdService.getByDescriptionContains(description);
    }

}
