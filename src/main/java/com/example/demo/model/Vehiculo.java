/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author raquel
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findByCodigo", query="select c from Vehiculo c where c.codigo = :codigo")
})
public class Vehiculo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name = "placa")
    private long placa;
     
    @Column(name = "color")
    @Basic(optional = false)
    @ApiModelProperty(required = true)
    private String color;
    
    @Column(name = "numeroChasis")
    @Basic(optional = false)
    @ApiModelProperty(required = true)
    private int numeroChasis;
    
    @Column(name = "numeroLlantas")
    @Basic(optional = false)
    @ApiModelProperty(required = true)
    private int numeroLlantas;
    
    
    @Column(name = "modelo")
    @Basic(optional = false)
    @ApiModelProperty(required = true)
    private String modelo;
    
    @Column(name = "costo")
    @Basic(optional = false)
    @ApiModelProperty(required = true)
    private float costo;
    
    @Column(name = "observacion")
    private String observacion;

    public Vehiculo() {
    }

    public Vehiculo(long placa, String color, int numeroChasis, int numeroLlantas, String modelo, float costo, String observacion) {
        this.placa = placa;
        this.color = color;
        this.numeroChasis = numeroChasis;
        this.numeroLlantas = numeroLlantas;
        this.modelo = modelo;
        this.costo = costo;
        this.observacion = observacion;
    }

    public long getPlaca() {
        return placa;
    }

    public void setPlaca(long placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumeroChasis() {
        return numeroChasis;
    }

    public void setNumeroChasis(int numeroChasis) {
        this.numeroChasis = numeroChasis;
    }

    public int getNumeroLlantas() {
        return numeroLlantas;
    }

    public void setNumeroLlantas(int numeroLlantas) {
        this.numeroLlantas = numeroLlantas;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.placa ^ (this.placa >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        return this.placa == other.placa;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", color=" + color + ", numeroChasis=" + numeroChasis + ", numeroLlantas=" + numeroLlantas + ", modelo=" + modelo + ", costo=" + costo + ", observacion=" + observacion + '}';
    }
    
    
    
}
