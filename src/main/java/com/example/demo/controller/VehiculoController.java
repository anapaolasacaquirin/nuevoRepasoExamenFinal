/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Vehiculo;
import com.example.demo.service.VehiculoService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author raquel
 */
@RestController
@Controller
@RequestMapping("/servicios/vehiculo")
@Api(tags = "Servicio CRUD de VEHICULO")
@Tag(name = "Servicio CRUD de VEHICULO")
public class VehiculoController {
    @Autowired
    VehiculoService vehiculoService;

    @Operation(summary = "Crear un Vehiculo")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Vehiculo creado correctamente.", content = {
            @Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "400", description = "No se puede crear un Vehiculo", content = {
            @Content(mediaType = "application/json")})
    })
    @PutMapping("/crear")
    public ResponseEntity<Vehiculo> crear(@RequestBody Vehiculo vehiculo) {
        try {
            return new ResponseEntity<>(vehiculoService.crear(vehiculo), HttpStatus.CREATED);
        } catch (Exception e) {
            Logger.getLogger(VehiculoController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Operation(summary = " Buscar un VEHICULO por placa")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Su busqueda ha sido exitosa.", content = {
            @Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "400", description = "Error al buscar", content = {
            @Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "404", description = "Vehiculo no encontrado", content = {
            @Content(mediaType = "application/json")})
    })
    @GetMapping("/buscarCodigo/{placa}")
    public ResponseEntity<Vehiculo> findByPlaca(@PathVariable("placa") Long placa) {
        try {
            Vehiculo response = vehiculoService.findById(placa);
            if(response == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Logger.getLogger(VehiculoController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @Operation(summary = " Listar todos los VEHICULOS")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ejecucion exitosa.", content = {@Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "400", description = "Error al listar", content = {@Content(mediaType = "application/json")})
        
    }) 
    @GetMapping("/listAll")
    public ResponseEntity<List<Vehiculo>> listAll(){
        try{
            return new ResponseEntity<>(vehiculoService.findAll(), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @Operation(summary = " Editar VEHICULO")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Modificacion exitosa", content = {@Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "400", description = "Error al modificar", content = {@Content(mediaType = "application/json")})
    })
    @PostMapping("/editar/{placa}")
    public ResponseEntity<Vehiculo> editarVehiculo(@PathVariable(name = "placa", required = true)Integer placa,
            @RequestBody Vehiculo vehiculo){
        try{
             vehiculo.setPlaca(placa);
            return new ResponseEntity<>(vehiculoService.editar(vehiculo), HttpStatus.OK);
        }catch(Exception ex){
            Logger.getLogger(VehiculoController.class.getName()).log(Level.SEVERE,"NO SE PUDO EDITAR");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    
    @Operation(summary = "Eliminar VEHICULO")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Eliminacion exitosa", content = {@Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "400", description = "Error al modificar", content = {@Content(mediaType = "application/json")})
    })
    @DeleteMapping("/eliminar/{placa}")
    public ResponseEntity<Vehiculo> eliminarVehiculo (@PathVariable(name = "placa", required = true)String placa){
        try{
            Vehiculo vehiculo = vehiculoService.findById(Long.parseLong(placa));
            vehiculoService.eliminar(vehiculo);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception ex){
            Logger.getLogger(VehiculoController.class.getName()).log(Level.SEVERE, "NO SE PUDO ELIMINAR");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
