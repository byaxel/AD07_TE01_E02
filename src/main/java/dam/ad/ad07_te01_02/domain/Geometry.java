package dam.ad.ad07_te01_02.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// No incluye propiedades nulas
@JsonInclude(JsonInclude.Include.NON_NULL)

// Orden a la hora de mostrar las propiedades
@JsonPropertyOrder({
        "type",
        "coordinates"
})

public class Geometry {
    
    // PROPIEDADES //
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("coordinates")
    private List<Double> coordinates;
    
    // Almacena las propiedades extra que no están declaradas como atributos (campos inesperados)
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    
    // GETTERS & SETTERS //
    @JsonProperty("type")
    public String getType() {
        return type;
    }
    
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }
    
    @JsonProperty("coordinates")
    public List<Double> getCoordinates() {
        return coordinates;
    }
    
    @JsonProperty("coordinates")
    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
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