package apicalendario.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import apicalendario.core.interfaces.servicios.IFestivoServicio;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/calendario")
public class CalendarioController {

    @Autowired
    private IFestivoServicio festivoServicio;

    @GetMapping("/es-festivo")
    public boolean esFestivo(
            @RequestParam String fecha,
            @RequestParam Long paisId) {

        return festivoServicio.esFestivo(
                paisId,
                LocalDate.parse(fecha)
        );
    }

    @GetMapping("/festivos")
    public List<LocalDate> festivos(
            @RequestParam int anio,
            @RequestParam Long paisId) {

        return festivoServicio
                .listarFechasFestivasPorPaisYAnio(
                        paisId,
                        anio
                );
    }
}