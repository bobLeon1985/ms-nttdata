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
 * Error
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-24T16:26:04.900880900-05:00[America/Guayaquil]", comments = "Generator version: 7.4.0")
public class Error implements Serializable {

  private static final long serialVersionUID = 1L;

  private String title;

  private String detail;

  private String instance;

  private String type;

  public Error title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Technical error message.
   * @return title
  */
  
  @Schema(name = "title", example = "Missing mandatory fields.", description = "Technical error message.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Error detail(String detail) {
    this.detail = detail;
    return this;
  }

  /**
   * Message to display to the client.
   * @return detail
  */
  
  @Schema(name = "detail", example = "The input fields are not correct", description = "Message to display to the client.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("detail")
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public Error instance(String instance) {
    this.instance = instance;
    return this;
  }

  /**
   * Error catalog code.
   * @return instance
  */
  
  @Schema(name = "instance", example = "022", description = "Error catalog code.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("instance")
  public String getInstance() {
    return instance;
  }

  public void setInstance(String instance) {
    this.instance = instance;
  }

  public Error type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Address where the error occurs.
   * @return type
  */
  
  @Schema(name = "type", example = "/v1/name/pathSuffix", description = "Address where the error occurs.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.title, error.title) &&
        Objects.equals(this.detail, error.detail) &&
        Objects.equals(this.instance, error.instance) &&
        Objects.equals(this.type, error.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, detail, instance, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

