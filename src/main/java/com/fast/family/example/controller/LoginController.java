package com.fast.family.example.controller;

import com.fast.family.commons.json.Response;
import com.fast.family.example.dto.JWTToken;
import com.fast.family.example.dto.LoginDto;
import com.fast.family.security.jwt.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张顺
 * @version 1.0
 * @created 2018/9/24-13:17
 */
@RestController
public class LoginController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTHelper jwtHelper;

    @PostMapping("/login")
    public Response login(@RequestBody LoginDto loginDto){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtHelper.createToken(authentication,loginDto.isRememberMe());
        return Response.ok(JWTToken.builder().token(jwt).build());
    }
}
