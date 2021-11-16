/*
* Aplicación alquiler de herrmientas 
*  Servicio Message
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.model.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * USA.edu.co Javier Pinillos
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message t) {
        if (t.getIdMessage() == null) {
            return messageRepository.save(t);
        } else {
            Optional<Message> tAux = messageRepository.getMessage(t.getIdMessage());
            //if (tAux.isEmpty ()) { //isEmpty no existe
            if (tAux.isPresent()) {
                return messageRepository.save(t);
            } else {
                return t;
            }
        }
    }
}
