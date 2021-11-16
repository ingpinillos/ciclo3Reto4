/*
* Apliación alquiler de herrmientas 
*  Clase Repositorio Client
 */
package co.usa.ciclo3.ciclo3.model.repository;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.model.repository.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * USA.edu.co Javier Pinillos
 */
@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll() {
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id) {
        return clientCrudRepository.findById(id);
    }

    public Client save(Client c) {
        return clientCrudRepository.save(c);
    }

    public void delete(Client c) {
        clientCrudRepository.delete(c);
    }
}
