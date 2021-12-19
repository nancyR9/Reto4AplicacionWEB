/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.repositorio;

import Reto2_Web.modelo.CleaningProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Reto2_Web.interfaces.CleaningProdInterface;

/**
 *
 * @author USUARIO
 */
@Repository
public class CleaningProductRepository {
    @Autowired
    private CleaningProdInterface crudInterface;

    public List<CleaningProduct> getAll() {
        return (List<CleaningProduct>) crudInterface.findAll();
    }

    public Optional<CleaningProduct> getCleaningProd(Integer id) {
        return crudInterface.findById(id);
    }

    public CleaningProduct save(CleaningProduct cleanProd) {
        return crudInterface.save(cleanProd);
    }
    
    public void update(CleaningProduct cleaningProd) {
        crudInterface.save(cleaningProd);
    }

    public void delete(CleaningProduct cleaningProd) {
        crudInterface.delete(cleaningProd);
    }
    
    public List<CleaningProduct> getByPrice(double price){
        return crudInterface.findByPriceLessThanEqual(price);
    }

    public List<CleaningProduct> getByDescriptionContains(String description){
        return crudInterface.findByDescriptionContainingIgnoreCase(description);
    }
}
