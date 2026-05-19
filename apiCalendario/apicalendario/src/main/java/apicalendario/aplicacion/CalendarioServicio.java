package apicalendario.aplicacion;

import org.springframework.stereotype.Service;

@Service
public class CalendarioServicio {

    public String obtenerMensajeServicio() {
        return "Servicio de calendario laboral activo";
    }
}