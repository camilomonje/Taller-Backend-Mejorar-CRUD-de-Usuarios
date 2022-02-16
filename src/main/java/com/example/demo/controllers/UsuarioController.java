package com.example.demo.controllers;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping(path ="/priority/{prioridad}")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@PathVariable("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    //Se agrega el Metodo para obtener los usuarios por nombre desde el navegador
    @GetMapping("/name/{nombre}")
    public ArrayList<UsuarioModel> obtenerUsuariopPorNombre(@RequestParam("nombre") String nombre){
        return this.usuarioService.obtenerPorNombre(nombre);
    }

    //Se agrega el Metodo para obtener los usuarios por nombre desde el navegador
    @GetMapping("/email/{email}")
    public ArrayList<UsuarioModel> obtenerUsuarioPorEmail(@RequestParam("email") String email){
        return this.usuarioService.obtenerPorEmail(email);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else {
            return "No se pudo eliminar el usuario con id " + id;
        }
    }

    //Se agrega el metodo para Actualizar el usuario Por su ID
    @PutMapping(path = "/{id}")
    public String actualizarPorId(@RequestBody UsuarioModel usuario, @PathVariable("id") Long id ) {
        boolean ok = this.usuarioService.actualizarUsuario(usuario, id);
        if (ok){
            return "Se Actualizo el usuario con id " + id;
        }
        return "No se pudo actualizar el usuario con id " + id;
    }



}
