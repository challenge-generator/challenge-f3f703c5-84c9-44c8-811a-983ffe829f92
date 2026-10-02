package com.bank.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private UUID id;

    @NotNull(message = "El nombre del cliente no puede ser nulo")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotNull(message = "El apellido del cliente no puede ser nulo")
    @Size(min = 2, max = 100, message = "El apellido debe tener entre 2 y 100 caracteres")
    private String apellido;

    @NotNull(message = "El email del cliente no puede ser nulo")
    @Email(message = "El email debe ser válido")
    private String email;

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    private LocalDate fechaNacimiento;

    @NotNull(message = "El número de identificación no puede ser nulo")
    @Size(min = 5, max = 20, message = "El número de identificación debe tener entre 5 y 20 caracteres")
    private String numeroIdentificacion;

    @NotNull(message = "El tipo de identificación no puede ser nulo")
    private TipoIdentificacion tipoIdentificacion;

    public enum TipoIdentificacion {
        CC, CE, PASAPORTE
    }

    public Cliente(String nombre, String apellido, String email, LocalDate fechaNacimiento,
                  String numeroIdentificacion, TipoIdentificacion tipoIdentificacion) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public int calcularEdad() {
        return LocalDate.now().getYear() - fechaNacimiento.getYear();
    }

    public boolean esMayorDeEdad() {
        return calcularEdad() >= 18;
    }
}