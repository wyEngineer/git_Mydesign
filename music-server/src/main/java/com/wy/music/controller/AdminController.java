package com.wy.music.controller;


import com.alibaba.fastjson.JSONObject;
import com.wy.music.domain.Admin;
import com.wy.music.domain.Visits;
import com.wy.music.service.AdminService;
import com.wy.music.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 管理员的web控制层
 */

@RestController
@RequestMapping("/admin")
public class AdminController {
    //获取bean中的管理员service
    @Autowired
    public AdminService adminService;

    /*
       校验密码操作
     */
    @PostMapping("/verifyPassword")
    public Object loginStatus(String username, String password, String checkCode, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        boolean flag = adminService.verifyPassword(username, password);
        //拿到session中的验证码
        String verifyCode = (String) session.getAttribute("verifyCode");

        session.removeAttribute(verifyCode);//删除session
        //验证码校验
        if (checkCode.equalsIgnoreCase(verifyCode)) {
            //验证码正确
            if (flag) {
                //如果返回true说明当前表中该用户
                //将用户名存入session
                //定义常量 将当前用户信息和返回信息
                jsonObject.put(Const.CODE, 1);
                jsonObject.put(Const.MSG, "登录成功!");
                session.setAttribute(Const.USERNAME, username);
                return jsonObject;
            } else {
                //定义常量 将当前用户信息和返回信息
                jsonObject.put(Const.CODE, 0);
                jsonObject.put(Const.MSG, "用户名或密码错误!");
                return jsonObject;
            }
        }

        //定义常量 将当前用户信息和返回信息
        jsonObject.put(Const.CODE, 0);
        jsonObject.put(Const.MSG, "验证码错误!");
        return jsonObject;

    }


    @GetMapping("/selectUserInfo")
    public Object selectUserInfo(String username) {
        JSONObject jsonObject = new JSONObject();
        Admin admin = adminService.selectUserInfo(username);
        Visits visits = adminService.selectVisits();
        if (admin != null) {
            //有数据
            jsonObject.put(Const.CODE, 1);
            jsonObject.put("admin", admin);
            //查看用户访问量
            jsonObject.put("visitNumber", visits.getVisitNumber() - 1);
            //查看用户点赞量
            jsonObject.put("fabulousNumber",visits.getFabulousNumber());
            return jsonObject;
        }
        //无数据
        //有数据
        jsonObject.put(Const.CODE, 0);
        jsonObject.put(Const.MSG, "未检测到当前用户,请先登录系统!");
        return jsonObject;
    }

    /*修改密码操作*/
    @PostMapping("/updateUserPassword")
    public Object updateUserPassword(String username, String password) {
        JSONObject jsonObject = new JSONObject();
        try {
            adminService.updateUserPassword(username, password);
            jsonObject.put(Const.CODE, 1);
            jsonObject.put(Const.MSG, "修改成功!");
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put(Const.CODE, 0);
            jsonObject.put(Const.MSG, "系统异常，修改失败!");
            return jsonObject;
        }
    }


    /*增加用户点赞量*/
    @GetMapping("/addFabulous")
    public JSONObject addFabulous() {
        JSONObject jsonObject = new JSONObject();
        try {
            adminService.addFabulous();
            jsonObject.put(Const.CODE, 1);
            jsonObject.put(Const.MSG, "您的支持就是对我们最大的鼓励!");
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put(Const.CODE, 0);
            jsonObject.put(Const.MSG, "系统异常，无法点赞!");
        }
        return jsonObject;
    }
}
