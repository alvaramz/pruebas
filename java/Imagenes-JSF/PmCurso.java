package entidades;
// Generated 13/07/2016 10:36:00 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Esta es una entidad auto-generada por hbm2java
 * Contiene todos los campos de una tabla, eso para ejemplificar dos maneras
 * de almacenar una imágen en base de datos:
 * 1) como un arreglo de bytes[]
 * 2) como una String.
 * En el priemer caso, el campo de la base de datos (MySQL) es un longblob.
 * En el segundo caso, el campo de la base de datos es un longtext.
 * @author Ing. Adrián Alvarado Ramírez.
 */
public class PmCurso  implements java.io.Serializable {


     private Integer id;
     private AdmMoneda admMoneda;
     private PmModalidad pmModalidad;
     private String nombreCurso;
     private Date fechaInicio;
     private Date matriculaDesde;
     private Date matriculaHasta;
     private int cupoDisponible;
     private int tipoCurso;
     private int costo;
     private String imagen;
     private byte[] poster;
     private String formatoPoster;
     private String lugar;
     private String publicoMeta;
     private int duracion;
     private String descripcion;
     private boolean archivado;
     private Set pmMatriculas = new HashSet(0);

    public PmCurso() {
    }


    public PmCurso(PmModalidad pmModalidad, String nombreCurso, Date fechaInicio, Date matriculaDesde, Date matriculaHasta, int cupoDisponible, int tipoCurso, int costo, String lugar, String publicoMeta, int duracion, String descripcion, boolean archivado) {
        this.pmModalidad = pmModalidad;
        this.nombreCurso = nombreCurso;
        this.fechaInicio = fechaInicio;
        this.matriculaDesde = matriculaDesde;
        this.matriculaHasta = matriculaHasta;
        this.cupoDisponible = cupoDisponible;
        this.tipoCurso = tipoCurso;
        this.costo = costo;
        this.lugar = lugar;
        this.publicoMeta = publicoMeta;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.archivado = archivado;
    }
    public PmCurso(AdmMoneda admMoneda, PmModalidad pmModalidad, String nombreCurso, Date fechaInicio, Date matriculaDesde, Date matriculaHasta, int cupoDisponible, int tipoCurso, int costo, String imagen, byte[] poster, String formatoPoster, String lugar, String publicoMeta, int duracion, String descripcion, boolean archivado, Set pmMatriculas) {
       this.admMoneda = admMoneda;
       this.pmModalidad = pmModalidad;
       this.nombreCurso = nombreCurso;
       this.fechaInicio = fechaInicio;
       this.matriculaDesde = matriculaDesde;
       this.matriculaHasta = matriculaHasta;
       this.cupoDisponible = cupoDisponible;
       this.tipoCurso = tipoCurso;
       this.costo = costo;
       this.imagen = imagen;
       this.poster = poster;
       this.formatoPoster = formatoPoster;
       this.lugar = lugar;
       this.publicoMeta = publicoMeta;
       this.duracion = duracion;
       this.descripcion = descripcion;
       this.archivado = archivado;
       this.pmMatriculas = pmMatriculas;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public AdmMoneda getAdmMoneda() {
        return this.admMoneda;
    }

    public void setAdmMoneda(AdmMoneda admMoneda) {
        this.admMoneda = admMoneda;
    }
    public PmModalidad getPmModalidad() {
        return this.pmModalidad;
    }

    public void setPmModalidad(PmModalidad pmModalidad) {
        this.pmModalidad = pmModalidad;
    }
    public String getNombreCurso() {
        return this.nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getMatriculaDesde() {
        return this.matriculaDesde;
    }

    public void setMatriculaDesde(Date matriculaDesde) {
        this.matriculaDesde = matriculaDesde;
    }
    public Date getMatriculaHasta() {
        return this.matriculaHasta;
    }

    public void setMatriculaHasta(Date matriculaHasta) {
        this.matriculaHasta = matriculaHasta;
    }
    public int getCupoDisponible() {
        return this.cupoDisponible;
    }

    public void setCupoDisponible(int cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }
    public int getTipoCurso() {
        return this.tipoCurso;
    }

    public void setTipoCurso(int tipoCurso) {
        this.tipoCurso = tipoCurso;
    }
    public int getCosto() {
        return this.costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    public String getImagen() {
        return this.imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public byte[] getPoster() {
        return this.poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }
    public String getFormatoPoster() {
        return this.formatoPoster;
    }

    public void setFormatoPoster(String formatoPoster) {
        this.formatoPoster = formatoPoster;
    }
    public String getLugar() {
        return this.lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public String getPublicoMeta() {
        return this.publicoMeta;
    }

    public void setPublicoMeta(String publicoMeta) {
        this.publicoMeta = publicoMeta;
    }
    public int getDuracion() {
        return this.duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public boolean isArchivado() {
        return this.archivado;
    }

    public void setArchivado(boolean archivado) {
        this.archivado = archivado;
    }
    public Set getPmMatriculas() {
        return this.pmMatriculas;
    }

    public void setPmMatriculas(Set pmMatriculas) {
        this.pmMatriculas = pmMatriculas;
    }




}
