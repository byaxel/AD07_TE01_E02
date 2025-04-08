package dam.ad.ad07_te01_02.domain;

import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedHashMap;
import java.util.Map;

// No incluye propiedades nulas
@JsonInclude(JsonInclude.Include.NON_NULL)

// Orden a la hora de mostrar las propiedades
@JsonPropertyOrder({
        "id",
        "type",
        "geometry",
        "properties"
})

// Representa la colección nombardeosData
@Document(collection = "guerraCivilEuskadi")
public class Bombardeo {
    
    // PROPIEDADES //
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("geometry")
    private Geometry geometry;
    
    @JsonProperty("properties")
    private Properties properties;
    
    // Almacena las propiedades extra que no están declaradas como atributos (campos inesperados)
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    
    // GETTERS & SETTERS //
    @JsonProperty("id")
    public String getId() {
        return id;
    }
    
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }
    
    @JsonProperty("type")
    public String getType() {
        return type;
    }
    
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }
    
    @JsonProperty("geometry")
    public Geometry getGeometry() {
        return geometry;
    }
    
    @JsonProperty("geometry")
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
    
    @JsonProperty("properties")
    public Properties getProperties() {
        return properties;
    }
    
    @JsonProperty("properties")
    public void setProperties(Properties properties) {
        this.properties = properties;
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