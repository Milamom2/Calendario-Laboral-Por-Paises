package apicalendario.core.interfaces.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apicalendario.core.dominio.Festivo;

@Repository
public interface FestivoRepositorio extends JpaRepository<Festivo, Long> {
    List<Festivo> findByPaisId(Long idPais);
}
