/*
* Apliación alquiler de herrmientas 
*  Clase Repositorio Category
*/
package co.usa.ciclo3.ciclo3.model.repository;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.model.repository.crud.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * USA.edu.co Javier Pinillos
 */
@Repository
public class CategoryRepository {
 @Autowired

 private CategoryCrudRepository categoryCrudRepository;

 public List<Category> getAll() {
  return (List<Category>) categoryCrudRepository.findAll();
 }

 public Optional<Category> getTool(int id) {
  return categoryCrudRepository.findById(id);
 }

 public Category save(Category c) {
  return categoryCrudRepository.save(c);
 } 

 public Optional<Category> getCategory(int id) {
  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 }
}
