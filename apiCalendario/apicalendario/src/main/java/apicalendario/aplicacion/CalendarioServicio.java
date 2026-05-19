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

    if (fecha == null) {
        throw new RuntimeException("La fecha no puede ser nula");
    }

    if (fecha.getYear() < 1900) {
        throw new RuntimeException("La fecha ingresada no es válida");
    }

    return true;
}
}