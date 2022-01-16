package mx.com.gm.springdata.service;

import java.util.List;
import mx.com.gm.springdata.dao.InterfacePersonaDao;
import mx.com.gm.springdata.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImp implements PersonaService {

    @Autowired
    private InterfacePersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listaPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional

    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona buscarpersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }

}
