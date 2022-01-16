package mx.com.gm.springdata.dao;

import mx.com.gm.springdata.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InterfacePersonaDao extends JpaRepository<Persona,Long> {
    
    
}
