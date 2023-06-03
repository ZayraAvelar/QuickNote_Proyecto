package com.quicknote.note.controllers;

import com.quicknote.note.dao.UsuarioDAO;
import com.quicknote.note.models.Usuario;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private UsuarioDAO usuarioDao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        if(usuarioDao.verificarCredenciales(usuario)){
            return "OK";
        }
        return "FAIL";
    }
}
