package com.web.controller;

import com.web.model.User;
import com.web.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * @program:product
 * @description:登录控制
 * @author:YangXiaoJiao
 * @create:2019-01-17 13:42
 **/
@Controller
@RequestMapping
public class LoginController {
    @Autowired
    private UserService userService;
    /*
     * @Author 杨小姣
     * @Description 实现用户登录
     * @Date 17:05 2019/2/1
     **/
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String Login(String username, String password, Model model, HttpServletRequest request, HttpSession session) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        String error = null;
        String verifyCode = request.getParameter("yzm");
        String sessionVerifyCode = (String) session.getAttribute("verifyCodeValue");
        if (verifyCode != null) {
            if (!verifyCode.equalsIgnoreCase(sessionVerifyCode)) {
                error = "验证码输入错误!";
                model.addAttribute("error", error);
                return "login";
            } else {
                try {
                    subject.login(token);
                } catch (UnknownAccountException e) {
                    error = "用户名/密码错误";
                } catch (IncorrectCredentialsException e) {
                    error = "用户名/密码错误";
                } catch (AuthenticationException e) {
                    //其他错误，比如锁定，如果想单独处理请单独catch处理
                    error = "其他错误：" + e.getMessage();
                }
                System.out.println("error:" + error);

                if (error != null) {//出错了，返回登录页面
                    model.addAttribute("error", error);
                    return "login";
                } else {//登录成功
                    User user = (User) SecurityUtils.getSubject().getPrincipal();
                    model.addAttribute("user", user);
                }
            }
        }else{
            error = "验证码输入错误!";
            model.addAttribute("error", error);
            return "login";
        }
        //登录成功后会跳转到successUrl配置的链接，不用管下面返回的链接
        return "/main/index";
    }


    /*
     *@Author: 杨小姣
     *@Description: 注销处理
     *@Date: 11:33 2019/2/26
     **/
    @RequestMapping("/doLogout")
    public String doLogout() {
        // 1、获取Subject
        Subject subject = SecurityUtils.getSubject();

        // 2、执行注销
        try {
            subject.logout();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return "login";
        }
    }

    /* 获取校验码 */
    @RequestMapping("/getVerifyCode")
    public void generate(HttpServletResponse response, HttpSession session) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String verifyCodeValue = drawImg(output);
        // 将校验码保存到session中
        session.setAttribute("verifyCodeValue", verifyCodeValue);

        try {
            ServletOutputStream out = response.getOutputStream();
            output.writeTo(out);
        } catch (IOException e) {
            /* logger.info("<--验证码前端写出.出现异常-->");*/
            e.printStackTrace();

        }
    }

    /* 绘制验证码 */
    private String drawImg(ByteArrayOutputStream output) {
        String code = "";
        // 随机产生4个字符
        for (int i = 0; i < 4; i++) {
            code += randomChar();
        }
        int width = 70;
        int height = 25;
        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_3BYTE_BGR);
        Font font = new Font("Times New Roman", Font.PLAIN, 20);
        // 调用Graphics2D绘画验证码
        Graphics2D g = bi.createGraphics();
        g.setFont(font);
        Color color = new Color(66, 2, 82);
        g.setColor(color);
        g.setBackground(new Color(226, 226, 240));
        g.clearRect(0, 0, width, height);
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int) x, (int) baseY);
        g.dispose();
        try {
            ImageIO.write(bi, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }

    /* 获取随机参数 */
    private char randomChar() {
        Random r = new Random();
        String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
        return s.charAt(r.nextInt(s.length()));
    }
}
