package com.bce.services.server.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Modelo Canónico de Cliente
 */

@Schema(name = "ClienteDTO", description = "Modelo Canónico de Cliente")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-24T16:26:04.900880900-05:00[America/Guayaquil]", comments = "Generator version: 7.4.0")
public class ClienteDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String nombres;

  private String genero;

  private Integer edad;

  private String identificacion;

  private String direccion;

  private String telefono;

  private String contrasenia;

  private Boolean estado;

  public ClienteDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ClienteDTO(String identificacion, String contrasenia) {
    this.identificacion = identificacion;
    this.contrasenia = contrasenia;
  }

  public ClienteDTO nombres(String nombres) {
    this.nombres = nombres;
    return this;
  }

  /**
   * Get nombres
   * @return nombres
  */
  
  @Schema(name = "nombres", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nombres")
  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public ClienteDTO genero(String genero) {
    this.genero = genero;
    return this;
  }

  /**
   * Get genero
   * @return genero
  */
  
  @Schema(name = "genero", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("genero")
  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public ClienteDTO edad(Integer edad) {
    this.edad = edad;
    return this;
  }

  /**
   * Get edad
   * @return edad
  */
  
  @Schema(name = "edad", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("edad")
  public Integer getEdad() {
    return edad;
  }

  public void setEdad(Integer edad) {
    this.edad = edad;
  }

  public ClienteDTO identificacion(String identificacion) {
    this.identificacion = identificacion;
    return this;
  }

  /**
   * Get identificacion
   * @return identificacion
  */
  @NotNull 
  @Schema(name = "identificacion", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("identificacion")
  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public ClienteDTO direccion(String direccion) {
    this.direccion = direccion;
    return this;
  }

  /**
   * Get direccion
   * @return direccion
  */
  
  @Schema(name = "direccion", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("direccion")
  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public ClienteDTO telefono(String telefono) {
    this.telefono = telefono;
    return this;
  }

  /**
   * Get telefono
   * @return telefono
  */
  
  @Schema(name = "telefono", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("telefono")
  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public ClienteDTO contrasenia(String contrasenia) {
    this.contrasenia = contrasenia;
    return this;
  }

  /**
   * Get contrasenia
   * @return contrasenia
  */
  @NotNull 
  @Schema(name = "contrasenia", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("contrasenia")
  public String getContrasenia() {
    return contrasenia;
  }

  public void setContrasenia(String contrasenia) {
    this.contrasenia = contrasenia;
  }

  public ClienteDTO estado(Boolean estado) {
    this.estado = estado;
    return this;
  }

  /**
   * Get estado
   * @return estado
  */
  
  @Schema(name = "estado", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("estado")
  public Boolean getEstado() {
    return estado;
  }

  public void setEstado(Boolean estado) {
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
    ClienteDTO clienteDTO = (ClienteDTO) o;
    return Objects.equals(this.nombres, clienteDTO.nombres) &&
        Objects.equals(this.genero, clienteDTO.genero) &&
        Objects.equals(this.edad, clienteDTO.edad) &&
        Objects.equals(this.identificacion, clienteDTO.identificacion) &&
        Objects.equals(this.direccion, clienteDTO.direccion) &&
        Objects.equals(this.telefono, clienteDTO.telefono) &&
        Objects.equals(this.contrasenia, clienteDTO.contrasenia) &&
        Objects.equals(this.estado, clienteDTO.estado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombres, genero, edad, identificacion, direccion, telefono, contrasenia, estado);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClienteDTO {\n");
    sb.append("    nombres: ").append(toIndentedString(nombres)).append("\n");
    sb.append("    genero: ").append(toIndentedString(genero)).append("\n");
    sb.append("    edad: ").append(toIndentedString(edad)).append("\n");
    sb.append("    identificacion: ").append(toIndentedString(identificacion)).append("\n");
    sb.append("    direccion: ").append(toIndentedString(direccion)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    contrasenia: ").append(toIndentedString(contrasenia)).append("\n");
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
}

