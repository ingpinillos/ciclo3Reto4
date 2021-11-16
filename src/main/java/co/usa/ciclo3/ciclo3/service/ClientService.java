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

    public Client save(Client c) {
        if (c.getIdClient() == null) {
            return clientRepository.save(c);
        } else {
            Optional<Client> cAux = clientRepository.getClient(c.getIdClient());
            //if (tAux.isEmpty ()) { //isEmpty no existe
            if (cAux.isPresent()) {
                return clientRepository.save(c);
            } else {
                return c;
            }
        }
    }

    public Client update(Client c) {
        if (c.getIdClient() != null) {
            Optional<Client> cAux = clientRepository.getClient(c.getIdClient());
            if (!cAux.isEmpty()) {
                if (c.getName() != null) {
                    cAux.get().setName(c.getName());
                }
                if (c.getAge() != null) {
                    cAux.get().setAge(c.getAge());
                }
                if (c.getPassword() != null) {
                    cAux.get().setPassword(c.getPassword());
                }
                clientRepository.save(cAux.get());
                return cAux.get();
            } else {
                return c;
            }
        } else {
            return c;
        }
    }

    public boolean delete(int clientId) {
        Boolean cAux = getClient(clientId).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return cAux;
    }
}
