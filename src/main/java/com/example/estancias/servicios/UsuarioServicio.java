/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.estancias.servicios;

import com.example.estancias.MiException.MiException;
import com.example.estancias.entidades.Usuario;
import com.example.estancias.repositorios.UsuarioRepositorio;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio uR;
    @Transactional
    public void crearUsuario(@RequestParam(required=false)String id, String alias, String correo, String password, Date fecha) throws MiException{
        validar(alias, correo, password, fecha);
        Usuario u1 = new Usuario();
        u1.setAlias(alias);
        u1.setCorreo(correo);
        u1.setFechaAlta(fecha);
        u1.setPassword(password);
        uR.save(u1);
        
    }
    public void modificarUsuario(String id, String alias, String correo, String password, Date fecha) throws MiException{
        validar(alias, correo, password, fecha);
        Optional<Usuario> res = uR.findById(id);
        
        if(res.isPresent()){
            Usuario u1 = res.get();
            u1.setAlias(alias);
            u1.setCorreo(correo);
            u1.setPassword(password);
            u1.setFechaAlta(fecha);
            uR.save(u1);
        }
        
    }
    public void eliminarUsuario(String id){
        Optional<Usuario> res = uR.findById(id);
        if(res.isPresent()){
            Usuario u1 = res.get();
            uR.delete(u1);
        }
        
    }
    public Usuario buscarUsuarioPorId(String id){
        Optional<Usuario> res = uR.findById(id);
        if(res.isPresent()){
            Usuario u1 = res.get();
            return u1;
        }else{
            Usuario u1 = res.orElseThrow();
            return u1;
        }
    }
    public List<Usuario> listarUsuario(){
        List<Usuario> lista = uR.findAll();
        return lista;
    }
    public void validar(String alias, String correo, String password, Date fecha) throws MiException{
        if(alias.isEmpty() || alias == null){
            throw new MiException("Tiene que ingresar un alias");
        }
        if(correo.isEmpty() || correo == null){
            throw new MiException("Tiene que ingresar un correo");
        }
        if(password.isEmpty() || password == null){
            throw new MiException("Tiene que ingresar una contraseña");
        }
        if(fecha == null){
            throw new MiException("Tiene que ingresar una fecha");
        }
        
    }
    
}
