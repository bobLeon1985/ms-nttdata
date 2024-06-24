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
 * ErrorList
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-24T16:26:04.900880900-05:00[America/Guayaquil]", comments = "Generator version: 7.4.0")
public class ErrorList implements Serializable {

  private static final long serialVersionUID = 1L;

  private String message;

  private String businessMessage;

  public ErrorList message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Message.
   * @return message
  */
  
  @Schema(name = "message", example = "Bad Request", description = "Message.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorList businessMessage(String businessMessage) {
    this.businessMessage = businessMessage;
    return this;
  }

  /**
   * Business error message.
   * @return businessMessage
  */
  
  @Schema(name = "businessMessage", example = "The xyz field is mandatory", description = "Business error message.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("businessMessage")
  public String getBusinessMessage() {
    return businessMessage;
  }

  public void setBusinessMessage(String businessMessage) {
    this.businessMessage = businessMessage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorList errorList = (ErrorList) o;
    return Objects.equals(this.message, errorList.message) &&
        Objects.equals(this.businessMessage, errorList.businessMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, businessMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorList {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    businessMessage: ").append(toIndentedString(businessMessage)).append("\n");
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

