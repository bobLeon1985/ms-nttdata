/**
 * 
 */
package com.bce.cuentas.domain;

import com.bce.cuentas.domain.enums.TipoGeneroEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author edwinleon
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

	private Integer idCliente;

	@NotNull(message = "Nombre no puede ser nulo")
	@Schema(description = "nombres del cliente")
	@Size(min = 3, message = "{nombres.size}")
	private String nombre;
	
	@NotNull
	private TipoGeneroEnum genero;

	@NotNull
	@Min(value=18, message="Edad minima 18")
	private int edad;
	
	@NotNull
	@Size(min = 10, max = 10, message = "Cedula debe tener 10 caracteres")
	private String identificacion;
	
	@NotNull
	@Size(min = 3, max = 150, message = "Dirección debe tener minimo 3 caracteres")
	private String direccion;

	@NotNull
	@Size(min = 10, max = 10, message = "Telefono debe tener 10 caracteres")
	private String telefono;

	@NotNull
	private String contrasenia;

	@NotNull
	private Boolean estado;

}
