package apicalendario.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apicalendario.core.dominio.Pais;

@Repository
public interface PaisRepositorio extends JpaRepository<Pais, Long> {
}