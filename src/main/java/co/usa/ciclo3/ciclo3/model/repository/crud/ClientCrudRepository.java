/*
* Apliación alquiler de herrmientas 
*  Clase Repositorio CRUD Client
 */
package co.usa.ciclo3.ciclo3.model.repository.crud;

import co.usa.ciclo3.ciclo3.model.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * USA.edu.co Javier Pinillos
 */
public interface ClientCrudRepository extends CrudRepository<Client, Integer> {

}
