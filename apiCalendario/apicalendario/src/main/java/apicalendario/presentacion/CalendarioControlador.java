package apicalendario.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import apicalendario.aplicacion.CalendarioServicio;

@RestController
public class CalendarioControlador {

    @Autowired
    private CalendarioServicio calendarioServicio;

    @GetMapping("/calendario")
    public String obtenerCalendario() {
        return calendarioServicio.obtenerMensajeServicio();
    }
}