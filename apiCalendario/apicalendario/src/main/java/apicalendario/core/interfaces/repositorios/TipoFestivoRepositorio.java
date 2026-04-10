package apicalendario.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apicalendario.core.dominio.TipoFestivo;

@Repository
public interface TipoFestivoRepositorio extends JpaRepository<TipoFestivo, Long> {
}
