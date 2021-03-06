package entidades;
// Generated 02-sep-2016 14:54:58 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * AdmRol generated by hbm2java
 */
public class AdmRol  implements java.io.Serializable {


     private Integer id;
     private String descripcion;
     private Set admUsuarios = new HashSet(0);
     private Set admPermisos = new HashSet(0);

    public AdmRol() {
    }

	
    public AdmRol(String descripcion) {
        this.descripcion = descripcion;
    }
    public AdmRol(String descripcion, Set admUsuarios, Set admPermisos) {
       this.descripcion = descripcion;
       this.admUsuarios = admUsuarios;
       this.admPermisos = admPermisos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getAdmUsuarios() {
        return this.admUsuarios;
    }
    
    public void setAdmUsuarios(Set admUsuarios) {
        this.admUsuarios = admUsuarios;
    }
    public Set getAdmPermisos() {
        return this.admPermisos;
    }
    
    public void setAdmPermisos(Set admPermisos) {
        this.admPermisos = admPermisos;
    }




}


