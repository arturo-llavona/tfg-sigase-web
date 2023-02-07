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
 * IncidentePersonaAfectada
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-02-07T18:52:07.490553100+01:00[Europe/Madrid]")
public class IncidentePersonaAfectada {
  public static final String SERIALIZED_NAME_ID_INCIDENTE_PERSONA_AFECTADA = "idIncidentePersonaAfectada";
  @SerializedName(SERIALIZED_NAME_ID_INCIDENTE_PERSONA_AFECTADA)
  private Integer idIncidentePersonaAfectada;

  public static final String SERIALIZED_NAME_FECHA_NACIMIENTO = "fechaNacimiento";
  @SerializedName(SERIALIZED_NAME_FECHA_NACIMIENTO)
  private OffsetDateTime fechaNacimiento;

  public static final String SERIALIZED_NAME_NOMBRE = "nombre";
  @SerializedName(SERIALIZED_NAME_NOMBRE)
  private String nombre;

  public static final String SERIALIZED_NAME_APELLIDOS = "apellidos";
  @SerializedName(SERIALIZED_NAME_APELLIDOS)
  private String apellidos;

  public static final String SERIALIZED_NAME_EDAD = "edad";
  @SerializedName(SERIALIZED_NAME_EDAD)
  private Integer edad;

  public static final String SERIALIZED_NAME_TIPO_EDAD = "tipoEdad";
  @SerializedName(SERIALIZED_NAME_TIPO_EDAD)
  private Integer tipoEdad;

  public static final String SERIALIZED_NAME_SEXO = "sexo";
  @SerializedName(SERIALIZED_NAME_SEXO)
  private Integer sexo;

  public static final String SERIALIZED_NAME_DNI = "dni";
  @SerializedName(SERIALIZED_NAME_DNI)
  private String dni;

  public static final String SERIALIZED_NAME_TELEFONO = "telefono";
  @SerializedName(SERIALIZED_NAME_TELEFONO)
  private String telefono;

  public static final String SERIALIZED_NAME_CENTRO_SALUD = "centroSalud";
  @SerializedName(SERIALIZED_NAME_CENTRO_SALUD)
  private String centroSalud;

  public static final String SERIALIZED_NAME_TARJETA_SANITARIA = "tarjetaSanitaria";
  @SerializedName(SERIALIZED_NAME_TARJETA_SANITARIA)
  private String tarjetaSanitaria;

  public IncidentePersonaAfectada() {
  }

  public IncidentePersonaAfectada idIncidentePersonaAfectada(Integer idIncidentePersonaAfectada) {
    
    this.idIncidentePersonaAfectada = idIncidentePersonaAfectada;
    return this;
  }

   /**
   * Get idIncidentePersonaAfectada
   * @return idIncidentePersonaAfectada
  **/
  @javax.annotation.Nullable

  public Integer getIdIncidentePersonaAfectada() {
    return idIncidentePersonaAfectada;
  }


  public void setIdIncidentePersonaAfectada(Integer idIncidentePersonaAfectada) {
    this.idIncidentePersonaAfectada = idIncidentePersonaAfectada;
  }


  public IncidentePersonaAfectada fechaNacimiento(OffsetDateTime fechaNacimiento) {
    
    this.fechaNacimiento = fechaNacimiento;
    return this;
  }

   /**
   * Get fechaNacimiento
   * @return fechaNacimiento
  **/
  @javax.annotation.Nullable

  public OffsetDateTime getFechaNacimiento() {
    return fechaNacimiento;
  }


  public void setFechaNacimiento(OffsetDateTime fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }


  public IncidentePersonaAfectada nombre(String nombre) {
    
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


  public IncidentePersonaAfectada apellidos(String apellidos) {
    
    this.apellidos = apellidos;
    return this;
  }

   /**
   * Get apellidos
   * @return apellidos
  **/
  @javax.annotation.Nullable

  public String getApellidos() {
    return apellidos;
  }


  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }


  public IncidentePersonaAfectada edad(Integer edad) {
    
    this.edad = edad;
    return this;
  }

   /**
   * Get edad
   * @return edad
  **/
  @javax.annotation.Nullable

  public Integer getEdad() {
    return edad;
  }


  public void setEdad(Integer edad) {
    this.edad = edad;
  }


  public IncidentePersonaAfectada tipoEdad(Integer tipoEdad) {
    
    this.tipoEdad = tipoEdad;
    return this;
  }

   /**
   * Get tipoEdad
   * @return tipoEdad
  **/
  @javax.annotation.Nullable

  public Integer getTipoEdad() {
    return tipoEdad;
  }


  public void setTipoEdad(Integer tipoEdad) {
    this.tipoEdad = tipoEdad;
  }


  public IncidentePersonaAfectada sexo(Integer sexo) {
    
    this.sexo = sexo;
    return this;
  }

   /**
   * Get sexo
   * @return sexo
  **/
  @javax.annotation.Nullable

  public Integer getSexo() {
    return sexo;
  }


  public void setSexo(Integer sexo) {
    this.sexo = sexo;
  }


  public IncidentePersonaAfectada dni(String dni) {
    
    this.dni = dni;
    return this;
  }

   /**
   * Get dni
   * @return dni
  **/
  @javax.annotation.Nullable

  public String getDni() {
    return dni;
  }


  public void setDni(String dni) {
    this.dni = dni;
  }


  public IncidentePersonaAfectada telefono(String telefono) {
    
    this.telefono = telefono;
    return this;
  }

   /**
   * Get telefono
   * @return telefono
  **/
  @javax.annotation.Nullable

  public String getTelefono() {
    return telefono;
  }


  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }


  public IncidentePersonaAfectada centroSalud(String centroSalud) {
    
    this.centroSalud = centroSalud;
    return this;
  }

   /**
   * Get centroSalud
   * @return centroSalud
  **/
  @javax.annotation.Nullable

  public String getCentroSalud() {
    return centroSalud;
  }


  public void setCentroSalud(String centroSalud) {
    this.centroSalud = centroSalud;
  }


  public IncidentePersonaAfectada tarjetaSanitaria(String tarjetaSanitaria) {
    
    this.tarjetaSanitaria = tarjetaSanitaria;
    return this;
  }

   /**
   * Get tarjetaSanitaria
   * @return tarjetaSanitaria
  **/
  @javax.annotation.Nullable

  public String getTarjetaSanitaria() {
    return tarjetaSanitaria;
  }


  public void setTarjetaSanitaria(String tarjetaSanitaria) {
    this.tarjetaSanitaria = tarjetaSanitaria;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IncidentePersonaAfectada incidentePersonaAfectada = (IncidentePersonaAfectada) o;
    return Objects.equals(this.idIncidentePersonaAfectada, incidentePersonaAfectada.idIncidentePersonaAfectada) &&
        Objects.equals(this.fechaNacimiento, incidentePersonaAfectada.fechaNacimiento) &&
        Objects.equals(this.nombre, incidentePersonaAfectada.nombre) &&
        Objects.equals(this.apellidos, incidentePersonaAfectada.apellidos) &&
        Objects.equals(this.edad, incidentePersonaAfectada.edad) &&
        Objects.equals(this.tipoEdad, incidentePersonaAfectada.tipoEdad) &&
        Objects.equals(this.sexo, incidentePersonaAfectada.sexo) &&
        Objects.equals(this.dni, incidentePersonaAfectada.dni) &&
        Objects.equals(this.telefono, incidentePersonaAfectada.telefono) &&
        Objects.equals(this.centroSalud, incidentePersonaAfectada.centroSalud) &&
        Objects.equals(this.tarjetaSanitaria, incidentePersonaAfectada.tarjetaSanitaria);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idIncidentePersonaAfectada, fechaNacimiento, nombre, apellidos, edad, tipoEdad, sexo, dni, telefono, centroSalud, tarjetaSanitaria);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IncidentePersonaAfectada {\n");
    sb.append("    idIncidentePersonaAfectada: ").append(toIndentedString(idIncidentePersonaAfectada)).append("\n");
    sb.append("    fechaNacimiento: ").append(toIndentedString(fechaNacimiento)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    apellidos: ").append(toIndentedString(apellidos)).append("\n");
    sb.append("    edad: ").append(toIndentedString(edad)).append("\n");
    sb.append("    tipoEdad: ").append(toIndentedString(tipoEdad)).append("\n");
    sb.append("    sexo: ").append(toIndentedString(sexo)).append("\n");
    sb.append("    dni: ").append(toIndentedString(dni)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    centroSalud: ").append(toIndentedString(centroSalud)).append("\n");
    sb.append("    tarjetaSanitaria: ").append(toIndentedString(tarjetaSanitaria)).append("\n");
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
    openapiFields.add("idIncidentePersonaAfectada");
    openapiFields.add("fechaNacimiento");
    openapiFields.add("nombre");
    openapiFields.add("apellidos");
    openapiFields.add("edad");
    openapiFields.add("tipoEdad");
    openapiFields.add("sexo");
    openapiFields.add("dni");
    openapiFields.add("telefono");
    openapiFields.add("centroSalud");
    openapiFields.add("tarjetaSanitaria");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to IncidentePersonaAfectada
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!IncidentePersonaAfectada.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in IncidentePersonaAfectada is not found in the empty JSON string", IncidentePersonaAfectada.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!IncidentePersonaAfectada.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `IncidentePersonaAfectada` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("nombre") != null && !jsonObj.get("nombre").isJsonNull()) && !jsonObj.get("nombre").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `nombre` to be a primitive type in the JSON string but got `%s`", jsonObj.get("nombre").toString()));
      }
      if ((jsonObj.get("apellidos") != null && !jsonObj.get("apellidos").isJsonNull()) && !jsonObj.get("apellidos").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `apellidos` to be a primitive type in the JSON string but got `%s`", jsonObj.get("apellidos").toString()));
      }
      if ((jsonObj.get("dni") != null && !jsonObj.get("dni").isJsonNull()) && !jsonObj.get("dni").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `dni` to be a primitive type in the JSON string but got `%s`", jsonObj.get("dni").toString()));
      }
      if ((jsonObj.get("telefono") != null && !jsonObj.get("telefono").isJsonNull()) && !jsonObj.get("telefono").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `telefono` to be a primitive type in the JSON string but got `%s`", jsonObj.get("telefono").toString()));
      }
      if ((jsonObj.get("centroSalud") != null && !jsonObj.get("centroSalud").isJsonNull()) && !jsonObj.get("centroSalud").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `centroSalud` to be a primitive type in the JSON string but got `%s`", jsonObj.get("centroSalud").toString()));
      }
      if ((jsonObj.get("tarjetaSanitaria") != null && !jsonObj.get("tarjetaSanitaria").isJsonNull()) && !jsonObj.get("tarjetaSanitaria").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tarjetaSanitaria` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tarjetaSanitaria").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!IncidentePersonaAfectada.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'IncidentePersonaAfectada' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<IncidentePersonaAfectada> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(IncidentePersonaAfectada.class));

       return (TypeAdapter<T>) new TypeAdapter<IncidentePersonaAfectada>() {
           @Override
           public void write(JsonWriter out, IncidentePersonaAfectada value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public IncidentePersonaAfectada read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of IncidentePersonaAfectada given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of IncidentePersonaAfectada
  * @throws IOException if the JSON string is invalid with respect to IncidentePersonaAfectada
  */
  public static IncidentePersonaAfectada fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, IncidentePersonaAfectada.class);
  }

 /**
  * Convert an instance of IncidentePersonaAfectada to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

