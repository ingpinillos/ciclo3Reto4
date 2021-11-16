/*
* Apliación alquiler de herrmientas 
*  Clase Repositorio Reservation
*/
package co.usa.ciclo3.ciclo3.model.repository;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.model.repository.crud.ReservationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * USA.edu.co Javier Pinillos
 */
@Repository
public class ReservationRepository {

 @Autowired

 private ReservationCrudRepository reservationCrudRepository;

 public List<Reservation> getAll() {
  return (List<Reservation>) reservationCrudRepository.findAll();
 }

 public Optional<Reservation> getReservation(int id) {
  return reservationCrudRepository.findById(id);
 }

 public Reservation save(Reservation t) {
  return reservationCrudRepository.save(t);
 }
}
