package venpras.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import venpras.tech.dto.LoginRequestDTO;
import venpras.tech.dto.ResponseData;
import venpras.tech.service.LoginService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResponseData login(@RequestBody LoginRequestDTO loginRequestDTO){
        if(loginRequestDTO.getUsername()!=null&&loginRequestDTO.getPassword()!=null){

        }
        return null;
    }
}
