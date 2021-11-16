/*
* Aplicación alquiler de herrmientas 
*  Servicio Tool
 */
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Tool;
import co.usa.ciclo3.ciclo3.model.repository.ToolRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * USA.edu.co Javier Pinillos
 */
@Service
public class ToolService {

    @Autowired
    private ToolRepository toolRepository;

    public List<Tool> getAll() {
        return toolRepository.getAll();
    }

    public Optional<Tool> getTool(int id) {
        return toolRepository.getTool(id);
    }

    public Tool save(Tool t) {
        if (t.getId() == null) {
            return toolRepository.save(t);
        } else {
            Optional<Tool> tAux = toolRepository.getTool(t.getId());
            //if (tAux.isEmpty ()) { //isEmpty no existe
            if (tAux.isPresent()) {
                return toolRepository.save(t);
            } else {
                return t;
            }
        }
    }

    public Tool update(Tool t) {
        if (t.getId() != null) {
            Optional<Tool> mAux = toolRepository.getTool(t.getId());
            if (!mAux.isEmpty()) {
                if (t.getBrand() != null) {
                    mAux.get().setBrand(t.getBrand());
                }
                if (t.getName() != null) {
                    mAux.get().setName(t.getName());
                }
                if (t.getDescription() != null) {
                    mAux.get().setDescription(t.getDescription());
                }
                if (t.getYear() != null) {
                    mAux.get().setYear(t.getYear());
                }
                toolRepository.save(mAux.get());
                return mAux.get();
            } else {
                return t;
            }
        } else {
            return t;
        }
    }

    public boolean delete(int toolId) {
        Boolean mAux = getTool(toolId).map(tool -> {
            toolRepository.delete(tool);
            return true;
        }).orElse(false);
        return mAux;
    }
}
