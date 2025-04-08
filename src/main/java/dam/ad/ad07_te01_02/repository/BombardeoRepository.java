package dam.ad.ad07_te01_02.repository;

import dam.ad.ad07_te01_02.domain.Bombardeo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BombardeoRepository extends MongoRepository<Bombardeo, String> {
    
    // Búsqueda por localidad
    List<Bombardeo> findByPropertiesLocalidad(String localidad);
    
    List<Bombardeo> findByPropertiesBando(String bando);
}
