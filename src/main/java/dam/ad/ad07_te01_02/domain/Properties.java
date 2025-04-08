package dam.ad.ad07_te01_02.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

// No incluye propiedades nulas
//@JsonInclude(JsonInclude.Include.NON_NULL)

// Orden a la hora de mostrar las propiedades
@JsonPropertyOrder({
        "localidad",
        "fechas",
        "bando",
        "numeroBombardeos",
        "descripcion",
        "fuente"
})

public class Properties {
    
    // PROPIEDADES //
    @JsonProperty("localidad")
    private String localidad;
    
    @JsonProperty("numeroBombardeos")
    public String numeroBombardeos;
    
    @JsonProperty("fechas")
    private String fechas;
    
    @JsonProperty("bando")
    private String bando;
    
    @JsonProperty("descripcion")
    private String descripcion;
    
    @JsonProperty("fuente")
    private String fuente;
    
    // Almacena las propiedades extra que no están declaradas como atributos (campos inesperados)
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    
    // GETTERS & SETTERS //
    @JsonProperty("localidad")
    public String getLocalidad() {
        return localidad;
    }
    
    @JsonProperty("localidad")
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    
    @JsonProperty("numeroBombardeos")
    public String getNumeroBombardeos() {
        return numeroBombardeos;
    }
    
    @JsonProperty("numeroBombardeos")
    public void setNumeroBombardeos(String numeroBombardeos) {
        this.numeroBombardeos = numeroBombardeos;
    }
    
    @JsonProperty("fechas")
    public String getFechas() {
        return fechas;
    }
    
    @JsonProperty("fechas")
    public void setFechas(String fechas) {
        this.fechas = fechas;
    }
    
    @JsonProperty("bando")
    public String getBando() {
        return bando;
    }
    
    @JsonProperty("bando")
    public void setBando(String bando) {
        this.bando = bando;
    }
    
    @JsonProperty("descripcion")
    public String getDescripcion() {
        return descripcion;
    }
    
    @JsonProperty("descripcion")
    public void setDescripcion(String descripciN) {
        this.descripcion = descripciN;
    }
    
    @JsonProperty("fuente")
    public String getFuente() {
        return fuente;
    }
    
    @JsonProperty("fuente")
    public void setFuente(String fuente) {
        this.fuente = fuente;
    }
    
    // Incluye las propiedades extra no declaradas como atributos
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    
    // Captura las claves desconocidas no declaradas
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
}