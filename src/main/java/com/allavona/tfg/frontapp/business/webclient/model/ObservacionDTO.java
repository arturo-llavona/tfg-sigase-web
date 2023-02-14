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
import com.allavona.tfg.frontapp.business.webclient.model.UsuarioDTO;

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
 * ObservacionDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-02-14T18:29:17.023612800+01:00[Europe/Madrid]")
public class ObservacionDTO {
  public static final String SERIALIZED_NAME_ID_OBSERVACION = "idObservacion";
  @SerializedName(SERIALIZED_NAME_ID_OBSERVACION)
  private Integer idObservacion;

  public static final String SERIALIZED_NAME_ID_INCIDENTE = "idIncidente";
  @SerializedName(SERIALIZED_NAME_ID_INCIDENTE)
  private Integer idIncidente;

  public static final String SERIALIZED_NAME_USUARIO = "usuario";
  @SerializedName(SERIALIZED_NAME_USUARIO)
  private UsuarioDTO usuario;

  public static final String SERIALIZED_NAME_TEXTO = "texto";
  @SerializedName(SERIALIZED_NAME_TEXTO)
  private String texto;

  public static final String SERIALIZED_NAME_FECHA = "fecha";
  @SerializedName(SERIALIZED_NAME_FECHA)
  private OffsetDateTime fecha;

  public static final String SERIALIZED_NAME_DATOS_MEDICOS = "datosMedicos";
  @SerializedName(SERIALIZED_NAME_DATOS_MEDICOS)
  private Boolean datosMedicos;

  public ObservacionDTO() {
  }

  public ObservacionDTO idObservacion(Integer idObservacion) {
    
    this.idObservacion = idObservacion;
    return this;
  }

   /**
   * Get idObservacion
   * @return idObservacion
  **/
  @javax.annotation.Nullable

  public Integer getIdObservacion() {
    return idObservacion;
  }


  public void setIdObservacion(Integer idObservacion) {
    this.idObservacion = idObservacion;
  }


  public ObservacionDTO idIncidente(Integer idIncidente) {
    
    this.idIncidente = idIncidente;
    return this;
  }

   /**
   * Get idIncidente
   * @return idIncidente
  **/
  @javax.annotation.Nullable

  public Integer getIdIncidente() {
    return idIncidente;
  }


  public void setIdIncidente(Integer idIncidente) {
    this.idIncidente = idIncidente;
  }


  public ObservacionDTO usuario(UsuarioDTO usuario) {
    
    this.usuario = usuario;
    return this;
  }

   /**
   * Get usuario
   * @return usuario
  **/
  @javax.annotation.Nullable

  public UsuarioDTO getUsuario() {
    return usuario;
  }


  public void setUsuario(UsuarioDTO usuario) {
    this.usuario = usuario;
  }


  public ObservacionDTO texto(String texto) {
    
    this.texto = texto;
    return this;
  }

   /**
   * Get texto
   * @return texto
  **/
  @javax.annotation.Nullable

  public String getTexto() {
    return texto;
  }


  public void setTexto(String texto) {
    this.texto = texto;
  }


  public ObservacionDTO fecha(OffsetDateTime fecha) {
    
    this.fecha = fecha;
    return this;
  }

   /**
   * Get fecha
   * @return fecha
  **/
  @javax.annotation.Nullable

  public OffsetDateTime getFecha() {
    return fecha;
  }


  public void setFecha(OffsetDateTime fecha) {
    this.fecha = fecha;
  }


  public ObservacionDTO datosMedicos(Boolean datosMedicos) {
    
    this.datosMedicos = datosMedicos;
    return this;
  }

   /**
   * Get datosMedicos
   * @return datosMedicos
  **/
  @javax.annotation.Nullable

  public Boolean getDatosMedicos() {
    return datosMedicos;
  }


  public void setDatosMedicos(Boolean datosMedicos) {
    this.datosMedicos = datosMedicos;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObservacionDTO observacionDTO = (ObservacionDTO) o;
    return Objects.equals(this.idObservacion, observacionDTO.idObservacion) &&
        Objects.equals(this.idIncidente, observacionDTO.idIncidente) &&
        Objects.equals(this.usuario, observacionDTO.usuario) &&
        Objects.equals(this.texto, observacionDTO.texto) &&
        Objects.equals(this.fecha, observacionDTO.fecha) &&
        Objects.equals(this.datosMedicos, observacionDTO.datosMedicos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idObservacion, idIncidente, usuario, texto, fecha, datosMedicos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservacionDTO {\n");
    sb.append("    idObservacion: ").append(toIndentedString(idObservacion)).append("\n");
    sb.append("    idIncidente: ").append(toIndentedString(idIncidente)).append("\n");
    sb.append("    usuario: ").append(toIndentedString(usuario)).append("\n");
    sb.append("    texto: ").append(toIndentedString(texto)).append("\n");
    sb.append("    fecha: ").append(toIndentedString(fecha)).append("\n");
    sb.append("    datosMedicos: ").append(toIndentedString(datosMedicos)).append("\n");
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
    openapiFields.add("idObservacion");
    openapiFields.add("idIncidente");
    openapiFields.add("usuario");
    openapiFields.add("texto");
    openapiFields.add("fecha");
    openapiFields.add("datosMedicos");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to ObservacionDTO
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ObservacionDTO.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ObservacionDTO is not found in the empty JSON string", ObservacionDTO.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!ObservacionDTO.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ObservacionDTO` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      // validate the optional field `usuario`
      if (jsonObj.get("usuario") != null && !jsonObj.get("usuario").isJsonNull()) {
        UsuarioDTO.validateJsonObject(jsonObj.getAsJsonObject("usuario"));
      }
      if ((jsonObj.get("texto") != null && !jsonObj.get("texto").isJsonNull()) && !jsonObj.get("texto").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `texto` to be a primitive type in the JSON string but got `%s`", jsonObj.get("texto").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ObservacionDTO.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ObservacionDTO' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ObservacionDTO> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ObservacionDTO.class));

       return (TypeAdapter<T>) new TypeAdapter<ObservacionDTO>() {
           @Override
           public void write(JsonWriter out, ObservacionDTO value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ObservacionDTO read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ObservacionDTO given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ObservacionDTO
  * @throws IOException if the JSON string is invalid with respect to ObservacionDTO
  */
  public static ObservacionDTO fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ObservacionDTO.class);
  }

 /**
  * Convert an instance of ObservacionDTO to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

