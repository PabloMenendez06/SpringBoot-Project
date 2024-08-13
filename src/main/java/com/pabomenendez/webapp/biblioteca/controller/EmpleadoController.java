package com.pabomenendez.webapp.biblioteca.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pabomenendez.webapp.biblioteca.model.Empleado;
import com.pabomenendez.webapp.biblioteca.service.EmpleadoService;

@Controller
@RestController
@RequestMapping("")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/empleados")
    public List<Empleado> listarEmpleados(){
        return empleadoService.listarEmpleados();
    }

    @PostMapping("/Empleado")
    public ResponseEntity<Map<String,String>> agregarEmpleado(@RequestBody Empleado empleado){
        Map<String,String> response = new HashMap<>();
        try {
            if (!empleadoService.verificarDpiDuplicado(empleado)) {
            empleadoService.guardarEmpleado(empleado);
            response.put("Message", "Empleado creado con exito");
            return ResponseEntity.ok(response);
            }else{
                response.put("Message", "Error");
                response.put("Err", "El dpi se encuentre duplicado");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("err", "Hubo un erro al crear el Cliente");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/empleado")
    public ResponseEntity<Empleado> buscarEmpleadoporId(@RequestParam Long id){
        try {
            Empleado empleado = empleadoService.buscarEmpleadoPorId(id);
            return ResponseEntity.ok(empleado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/Empleado")
    public ResponseEntity<Map<String, String>> editarEmpleado(@RequestParam Long id, @RequestBody Empleado empleadoNuevo){
        Map<String, String> response = new HashMap<>();
        try {
            Empleado empleado = empleadoService.buscarEmpleadoPorId(id);
            empleado.setNombre(empleadoNuevo.getNombre());
            empleado.setApellido(empleadoNuevo.getApellido());
            empleado.setDireccion(empleadoNuevo.getDireccion());
            empleado.setTelefono(empleadoNuevo.getTelefono());
            empleado.setDpi(empleadoNuevo.getDpi());
            if (!empleadoService.verificarDpiDuplicado(empleadoNuevo)) {
                empleadoService.guardarEmpleado(empleado);
                response.put("message", "El Empleado se ha modificado con éxito");
                return ResponseEntity.ok(response);
            }else{
                response.put("Message", "Error");
                response.put("Err", "El dpi se encuentre duplicado");
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Hubo un error al intentar modificar el empleado");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/empleado")
    public ResponseEntity<Map<String,String>> eliminarEmpleado(@RequestParam long id){
        Map<String,String> response = new HashMap<>();
        try {
            Empleado empleado = empleadoService.buscarEmpleadoPorId(id);
            empleadoService.eliminarEmpleado(empleado);
            response.put("Message", "El empleado ha sido eliminado con exito");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("Message", "Error");
            response.put("err", "El cliente no se ha eliminado con exito");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
