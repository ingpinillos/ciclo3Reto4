/*
* Apliación alquiler de herrmientas 
*  Clase Repositorio Message
 */
package co.usa.ciclo3.ciclo3.model.repository;

import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.model.repository.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * USA.edu.co Javier Pinillos
 */
@Repository
public class MessageRepository {

    @Autowired

    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll() {
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageCrudRepository.findById(id);
    }

    public Message save(Message t) {
        return messageCrudRepository.save(t);
    }
}
