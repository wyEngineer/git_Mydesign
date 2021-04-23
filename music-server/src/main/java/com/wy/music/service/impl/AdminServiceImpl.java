package com.wy.music.service.impl;

import com.wy.music.dao.AdminMapper;
import com.wy.music.domain.Admin;
import com.wy.music.domain.Visits;
import com.wy.music.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 管理员业务层，实现类
 */
@Transactional
@Service
public class AdminServiceImpl implements AdminService {

    //获取bean工厂中的dao
    @Autowired
    public AdminMapper adminMapper;

    @Override
    public boolean verifyPassword(String username, String password) {
        int count = adminMapper.verifyPassword(username, password);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Admin selectUserInfo(String username) {
        return adminMapper.selectUserInfo(username);
    }

    @Override
    public void updateUserPassword(String username, String password) {
        adminMapper.updateUserPassword(username, password);
    }

    @Override
    public Visits selectVisits() {
        adminMapper.updateVisits(1);
        return adminMapper.selectVisits();
    }

    @Override
    public void addFabulous() {
        adminMapper.addFabulous(1);
    }
}
