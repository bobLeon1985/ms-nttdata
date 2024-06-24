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
 * Modelo Canónico de Respuesta
 */

@Schema(name = "RespuestaDTO", description = "Modelo Canónico de Respuesta")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-24T16:26:04.900880900-05:00[America/Guayaquil]", comments = "Generator version: 7.4.0")
public class RespuestaDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String codigoRespuesta;

  private String descripcion;

  public RespuestaDTO codigoRespuesta(String codigoRespuesta) {
    this.codigoRespuesta = codigoRespuesta;
    return this;
  }

  /**
   * Get codigoRespuesta
   * @return codigoRespuesta
  */
  
  @Schema(name = "codigoRespuesta", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("codigoRespuesta")
  public String getCodigoRespuesta() {
    return codigoRespuesta;
  }

  public void setCodigoRespuesta(String codigoRespuesta) {
    this.codigoRespuesta = codigoRespuesta;
  }

  public RespuestaDTO descripcion(String descripcion) {
    this.descripcion = descripcion;
    return this;
  }

  /**
   * Get descripcion
   * @return descripcion
  */
  
  @Schema(name = "descripcion", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("descripcion")
  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RespuestaDTO respuestaDTO = (RespuestaDTO) o;
    return Objects.equals(this.codigoRespuesta, respuestaDTO.codigoRespuesta) &&
        Objects.equals(this.descripcion, respuestaDTO.descripcion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigoRespuesta, descripcion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RespuestaDTO {\n");
    sb.append("    codigoRespuesta: ").append(toIndentedString(codigoRespuesta)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
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

