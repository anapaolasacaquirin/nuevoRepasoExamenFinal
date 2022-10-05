/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Vehiculo;
import com.example.demo.repository.VehiculoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author raquel
 */
@Service
public class VehiculoServiceImpl implements VehiculoService{
    
    @Autowired
    private VehiculoRepository repositorio;

    @Override
    public Vehiculo crear(Vehiculo c) {
        return repositorio.save(c);
    }

    @Override
    public List<Vehiculo> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Vehiculo editar(Vehiculo c) {
        return repositorio.save(c);
    }

    @Override
    public void eliminar(Vehiculo c) {
        repositorio.delete(c);
    }

    @Override
    public Vehiculo findById(Long codigo) {
        return repositorio.findByCodigo(codigo);
    }
        
    
    
}
