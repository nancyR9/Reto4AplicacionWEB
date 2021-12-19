/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.servicio;

import Reto2_Web.modelo.CleaningProduct;
import Reto2_Web.repositorio.CleaningProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class CleaningProductService {
    @Autowired
    private CleaningProductRepository cleanProdRepository;

    public List<CleaningProduct> getAll() {
        return cleanProdRepository.getAll();
    }

    public Optional<CleaningProduct> getCleaningProd(Integer id) {
        return cleanProdRepository.getCleaningProd(id);
    }

    public CleaningProduct save (CleaningProduct cleaningProduct){
        if (cleaningProduct.getId()== null) {
            return cleaningProduct;
        } else {
            return cleanProdRepository.save(cleaningProduct);
        }
          
    }

    public CleaningProduct update(CleaningProduct accesory) {
        if (accesory.getId() != null) {
            Optional<CleaningProduct> accesoryDb = cleanProdRepository.getCleaningProd(accesory.getId());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                if (accesory.getPresentation() != null) {
                    accesoryDb.get().setPresentation(accesory.getPresentation());
                }
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                cleanProdRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(int id){
        boolean del = getCleaningProd(id).map(cleanProd -> {
            cleanProdRepository.delete(cleanProd);
            return true;
        }).orElse(false);
        return del;
    }
    
     public List<CleaningProduct> getByPrice(double price){
        return cleanProdRepository.getByPrice(price);
    }

    public List<CleaningProduct> getByDescriptionContains(String description){
        return cleanProdRepository.getByDescriptionContains(description);
    }
}
