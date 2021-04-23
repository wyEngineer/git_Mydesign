package com.wy.music.dao;

/**
 * 管理员dao
 */

import com.wy.music.domain.Admin;
import com.wy.music.domain.Visits;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {

    /*
     * 验证密码是否正确
     */
    public int verifyPassword(@Param("username") String username, @Param("password") String password);

    /*
        查询用户信息
     */
    public Admin selectUserInfo(String username);

    /*修改密码*/
    public void updateUserPassword(@Param("username") String username, @Param("password") String password);

    /*查询用户访问量*/
    public Visits selectVisits();
    /*增加访问量*/
    public void updateVisits(Integer id);

    /*增加用户点击量*/
    void addFabulous(Integer id);
}
