/*
* Aplicación alquiler de herrmientas 
*  Servicio Client
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.model.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * USA.edu.co Javier Pinillos
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client t) {
        if (t.getIdClient() == null) {
            return clientRepository.save(t);
        } else {
            Optional<Client> tAux = clientRepository.getClient(t.getIdClient());
            //if (tAux.isEmpty ()) { //isEmpty no existe
            if (tAux.isPresent()) {
                return clientRepository.save(t);
            } else {
                return t;
            }
        }
    }
}
