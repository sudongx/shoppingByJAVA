package com.sudong.user.service.impl;

import com.sudong.user.domian.dto.LoginFromDTO;
import com.sudong.user.domian.dto.RegisterDTO;
import com.sudong.user.domian.po.User;
import com.sudong.user.domian.vo.UserLoginVO;
import com.sudong.user.service.IUserService;
import com.sudong.user.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Service
@Slf4j
public class userService implements IUserService {

    //注入mapper层，未来用于调用数据库
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserLoginVO login(LoginFromDTO loginFromDTO) {
        //把控制层传递过来的DTO对象读取出来
        String username = loginFromDTO.getUsername();
        String password = loginFromDTO.getPassword();
        //判断数据是否不为空
        if (username != null || username != "") {
            if (password != null || password != "") {
                //查询用户状态，也相当于查询用户是否存在
                Integer active = userMapper.IsActive(username);
                UserLoginVO vo = new UserLoginVO();
                if (active != 2) {
                    log.info("该账户状态正常");
                    //到数据库里匹配，如果能匹配成功，代表用户名和密码都正确
                    User user = userMapper.selectByUserNameAndPassword(username, password);
                    if (user != null) {
                        //走到这里代表密码正确
                        log.info("密码核验正确");
                        userMapper.login_reset(username); // 把之前尝试密码次数的记录给重置
                        vo.setUsername(user.getUsername());
                        vo.setActive(active);
                        return vo;
                    } else {
                        //设置99代表密码错误
                        vo.setActive(99);
                        //密码尝试错误了，那么就要把失败次数+1
                        Integer step = userMapper.getStep(username);
                        if (step != 5 ){
                            userMapper.login_step(username);
                        }else{
                            userMapper.lockUser(username); //锁定
                        }
                        return vo;
                    }
                } else {
                    log.info("用户账户是锁定状态的，无法操作");
                    vo.setActive(2);
                    return vo;
                }

            } else {
                log.info("用户未输入用户名，无法登录");
            }
        }
        return null;
    }
    //用户注册
    @Override
    public Integer register(RegisterDTO registerDTO){
        String username = registerDTO.getUsername();
        String password = registerDTO.getPassword();
        String kouling = registerDTO.getKouling();
        if (!Objects.equals(username, "admin")){
            if (Objects.equals(kouling, "帅比")){
                log.info("开始注册用户");
                //生成首次注册时间
                long l = System.currentTimeMillis();
                //转化为数据库的DateTime类型
                Timestamp createTime = new Timestamp(l);
                //定义激活状态为1
                Integer active = 1;
                try {
                    int i = userMapper.RegisterUser(username,password,active, String.valueOf(createTime));
                    if (i == 1){
                        log.info("用户注册成功！");
                        return 1;
                    }else{
                        log.error("用户注册失败！");
                    }
                }catch (Exception e) {
                    if (e.getCause() instanceof SQLIntegrityConstraintViolationException ||
                            (e.getCause() != null && e.getCause().getMessage().contains("Duplicate entry"))) {
                        // 处理唯一键冲突异常
                        log.error("注册失败：用户名已存在！");
                        return -99;
                    } else {
                        // 处理其他异常
                        log.error("注册失败：数据库操作异常", e);
                        return -1;
                    }
                }

            }else{
                log.info("口令不通过，接收到的口令是{}",kouling);
                return 99;
            }
        }else{
            return -10;
        }
        return 0;
    }
}
