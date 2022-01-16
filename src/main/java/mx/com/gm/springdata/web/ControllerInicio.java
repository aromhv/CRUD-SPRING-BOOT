package mx.com.gm.springdata.web;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.springdata.domain.Persona;
import mx.com.gm.springdata.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControllerInicio {

    @Autowired
    private PersonaService personaservice;

    @GetMapping("/")
    public String incio(Model model , @AuthenticationPrincipal User user) {
        var personas = personaservice.listaPersonas();
        log.info("ejecutando el controlador Srpgin MVC");
        log.info("usuario que hizo login"+user);
        model.addAttribute("personas", personas);

        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if (errores.hasErrors()) {
            return "modificar";
        }
        personaservice.guardar(persona);
        return "redirect:/";
        
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
          persona =  personaservice.buscarpersona(persona);
          model.addAttribute("persona", persona);
          return "modificar";
            
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaservice.eliminar(persona);
        return "redirect:/";
    }
    

}
