package es.albarregas.beans;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="profesores1a1AFK")

public class Profesor implements Serializable {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "idProf")
    private int id;
    
    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;
    @Column(name = "ape1", length = 15, nullable = false)
    private String ape1;
    @Column(name = "ape2", length = 15)
    private String ape2;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idDireccion", foreignKey =
    @ForeignKey(name = "FK_profesores_direcciones"))
    private Direccion direccion;

    // Constructor implicito
    public Profesor() {

    }

    // Constructor explicito
    public Profesor(String nombre, String ape1, String ape2) {
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }

    /*  Existe la posibilidad de que cada atributo no tenga getters o setters pero entoces hay que especificar el atributo access="field"
        en el fichero de mapeo <property name="nombre_atributo" access="field" />
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

}
