package pe.edu.upc.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPaciente;

    @NotEmpty(message = "Ingrese su nombre")
    @Column(name = "fullNamePaciente", length = 48, nullable = false)
    private String fullNamePaciente;

    @NotNull(message = "Seleccione una fecha")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthDatePaciente", nullable = false)
    private Date birthDatePaciente;

    @NotEmpty(message = "Ingrese su email")
    @Email(message = "Correo no válido, ingrese de nuevo")
    @Column(name = "emailPaciente", length = 45, nullable = false)
    private String emailPaciente;

    @NotEmpty(message = "Ingrese su dirección")
    @Column(name = "direccionPaciente", length = 48, nullable = false)
    private String direccionPaciente;

    @Size(min = 9, max = 9)
    @NotEmpty(message = "Ingrese su numero")
    @Column(name = "celularPaciente", length = 9, nullable = false)
    private String celularPaciente;

    @Size(min = 8, max = 8)
    @NotEmpty(message = "Ingrese su DNI")
    @Column(name = "dniPaciente", length = 8, nullable = false)
    private String dniPaciente;

    @Column(name = "rolPaciente", nullable = false)
    private String rolPaciente;

    @NotEmpty(message = "Ingrese un nombre para su usuario")
    @Column(name = "usernamePaciente", length = 30, nullable = false)
    private String usernamePaciente;

    @NotEmpty(message = "Ingrese su contraseña")
    @Column(name = "pswrdPaciente", length = 108, nullable = false)
    private String pswrdPaciente;

    public Paciente() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Paciente(int idPaciente, String fullNamePaciente, Date birthDatePaciente, String emailPaciente,
            String direccionPaciente, String celularPaciente, String dniPaciente) {
        super();
        this.idPaciente = idPaciente;
        this.fullNamePaciente = fullNamePaciente;
        this.birthDatePaciente = birthDatePaciente;
        this.emailPaciente = emailPaciente;
        this.direccionPaciente = direccionPaciente;
        this.celularPaciente = celularPaciente;
        this.dniPaciente = dniPaciente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getFullNamePaciente() {
        return fullNamePaciente;
    }

    public void setFullNamePaciente(String fullNamePaciente) {
        this.fullNamePaciente = fullNamePaciente;
    }

    public Date getBirthDatePaciente() {
        return birthDatePaciente;
    }

    public void setBirthDatePaciente(Date birthDatePaciente) {
        this.birthDatePaciente = birthDatePaciente;
    }

    public String getEmailPaciente() {
        return emailPaciente;
    }

    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    public String getDireccionPaciente() {
        return direccionPaciente;
    }

    public void setDireccionPaciente(String direccionPaciente) {
        this.direccionPaciente = direccionPaciente;
    }

    public String getCelularPaciente() {
        return celularPaciente;
    }

    public void setCelularPaciente(String celularPaciente) {
        this.celularPaciente = celularPaciente;
    }

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public String getUsernamePaciente() {
        return usernamePaciente;
    }

    public void setUsernamePaciente(String usernamePaciente) {
        this.usernamePaciente = usernamePaciente;
    }

    public String getPswrdPaciente() {
        return pswrdPaciente;
    }

    public void setPswrdPaciente(String pswrdPaciente) {
        this.pswrdPaciente = pswrdPaciente;
    }

    public String getRolPaciente() {
        return rolPaciente;
    }

    public void setRolPaciente(String rolPaciente) {
        this.rolPaciente = rolPaciente;
    }

}
