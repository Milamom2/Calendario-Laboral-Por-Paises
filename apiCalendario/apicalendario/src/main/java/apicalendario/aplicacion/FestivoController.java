package apicalendario.aplicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import apicalendario.core.dominio.Festivo;
import apicalendario.core.interfaces.servicios.IFestivoServicio;

import java.util.List;
@RestController
@RequestMapping("/api/festivos")
public class FestivoController {

    @Autowired
    private IFestivoServicio servicio;

    @GetMapping
    public List<Festivo> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Festivo obtener(@PathVariable Long id) {
        return servicio.obtenerPorId(id);
    }

    @PostMapping
    public Festivo crear(@RequestBody Festivo festivo) {
        return servicio.guardar(festivo);
    }

    @PutMapping("/{id}")
    public Festivo actualizar(@PathVariable Long id, @RequestBody Festivo festivo) {
        return servicio.actualizar(id, festivo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}