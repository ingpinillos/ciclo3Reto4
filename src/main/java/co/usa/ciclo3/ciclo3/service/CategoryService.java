/*
* Apliación alquiler de herrmientas 
*  Servicio Category
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.model.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * USA.edu.co Javier Pinillos
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category c) {
        if (c.getId() == null) {
            return categoryRepository.save(c);
        } else {
            Optional<Category> cAux = categoryRepository.getCategory(c.getId());
            //if (tAux.isEmpty ()) { //isEmpty no existe
            if (cAux.isPresent()) {
                return categoryRepository.save(c);
            } else {
                return c;
            }
        }
    }

    public Category update(Category c) {
        if (c.getId() != null) {
            Optional<Category> cAux = categoryRepository.getCategory(c.getId());
            if (!cAux.isEmpty()) {
                if (c.getDescription() != null) {
                    cAux.get().setDescription(c.getDescription());
                }
                if (c.getName() != null) {
                    cAux.get().setName(c.getName());
                }
                return categoryRepository.save(cAux.get());
            }
        }
        return c;
    }

    public boolean delete(int categoryId) {
        Boolean cAux = getCategory(categoryId).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return cAux;
    }
}
