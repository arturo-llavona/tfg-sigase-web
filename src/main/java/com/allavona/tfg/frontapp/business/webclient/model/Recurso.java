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
import lombok.Data;

/**
 * Recurso
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-02-07T16:34:55.215125800+01:00[Europe/Madrid]")
@Data
public class Recurso {
  public static final String SERIALIZED_NAME_ID_RECURSO = "idRecurso";
  @SerializedName(SERIALIZED_NAME_ID_RECURSO)
  private Integer idRecurso;

  public static final String SERIALIZED_NAME_TIPO_RECURSO = "tipoRecurso";
  @SerializedName(SERIALIZED_NAME_TIPO_RECURSO)
  private TipoRecurso tipoRecurso;

  public static final String SERIALIZED_NAME_NOMBRE = "nombre";
  @SerializedName(SERIALIZED_NAME_NOMBRE)
  private String nombre;

  public static final String SERIALIZED_NAME_ES_CONSULTA_SANITARIA = "esConsultaSanitaria";
  @SerializedName(SERIALIZED_NAME_ES_CONSULTA_SANITARIA)
  private Boolean esConsultaSanitaria;

  public static final String SERIALIZED_NAME_HABILITADO = "habilitado";
  @SerializedName(SERIALIZED_NAME_HABILITADO)
  private Boolean habilitado;

  public Recurso() {
  }

  public Recurso idRecurso(Integer idRecurso) {
    
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


  public Recurso tipoRecurso(TipoRecurso tipoRecurso) {
    
    this.tipoRecurso = tipoRecurso;
    return this;
  }

   /**
   * Get tipoRecurso
   * @return tipoRecurso
  **/
  @javax.annotation.Nullable

  public TipoRecurso getTipoRecurso() {
    return tipoRecurso;
  }


  public void setTipoRecurso(TipoRecurso tipoRecurso) {
    this.tipoRecurso = tipoRecurso;
  }


  public Recurso nombre(String nombre) {
    
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


  public Recurso esConsultaSanitaria(Boolean esConsultaSanitaria) {
    
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


  public Recurso habilitado(Boolean habilitado) {
    
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
    Recurso recurso = (Recurso) o;
    return Objects.equals(this.idRecurso, recurso.idRecurso) &&
        Objects.equals(this.tipoRecurso, recurso.tipoRecurso) &&
        Objects.equals(this.nombre, recurso.nombre) &&
        Objects.equals(this.esConsultaSanitaria, recurso.esConsultaSanitaria) &&
        Objects.equals(this.habilitado, recurso.habilitado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idRecurso, tipoRecurso, nombre, esConsultaSanitaria, habilitado);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Recurso {\n");
    sb.append("    idRecurso: ").append(toIndentedString(idRecurso)).append("\n");
    sb.append("    tipoRecurso: ").append(toIndentedString(tipoRecurso)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    esConsultaSanitaria: ").append(toIndentedString(esConsultaSanitaria)).append("\n");
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
    openapiFields.add("idRecurso");
    openapiFields.add("tipoRecurso");
    openapiFields.add("nombre");
    openapiFields.add("esConsultaSanitaria");
    openapiFields.add("habilitado");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to Recurso
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!Recurso.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Recurso is not found in the empty JSON string", Recurso.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!Recurso.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Recurso` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      // validate the optional field `tipoRecurso`
      if (jsonObj.get("tipoRecurso") != null && !jsonObj.get("tipoRecurso").isJsonNull()) {
        TipoRecurso.validateJsonObject(jsonObj.getAsJsonObject("tipoRecurso"));
      }
      if ((jsonObj.get("nombre") != null && !jsonObj.get("nombre").isJsonNull()) && !jsonObj.get("nombre").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `nombre` to be a primitive type in the JSON string but got `%s`", jsonObj.get("nombre").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Recurso.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Recurso' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Recurso> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Recurso.class));

       return (TypeAdapter<T>) new TypeAdapter<Recurso>() {
           @Override
           public void write(JsonWriter out, Recurso value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Recurso read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of Recurso given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Recurso
  * @throws IOException if the JSON string is invalid with respect to Recurso
  */
  public static Recurso fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Recurso.class);
  }

 /**
  * Convert an instance of Recurso to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

