/*
* Apliación alquiler de herrmientas 
*  Clase Repositorio CRUD Message
 */
package co.usa.ciclo3.ciclo3.model.repository.crud;

import co.usa.ciclo3.ciclo3.model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * USA.edu.co Javier Pinillos
 */
public interface MessageCrudRepository extends CrudRepository<Message, Integer> {

}
