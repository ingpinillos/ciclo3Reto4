/*
* Apliación alquiler de herrmientas 
*  Clase Repositorio Tool
*/
package co.usa.ciclo3.ciclo3.model.repository;

import co.usa.ciclo3.ciclo3.model.Tool;
import co.usa.ciclo3.ciclo3.model.repository.crud.ToolCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * USA.edu.co Javier Pinillos
 */
@Repository
public class ToolRepository {

 @Autowired

 private ToolCrudRepository toolCrudRepository;

 public List<Tool> getAll() {
  return (List<Tool>) toolCrudRepository.findAll();
 }

 public Optional<Tool> getTool(int id) {
  return toolCrudRepository.findById(id);
 }

 public Tool save(Tool t) {
  return toolCrudRepository.save(t);
 }
}
