/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.estancias.repositorios;

import com.example.estancias.entidades.Usuario;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {
    @Query("INSERT INTO usuario(id, alias, correo, password, fecha)VALUES(null, :alias, :correo, :password, :fecha)")
    public void crearUsuario(@Param(":alias") String alias, @Param(":correo") String correo, @Param(":password") String password, @Param(":fecha") Date fecha );
    @Query("UPDATE usuario SET alias = :alias, correo = :correo, password = :password, fecha = :fecha WHERE id = :id")
    public void modificarUsuario(@Param(":alias") String alias, @Param(":correo") String correo, @Param(":password") String password, @Param(":fecha") Date fecha );
    @Query("DELETE * FROM usuario WHERE id = :id")
    public void eliminarUsuario(@Param(":id") String id); 
    @Query("SELECT u FROM usuario u WHERE id = :id ")
    public Usuario mostrarUsuarioPorId(@Param(":id") String id);
    
    
}
