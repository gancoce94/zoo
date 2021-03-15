package com.ppm.zoo.zoo.entitys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name="animals")
public class Animals {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_comun", nullable = false, length = 100)
    private String nombreComun;

    @Column(name = "especie", nullable = false, length = 50)
    private String especie;

    @Column(name = "grupo", nullable = true, length = 50)
    private String grupo;

    @Column(name = "habitat", nullable = true, length = 50)
    private String habitat;

    @Column(name = "clasificacion", nullable = true, length = 50)
    private String clasificacion;

    @Column(name = "cantidad", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer cantidad;

    @Column(name = "es_acuatico", nullable = true, columnDefinition = "BOOL DEFAULT FALSE")
    private Boolean acuatico;

    @CreatedDate
    @Column(name = "created_at", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreComun() {
        return this.nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getEspecie() {
        return this.especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getGrupo() {
        return this.grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getHabitat() {
        return this.habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getClasificacion() {
        return this.clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean isAcuatico() {
        return this.acuatico;
    }

    public Boolean getAcuatico() {
        return this.acuatico;
    }

    public void setAcuatico(Boolean acuatico) {
        this.acuatico = acuatico;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Animals(String nombreComun, String especie, String grupo, String habitat, String clasificacion, Integer cantidad, Boolean acuatico) {
        this.nombreComun = nombreComun;
        this.especie = especie;
        this.grupo = grupo;
        this.habitat = habitat;
        this.clasificacion = clasificacion;
        this.cantidad = cantidad;
        this.acuatico = acuatico;
    }

}
