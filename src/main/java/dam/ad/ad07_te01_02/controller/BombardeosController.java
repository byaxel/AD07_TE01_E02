package dam.ad.ad07_te01_02.controller;

import dam.ad.ad07_te01_02.domain.Bombardeo;
import dam.ad.ad07_te01_02.repository.BombardeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bombardeos")
public class BombardeosController {
    
    @Autowired
    BombardeoRepository bombardeoRepository;
    
    // Obtiene todos los bombardeos
    @GetMapping({"/", ""})
    public ResponseEntity<List<Bombardeo>> showAll() {
        try {
            // Recupera todos los bombardeos de la base de datos
            List<Bombardeo> bombardeos = bombardeoRepository.findAll();
            
            // Retorna la lista de bombardeos con el estado HTTP 200 (OK)
            return new ResponseEntity<>(bombardeos, HttpStatus.OK);
            
        } catch (Exception ex) {
            // Imprime el stack trace y devuelve un error 500 (Internal Server Error)
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Obtiene los bombardeos de una localidad específica
    @GetMapping("/byLocalidad/{localidad}")
    public ResponseEntity<List<Bombardeo>> showByLocalidad(@PathVariable("localidad") String localidad) {
        try {
            // Recupera todos los bombardeos de una ciudad
            List<Bombardeo> bombardeos = bombardeoRepository.findByPropertiesLocalidad(localidad);
            
            // Si no obtiene resultados, devuelve un 404 (Not Found)
            if (bombardeos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            
            // Si hay resultado, los devuelve con un estado HTTP 200 (OK)
            return new ResponseEntity<>(bombardeos, HttpStatus.OK);
            
        } catch (Exception ex) {
            // Imprime el stack trace y devuelve un error 500 (Internal Server Error)
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Obtiene los bombardeos de un bando específico
    @GetMapping("/byBando/{bando}")
    public ResponseEntity<List<Bombardeo>> showByBando(@PathVariable("bando") String bando) {
        try {
            // Recupera todos los bombardeos de una ciudad
            List<Bombardeo> bombardeos = bombardeoRepository.findByPropertiesBando(bando);
            
            // Si no obtiene resultados, devuelve un 404 (Not Found)
            if (bombardeos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            
            // Si hay resultado, los devuelve con un estado 200 (OK)
            return new ResponseEntity<>(bombardeos, HttpStatus.OK);
            
        } catch (Exception ex) {
            // Imprime el stack trace y devuelve un error 500 (Internal Server Error)
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
