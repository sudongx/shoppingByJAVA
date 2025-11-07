package com.sudong.user.service;


import com.sudong.user.domian.dto.LoginFromDTO;
import com.sudong.user.domian.dto.RegisterDTO;
import com.sudong.user.domian.vo.UserLoginVO;

import java.sql.SQLException;

public interface IUserService {


    UserLoginVO login (LoginFromDTO loginFromDTO);

    Integer register(RegisterDTO registerDTO) ;



}
