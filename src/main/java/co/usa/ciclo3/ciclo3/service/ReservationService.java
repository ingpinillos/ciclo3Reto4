/*
* Aplicación alquiler de herrmientas 
*  Servicio Reservation
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.model.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * USA.edu.co Javier Pinillos
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation t) {
        if (t.getIdReservation() == null) {
            return reservationRepository.save(t);
        } else {
            Optional<Reservation> tAux = reservationRepository.getReservation(t.getIdReservation());
            //if (tAux.isEmpty ()) { //isEmpty no existe
            if (tAux.isPresent()) {
                return reservationRepository.save(t);
            } else {
                return t;
            }
        }
    }

    public Reservation update(Reservation r) {
        if (r.getIdReservation() != null) {
            Optional<Reservation> mAux = reservationRepository.getReservation(r.getIdReservation());
            if (!mAux.isEmpty()) {
                if (r.getStartDate() != null) {
                    mAux.get().setStartDate(r.getStartDate());
                }
                if (r.getDevolutionDate() != null) {
                    mAux.get().setDevolutionDate(r.getDevolutionDate());
                }
                reservationRepository.save(mAux.get());
                return mAux.get();
            } else {
                return r;
            }
        } else {
            return r;
        }
    }

    public boolean delete(int reservationId) {
        Boolean mAux = getReservation(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return mAux;
    }
}
