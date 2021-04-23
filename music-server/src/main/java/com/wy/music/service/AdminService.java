package com.wy.music.service;

import com.wy.music.domain.Admin;
import com.wy.music.domain.Visits;

/**
 * 管理员service 接口
 */
public interface AdminService {

    public boolean verifyPassword(String username,String password);

    //获取用户信息
    public Admin selectUserInfo(String username);

    //修改密码
    public void updateUserPassword(String username,String password);

    /*查询用户访问量*/
    public Visits selectVisits();
    /*增加用户点击量*/
    void addFabulous();
}
