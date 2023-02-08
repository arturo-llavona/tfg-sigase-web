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
 * TipoRecursoDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-02-08T16:32:14.863738400+01:00[Europe/Madrid]")
public class TipoRecursoDTO {
  public static final String SERIALIZED_NAME_ID_TIPO_RECURSO = "idTipoRecurso";
  @SerializedName(SERIALIZED_NAME_ID_TIPO_RECURSO)
  private Integer idTipoRecurso;

  public static final String SERIALIZED_NAME_NOMBRE = "nombre";
  @SerializedName(SERIALIZED_NAME_NOMBRE)
  private String nombre;

  public static final String SERIALIZED_NAME_HABILITADO = "habilitado";
  @SerializedName(SERIALIZED_NAME_HABILITADO)
  private Boolean habilitado;

  public TipoRecursoDTO() {
  }

  public TipoRecursoDTO idTipoRecurso(Integer idTipoRecurso) {
    
    this.idTipoRecurso = idTipoRecurso;
    return this;
  }

   /**
   * Get idTipoRecurso
   * @return idTipoRecurso
  **/
  @javax.annotation.Nullable

  public Integer getIdTipoRecurso() {
    return idTipoRecurso;
  }


  public void setIdTipoRecurso(Integer idTipoRecurso) {
    this.idTipoRecurso = idTipoRecurso;
  }


  public TipoRecursoDTO nombre(String nombre) {
    
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


  public TipoRecursoDTO habilitado(Boolean habilitado) {
    
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



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TipoRecursoDTO tipoRecursoDTO = (TipoRecursoDTO) o;
    return Objects.equals(this.idTipoRecurso, tipoRecursoDTO.idTipoRecurso) &&
        Objects.equals(this.nombre, tipoRecursoDTO.nombre) &&
        Objects.equals(this.habilitado, tipoRecursoDTO.habilitado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idTipoRecurso, nombre, habilitado);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TipoRecursoDTO {\n");
    sb.append("    idTipoRecurso: ").append(toIndentedString(idTipoRecurso)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    habilitado: ").append(toIndentedString(habilitado)).append("\n");
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
    openapiFields.add("idTipoRecurso");
    openapiFields.add("nombre");
    openapiFields.add("habilitado");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to TipoRecursoDTO
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!TipoRecursoDTO.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TipoRecursoDTO is not found in the empty JSON string", TipoRecursoDTO.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!TipoRecursoDTO.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TipoRecursoDTO` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("nombre") != null && !jsonObj.get("nombre").isJsonNull()) && !jsonObj.get("nombre").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `nombre` to be a primitive type in the JSON string but got `%s`", jsonObj.get("nombre").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TipoRecursoDTO.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TipoRecursoDTO' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TipoRecursoDTO> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TipoRecursoDTO.class));

       return (TypeAdapter<T>) new TypeAdapter<TipoRecursoDTO>() {
           @Override
           public void write(JsonWriter out, TipoRecursoDTO value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TipoRecursoDTO read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of TipoRecursoDTO given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of TipoRecursoDTO
  * @throws IOException if the JSON string is invalid with respect to TipoRecursoDTO
  */
  public static TipoRecursoDTO fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TipoRecursoDTO.class);
  }

 /**
  * Convert an instance of TipoRecursoDTO to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

