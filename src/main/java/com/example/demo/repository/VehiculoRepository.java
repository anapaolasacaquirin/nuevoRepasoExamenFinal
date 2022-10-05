/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author raquel
 */
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long>{
     @Query(value = "SELECT * FROM Vehiculo where placa = :placa", nativeQuery = true)
    public Vehiculo findByCodigo(@Param("placa") Long placa);
    
    
    
}
