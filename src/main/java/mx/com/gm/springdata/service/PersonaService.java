package mx.com.gm.springdata.service;

import java.util.List;
import mx.com.gm.springdata.domain.Persona;

public interface PersonaService {

    public List<Persona> listaPersonas();
    
    public void guardar(Persona persona);

    public void eliminar(Persona persona);

    public Persona buscarpersona(Persona persona);
}
