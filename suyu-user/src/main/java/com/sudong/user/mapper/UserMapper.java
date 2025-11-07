package com.sudong.user.mapper;


import com.sudong.user.domian.po.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    //根据用户名和密码到数据库中查询是否存在
    @Select("SELECT username, password " +
            "FROM user WHERE username = #{username} and password = #{password}")
    User selectByUserNameAndPassword(@Param("username") String username , @Param("password")String password);

    //查询用户账户状态
    @Select("SELECT active " +
            "FROM user WHERE username = #{username}")
    Integer IsActive(@Param("username") String username);

    //注册用户
    @Insert("INSERT INTO user (username, password, active, create_time) VALUES (#{username}, #{password}, #{active}, #{createTime})")
    int RegisterUser(@Param("username") String username,
                     @Param("password") String password,
                     @Param("active") Integer active,
                     @Param("createTime") String createTime);

    @Update("UPDATE user SET login_step = login_step + 1 WHERE username = #{username}")
    // 增加登录错误次数
    void login_step(String username);

    @Update(" UPDATE user SET login_step = 0 WHERE username = #{username}")
    // 重置登录错误次数
    void login_reset(String username);

    // 锁定用户(设置active为2)
    @Update("UPDATE user SET active = 2, login_step = 0  WHERE username = #{username}")
    void lockUser(String username);

    //查询失败次数
    @Select("select login_step from user where username = #{username}")
    Integer getStep(String username);
}
