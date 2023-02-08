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
 * Usuario
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-02-08T16:32:14.863738400+01:00[Europe/Madrid]")
public class Usuario {
  public static final String SERIALIZED_NAME_ID_USUARIO = "idUsuario";
  @SerializedName(SERIALIZED_NAME_ID_USUARIO)
  private Integer idUsuario;

  public static final String SERIALIZED_NAME_NOMBRE = "nombre";
  @SerializedName(SERIALIZED_NAME_NOMBRE)
  private String nombre;

  public static final String SERIALIZED_NAME_APELLIDO1 = "apellido1";
  @SerializedName(SERIALIZED_NAME_APELLIDO1)
  private String apellido1;

  public static final String SERIALIZED_NAME_APELLIDO2 = "apellido2";
  @SerializedName(SERIALIZED_NAME_APELLIDO2)
  private String apellido2;

  public static final String SERIALIZED_NAME_EMAIL = "email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  public static final String SERIALIZED_NAME_EXTENSION = "extension";
  @SerializedName(SERIALIZED_NAME_EXTENSION)
  private String extension;

  public static final String SERIALIZED_NAME_TIPO_USUARIO = "tipoUsuario";
  @SerializedName(SERIALIZED_NAME_TIPO_USUARIO)
  private Integer tipoUsuario;

  public static final String SERIALIZED_NAME_USERNAME = "username";
  @SerializedName(SERIALIZED_NAME_USERNAME)
  private String username;

  public static final String SERIALIZED_NAME_PASSWORD = "password";
  @SerializedName(SERIALIZED_NAME_PASSWORD)
  private String password;

  public static final String SERIALIZED_NAME_HABILITADO = "habilitado";
  @SerializedName(SERIALIZED_NAME_HABILITADO)
  private Boolean habilitado;

  public Usuario() {
  }

  public Usuario idUsuario(Integer idUsuario) {
    
    this.idUsuario = idUsuario;
    return this;
  }

   /**
   * Get idUsuario
   * @return idUsuario
  **/
  @javax.annotation.Nullable

  public Integer getIdUsuario() {
    return idUsuario;
  }


  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }


  public Usuario nombre(String nombre) {
    
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


  public Usuario apellido1(String apellido1) {
    
    this.apellido1 = apellido1;
    return this;
  }

   /**
   * Get apellido1
   * @return apellido1
  **/
  @javax.annotation.Nullable

  public String getApellido1() {
    return apellido1;
  }


  public void setApellido1(String apellido1) {
    this.apellido1 = apellido1;
  }


  public Usuario apellido2(String apellido2) {
    
    this.apellido2 = apellido2;
    return this;
  }

   /**
   * Get apellido2
   * @return apellido2
  **/
  @javax.annotation.Nullable

  public String getApellido2() {
    return apellido2;
  }


  public void setApellido2(String apellido2) {
    this.apellido2 = apellido2;
  }


  public Usuario email(String email) {
    
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @javax.annotation.Nullable

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public Usuario extension(String extension) {
    
    this.extension = extension;
    return this;
  }

   /**
   * Get extension
   * @return extension
  **/
  @javax.annotation.Nullable

  public String getExtension() {
    return extension;
  }


  public void setExtension(String extension) {
    this.extension = extension;
  }


  public Usuario tipoUsuario(Integer tipoUsuario) {
    
    this.tipoUsuario = tipoUsuario;
    return this;
  }

   /**
   * Get tipoUsuario
   * @return tipoUsuario
  **/
  @javax.annotation.Nullable

  public Integer getTipoUsuario() {
    return tipoUsuario;
  }


  public void setTipoUsuario(Integer tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
  }


  public Usuario username(String username) {
    
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @javax.annotation.Nullable

  public String getUsername() {
    return username;
  }


  public void setUsername(String username) {
    this.username = username;
  }


  public Usuario password(String password) {
    
    this.password = password;
    return this;
  }

   /**
   * Get password
   * @return password
  **/
  @javax.annotation.Nullable

  public String getPassword() {
    return password;
  }


  public void setPassword(String password) {
    this.password = password;
  }


  public Usuario habilitado(Boolean habilitado) {
    
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
    Usuario usuario = (Usuario) o;
    return Objects.equals(this.idUsuario, usuario.idUsuario) &&
        Objects.equals(this.nombre, usuario.nombre) &&
        Objects.equals(this.apellido1, usuario.apellido1) &&
        Objects.equals(this.apellido2, usuario.apellido2) &&
        Objects.equals(this.email, usuario.email) &&
        Objects.equals(this.extension, usuario.extension) &&
        Objects.equals(this.tipoUsuario, usuario.tipoUsuario) &&
        Objects.equals(this.username, usuario.username) &&
        Objects.equals(this.password, usuario.password) &&
        Objects.equals(this.habilitado, usuario.habilitado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idUsuario, nombre, apellido1, apellido2, email, extension, tipoUsuario, username, password, habilitado);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Usuario {\n");
    sb.append("    idUsuario: ").append(toIndentedString(idUsuario)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    apellido1: ").append(toIndentedString(apellido1)).append("\n");
    sb.append("    apellido2: ").append(toIndentedString(apellido2)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    extension: ").append(toIndentedString(extension)).append("\n");
    sb.append("    tipoUsuario: ").append(toIndentedString(tipoUsuario)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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
    openapiFields.add("idUsuario");
    openapiFields.add("nombre");
    openapiFields.add("apellido1");
    openapiFields.add("apellido2");
    openapiFields.add("email");
    openapiFields.add("extension");
    openapiFields.add("tipoUsuario");
    openapiFields.add("username");
    openapiFields.add("password");
    openapiFields.add("habilitado");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to Usuario
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!Usuario.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Usuario is not found in the empty JSON string", Usuario.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!Usuario.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Usuario` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("nombre") != null && !jsonObj.get("nombre").isJsonNull()) && !jsonObj.get("nombre").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `nombre` to be a primitive type in the JSON string but got `%s`", jsonObj.get("nombre").toString()));
      }
      if ((jsonObj.get("apellido1") != null && !jsonObj.get("apellido1").isJsonNull()) && !jsonObj.get("apellido1").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `apellido1` to be a primitive type in the JSON string but got `%s`", jsonObj.get("apellido1").toString()));
      }
      if ((jsonObj.get("apellido2") != null && !jsonObj.get("apellido2").isJsonNull()) && !jsonObj.get("apellido2").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `apellido2` to be a primitive type in the JSON string but got `%s`", jsonObj.get("apellido2").toString()));
      }
      if ((jsonObj.get("email") != null && !jsonObj.get("email").isJsonNull()) && !jsonObj.get("email").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `email` to be a primitive type in the JSON string but got `%s`", jsonObj.get("email").toString()));
      }
      if ((jsonObj.get("extension") != null && !jsonObj.get("extension").isJsonNull()) && !jsonObj.get("extension").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `extension` to be a primitive type in the JSON string but got `%s`", jsonObj.get("extension").toString()));
      }
      if ((jsonObj.get("username") != null && !jsonObj.get("username").isJsonNull()) && !jsonObj.get("username").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `username` to be a primitive type in the JSON string but got `%s`", jsonObj.get("username").toString()));
      }
      if ((jsonObj.get("password") != null && !jsonObj.get("password").isJsonNull()) && !jsonObj.get("password").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `password` to be a primitive type in the JSON string but got `%s`", jsonObj.get("password").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Usuario.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Usuario' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Usuario> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Usuario.class));

       return (TypeAdapter<T>) new TypeAdapter<Usuario>() {
           @Override
           public void write(JsonWriter out, Usuario value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Usuario read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of Usuario given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Usuario
  * @throws IOException if the JSON string is invalid with respect to Usuario
  */
  public static Usuario fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Usuario.class);
  }

 /**
  * Convert an instance of Usuario to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}
