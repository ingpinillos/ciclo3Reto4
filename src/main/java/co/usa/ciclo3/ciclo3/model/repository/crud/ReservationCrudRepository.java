/*
* Apliación alquiler de herrmientas 
*  Clase Repositorio CRUD Reservation
 */
package co.usa.ciclo3.ciclo3.model.repository.crud;

import co.usa.ciclo3.ciclo3.model.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 * USA.edu.co Javier Pinillos
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

}
