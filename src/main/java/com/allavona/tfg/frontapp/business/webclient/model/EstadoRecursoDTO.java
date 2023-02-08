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
import java.time.OffsetDateTime;

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
 * EstadoRecursoDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-02-08T16:32:14.863738400+01:00[Europe/Madrid]")
public class EstadoRecursoDTO {
  public static final String SERIALIZED_NAME_ID_RECURSO_ESTADO = "idRecursoEstado";
  @SerializedName(SERIALIZED_NAME_ID_RECURSO_ESTADO)
  private Integer idRecursoEstado;

  public static final String SERIALIZED_NAME_NOMBRE_ESTADO = "nombreEstado";
  @SerializedName(SERIALIZED_NAME_NOMBRE_ESTADO)
  private String nombreEstado;

  public static final String SERIALIZED_NAME_FECHA_ESTADO = "fechaEstado";
  @SerializedName(SERIALIZED_NAME_FECHA_ESTADO)
  private OffsetDateTime fechaEstado;

  public EstadoRecursoDTO() {
  }

  public EstadoRecursoDTO idRecursoEstado(Integer idRecursoEstado) {
    
    this.idRecursoEstado = idRecursoEstado;
    return this;
  }

   /**
   * Get idRecursoEstado
   * @return idRecursoEstado
  **/
  @javax.annotation.Nullable

  public Integer getIdRecursoEstado() {
    return idRecursoEstado;
  }


  public void setIdRecursoEstado(Integer idRecursoEstado) {
    this.idRecursoEstado = idRecursoEstado;
  }


  public EstadoRecursoDTO nombreEstado(String nombreEstado) {
    
    this.nombreEstado = nombreEstado;
    return this;
  }

   /**
   * Get nombreEstado
   * @return nombreEstado
  **/
  @javax.annotation.Nullable

  public String getNombreEstado() {
    return nombreEstado;
  }


  public void setNombreEstado(String nombreEstado) {
    this.nombreEstado = nombreEstado;
  }


  public EstadoRecursoDTO fechaEstado(OffsetDateTime fechaEstado) {
    
    this.fechaEstado = fechaEstado;
    return this;
  }

   /**
   * Get fechaEstado
   * @return fechaEstado
  **/
  @javax.annotation.Nullable

  public OffsetDateTime getFechaEstado() {
    return fechaEstado;
  }


  public void setFechaEstado(OffsetDateTime fechaEstado) {
    this.fechaEstado = fechaEstado;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EstadoRecursoDTO estadoRecursoDTO = (EstadoRecursoDTO) o;
    return Objects.equals(this.idRecursoEstado, estadoRecursoDTO.idRecursoEstado) &&
        Objects.equals(this.nombreEstado, estadoRecursoDTO.nombreEstado) &&
        Objects.equals(this.fechaEstado, estadoRecursoDTO.fechaEstado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idRecursoEstado, nombreEstado, fechaEstado);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EstadoRecursoDTO {\n");
    sb.append("    idRecursoEstado: ").append(toIndentedString(idRecursoEstado)).append("\n");
    sb.append("    nombreEstado: ").append(toIndentedString(nombreEstado)).append("\n");
    sb.append("    fechaEstado: ").append(toIndentedString(fechaEstado)).append("\n");
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
    openapiFields.add("idRecursoEstado");
    openapiFields.add("nombreEstado");
    openapiFields.add("fechaEstado");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to EstadoRecursoDTO
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!EstadoRecursoDTO.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in EstadoRecursoDTO is not found in the empty JSON string", EstadoRecursoDTO.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!EstadoRecursoDTO.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `EstadoRecursoDTO` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("nombreEstado") != null && !jsonObj.get("nombreEstado").isJsonNull()) && !jsonObj.get("nombreEstado").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `nombreEstado` to be a primitive type in the JSON string but got `%s`", jsonObj.get("nombreEstado").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!EstadoRecursoDTO.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'EstadoRecursoDTO' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<EstadoRecursoDTO> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(EstadoRecursoDTO.class));

       return (TypeAdapter<T>) new TypeAdapter<EstadoRecursoDTO>() {
           @Override
           public void write(JsonWriter out, EstadoRecursoDTO value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public EstadoRecursoDTO read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of EstadoRecursoDTO given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of EstadoRecursoDTO
  * @throws IOException if the JSON string is invalid with respect to EstadoRecursoDTO
  */
  public static EstadoRecursoDTO fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, EstadoRecursoDTO.class);
  }

 /**
  * Convert an instance of EstadoRecursoDTO to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
