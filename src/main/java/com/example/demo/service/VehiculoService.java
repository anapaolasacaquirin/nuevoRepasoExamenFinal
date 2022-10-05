/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Vehiculo;
import java.util.List;

/**
 *
 * @author raquel
 */
public interface VehiculoService {
    public Vehiculo crear(Vehiculo c);//CREATE
    public List<Vehiculo> findAll();//READ
    public Vehiculo editar(Vehiculo c);//UPDATE
    public void eliminar(Vehiculo c);//DELETE
    public Vehiculo findById(Long codigo);//READ

    
}
