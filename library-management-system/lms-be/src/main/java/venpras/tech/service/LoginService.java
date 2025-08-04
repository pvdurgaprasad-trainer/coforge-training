package venpras.tech.service;

import org.springframework.stereotype.Service;
import venpras.tech.dto.LoginRequestDTO;

@Service
public class LoginService {
    public void login(LoginRequestDTO loginRequestDTO){
        if(loginRequestDTO.getUsername().equalsIgnoreCase(loginRequestDTO.getPassword())){
            if("admin".equalsIgnoreCase(loginRequestDTO.getUsername())){

            }else{

            }
        }
    }
}
