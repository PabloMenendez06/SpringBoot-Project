package com.pabomenendez.webapp.biblioteca.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pabomenendez.webapp.biblioteca.model.Cliente;
import com.pabomenendez.webapp.biblioteca.service.ClienteService;


@Controller
@RestController
@RequestMapping("cliente")

public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/")
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }
    @PostMapping("/")
    public ResponseEntity<Map<String, String>> agregarCliente(@RequestBody Cliente cliente){
        Map<String,String> response = new HashMap<>();
        try {
            clienteService.guardarCliente(cliente);
            response.put("Mesagge", "Cliente creado con exito");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("err", "Hubo un erro al crear el Cliente");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
