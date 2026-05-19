package apicalendario.aplicacion;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class CalendarioServicio {

    public String obtenerMensajeServicio() {
        return "Servicio de calendario laboral activo";
    }

    // Método para validar fechas del calendario
    public boolean validarFecha(LocalDate fecha) {
        return fecha != null && fecha.getYear() > 1900;
    }
}