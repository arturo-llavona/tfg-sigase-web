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
 * ClasificacionIncidente
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-02-07T18:52:07.490553100+01:00[Europe/Madrid]")
public class ClasificacionIncidente {
  public static final String SERIALIZED_NAME_ID_CLASIFICACION_INCIDENTE = "idClasificacionIncidente";
  @SerializedName(SERIALIZED_NAME_ID_CLASIFICACION_INCIDENTE)
  private Integer idClasificacionIncidente;

  public static final String SERIALIZED_NAME_CODIGO = "codigo";
  @SerializedName(SERIALIZED_NAME_CODIGO)
  private String codigo;

  public static final String SERIALIZED_NAME_NOMBRE = "nombre";
  @SerializedName(SERIALIZED_NAME_NOMBRE)
  private String nombre;

  public ClasificacionIncidente() {
  }

  public ClasificacionIncidente idClasificacionIncidente(Integer idClasificacionIncidente) {
    
    this.idClasificacionIncidente = idClasificacionIncidente;
    return this;
  }

   /**
   * Get idClasificacionIncidente
   * @return idClasificacionIncidente
  **/
  @javax.annotation.Nullable

  public Integer getIdClasificacionIncidente() {
    return idClasificacionIncidente;
  }


  public void setIdClasificacionIncidente(Integer idClasificacionIncidente) {
    this.idClasificacionIncidente = idClasificacionIncidente;
  }


  public ClasificacionIncidente codigo(String codigo) {
    
    this.codigo = codigo;
    return this;
  }

   /**
   * Get codigo
   * @return codigo
  **/
  @javax.annotation.Nullable

  public String getCodigo() {
    return codigo;
  }


  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }


  public ClasificacionIncidente nombre(String nombre) {
    
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



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClasificacionIncidente clasificacionIncidente = (ClasificacionIncidente) o;
    return Objects.equals(this.idClasificacionIncidente, clasificacionIncidente.idClasificacionIncidente) &&
        Objects.equals(this.codigo, clasificacionIncidente.codigo) &&
        Objects.equals(this.nombre, clasificacionIncidente.nombre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idClasificacionIncidente, codigo, nombre);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClasificacionIncidente {\n");
    sb.append("    idClasificacionIncidente: ").append(toIndentedString(idClasificacionIncidente)).append("\n");
    sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
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
    openapiFields.add("idClasificacionIncidente");
    openapiFields.add("codigo");
    openapiFields.add("nombre");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to ClasificacionIncidente
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ClasificacionIncidente.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ClasificacionIncidente is not found in the empty JSON string", ClasificacionIncidente.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!ClasificacionIncidente.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ClasificacionIncidente` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("codigo") != null && !jsonObj.get("codigo").isJsonNull()) && !jsonObj.get("codigo").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `codigo` to be a primitive type in the JSON string but got `%s`", jsonObj.get("codigo").toString()));
      }
      if ((jsonObj.get("nombre") != null && !jsonObj.get("nombre").isJsonNull()) && !jsonObj.get("nombre").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `nombre` to be a primitive type in the JSON string but got `%s`", jsonObj.get("nombre").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ClasificacionIncidente.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ClasificacionIncidente' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ClasificacionIncidente> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ClasificacionIncidente.class));

       return (TypeAdapter<T>) new TypeAdapter<ClasificacionIncidente>() {
           @Override
           public void write(JsonWriter out, ClasificacionIncidente value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ClasificacionIncidente read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ClasificacionIncidente given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ClasificacionIncidente
  * @throws IOException if the JSON string is invalid with respect to ClasificacionIncidente
  */
  public static ClasificacionIncidente fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ClasificacionIncidente.class);
  }

 /**
  * Convert an instance of ClasificacionIncidente to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

