package com.sudong.user.controller;

import com.sudong.user.domian.dto.LoginFromDTO;
import com.sudong.user.domian.dto.RegisterDTO;
import com.sudong.user.domian.vo.UserLoginVO;
import com.sudong.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class userController {
    //登录
    private final IUserService userService;
    @PostMapping("login")
    public UserLoginVO userLogin(@RequestBody @Validated LoginFromDTO loginFromDTO){
        return userService.login(loginFromDTO);
    }
    //注册
    @PostMapping("register")
    public Integer userRegister(@RequestBody @Validated RegisterDTO registerDTO){
        return userService.register(registerDTO);
    }
}
