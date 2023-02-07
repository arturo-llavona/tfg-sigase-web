/*
 * OpenAPI definition
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.allavona.tfg.frontapp.business.webclient.model;

import java.util.Objects;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import com.allavona.tfg.frontapp.business.webclient.JSON;

/**
 * RecursoDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-02-07T16:34:55.215125800+01:00[Europe/Madrid]")
public class RecursoDTO {
  public static final String SERIALIZED_NAME_ID_RECURSO = "idRecurso";
  @SerializedName(SERIALIZED_NAME_ID_RECURSO)
  private Integer idRecurso;

  public static final String SERIALIZED_NAME_TIPO_RECURSO = "tipoRecurso";
  @SerializedName(SERIALIZED_NAME_TIPO_RECURSO)
  private TipoRecursoDTO tipoRecurso;

  public static final String SERIALIZED_NAME_NOMBRE = "nombre";
  @SerializedName(SERIALIZED_NAME_NOMBRE)
  private String nombre;

  public static final String SERIALIZED_NAME_ES_CONSULTA_SANITARIA = "esConsultaSanitaria";
  @SerializedName(SERIALIZED_NAME_ES_CONSULTA_SANITARIA)
  private Boolean esConsultaSanitaria;

  public static final String SERIALIZED_NAME_HABILITADO = "habilitado";
  @SerializedName(SERIALIZED_NAME_HABILITADO)
  private Boolean habilitado;

  public static final String SERIALIZED_NAME_ESTADO = "estado";
  @SerializedName(SERIALIZED_NAME_ESTADO)
  private EstadoRecursoDTO estado;

  public RecursoDTO() {
  }

  public RecursoDTO idRecurso(Integer idRecurso) {
    
    this.idRecurso = idRecurso;
    return this;
  }

   /**
   * Get idRecurso
   * @return idRecurso
  **/
  @javax.annotation.Nullable

  public Integer getIdRecurso() {
    return idRecurso;
  }


  public void setIdRecurso(Integer idRecurso) {
    this.idRecurso = idRecurso;
  }


  public RecursoDTO tipoRecurso(TipoRecursoDTO tipoRecurso) {
    
    this.tipoRecurso = tipoRecurso;
    return this;
  }

   /**
   * Get tipoRecurso
   * @return tipoRecurso
  **/
  @javax.annotation.Nullable

  public TipoRecursoDTO getTipoRecurso() {
    return tipoRecurso;
  }


  public void setTipoRecurso(TipoRecursoDTO tipoRecurso) {
    this.tipoRecurso = tipoRecurso;
  }


  public RecursoDTO nombre(String nombre) {
    
    this.nombre = nombre;
    return this;
  }

   /**
   * Get nombre
   * @return nombre
  **/
  @javax.annotation.Nullable

  public String getNombre() {
    return nombre;
  }


  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  public RecursoDTO esConsultaSanitaria(Boolean esConsultaSanitaria) {
    
    this.esConsultaSanitaria = esConsultaSanitaria;
    return this;
  }

   /**
   * Get esConsultaSanitaria
   * @return esConsultaSanitaria
  **/
  @javax.annotation.Nullable

  public Boolean getEsConsultaSanitaria() {
    return esConsultaSanitaria;
  }


  public void setEsConsultaSanitaria(Boolean esConsultaSanitaria) {
    this.esConsultaSanitaria = esConsultaSanitaria;
  }


  public RecursoDTO habilitado(Boolean habilitado) {
    
    this.habilitado = habilitado;
    return this;
  }

   /**
   * Get habilitado
   * @return habilitado
  **/
  @javax.annotation.Nullable

  public Boolean getHabilitado() {
    return habilitado;
  }


  public void setHabilitado(Boolean habilitado) {
    this.habilitado = habilitado;
  }


  public RecursoDTO estado(EstadoRecursoDTO estado) {
    
    this.estado = estado;
    return this;
  }

   /**
   * Get estado
   * @return estado
  **/
  @javax.annotation.Nullable

  public EstadoRecursoDTO getEstado() {
    return estado;
  }


  public void setEstado(EstadoRecursoDTO estado) {
    this.estado = estado;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecursoDTO recursoDTO = (RecursoDTO) o;
    return Objects.equals(this.idRecurso, recursoDTO.idRecurso) &&
        Objects.equals(this.tipoRecurso, recursoDTO.tipoRecurso) &&
        Objects.equals(this.nombre, recursoDTO.nombre) &&
        Objects.equals(this.esConsultaSanitaria, recursoDTO.esConsultaSanitaria) &&
        Objects.equals(this.habilitado, recursoDTO.habilitado) &&
        Objects.equals(this.estado, recursoDTO.estado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idRecurso, tipoRecurso, nombre, esConsultaSanitaria, habilitado, estado);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecursoDTO {\n");
    sb.append("    idRecurso: ").append(toIndentedString(idRecurso)).append("\n");
    sb.append("    tipoRecurso: ").append(toIndentedString(tipoRecurso)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    esConsultaSanitaria: ").append(toIndentedString(esConsultaSanitaria)).append("\n");
    sb.append("    habilitado: ").append(toIndentedString(habilitado)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("idRecurso");
    openapiFields.add("tipoRecurso");
    openapiFields.add("nombre");
    openapiFields.add("esConsultaSanitaria");
    openapiFields.add("habilitado");
    openapiFields.add("estado");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RecursoDTO
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RecursoDTO.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RecursoDTO is not found in the empty JSON string", RecursoDTO.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RecursoDTO.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RecursoDTO` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      // validate the optional field `tipoRecurso`
      if (jsonObj.get("tipoRecurso") != null && !jsonObj.get("tipoRecurso").isJsonNull()) {
        TipoRecursoDTO.validateJsonObject(jsonObj.getAsJsonObject("tipoRecurso"));
      }
      if ((jsonObj.get("nombre") != null && !jsonObj.get("nombre").isJsonNull()) && !jsonObj.get("nombre").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `nombre` to be a primitive type in the JSON string but got `%s`", jsonObj.get("nombre").toString()));
      }
      // validate the optional field `estado`
      if (jsonObj.get("estado") != null && !jsonObj.get("estado").isJsonNull()) {
        EstadoRecursoDTO.validateJsonObject(jsonObj.getAsJsonObject("estado"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RecursoDTO.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RecursoDTO' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RecursoDTO> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RecursoDTO.class));

       return (TypeAdapter<T>) new TypeAdapter<RecursoDTO>() {
           @Override
           public void write(JsonWriter out, RecursoDTO value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RecursoDTO read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RecursoDTO given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RecursoDTO
  * @throws IOException if the JSON string is invalid with respect to RecursoDTO
  */
  public static RecursoDTO fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RecursoDTO.class);
  }

 /**
  * Convert an instance of RecursoDTO to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

