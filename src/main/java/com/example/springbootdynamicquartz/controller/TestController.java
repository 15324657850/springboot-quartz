package com.example.springbootdynamicquartz.controller;

import com.example.springbootdynamicquartz.entity.Test;
import com.example.springbootdynamicquartz.mapper.TestMapper;
import com.wf.captcha.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

/**
 * @author wxl
 */
@RestController
@RequestMapping("/test")
@AllArgsConstructor
@Slf4j
public class TestController {
    private TestMapper testMapper;





    @PostMapping
    public void insert(Test test) {

        testMapper.insert(test);
        log.info("id {}", test.getId());
    }

    @PutMapping
    public void update(Test test) {
        testMapper.updateById(test);
    }


    @GetMapping("/a")
    public void capt2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // png类型
        SpecCaptcha captcha = new SpecCaptcha(130, 48);
        captcha.text();  // 获取验证码的字符
        captcha.textChar();  // 获取验证码的字符数组

        // gif类型
        GifCaptcha captcha1 = new GifCaptcha(130, 48);

        // 中文类型
        ChineseCaptcha captcha2 = new ChineseCaptcha(130, 48);

        // 中文gif类型
        ChineseGifCaptcha captcha3 = new ChineseGifCaptcha(130, 48);

        // 算术类型
        ArithmeticCaptcha captcha4 = new ArithmeticCaptcha(130, 48);
        captcha4.setLen(3);  // 几位数运算，默认是两位
        captcha4.getArithmeticString();  // 获取运算的公式：3+2=?
        String result = captcha4.text();// 获取运算的结果：5
        log.info("结果为{}",result);

        captcha4.out(response.getOutputStream());  // 输出验证码
    }
    public void capt(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置位数
        //   CaptchaUtil.out(5, request, response);
        // 设置宽、高、位数
//        CaptchaUtil.out(130, 48, 5, request, response);

        // 使用gif验证码
        //GifCaptcha gifCaptcha = new GifCaptcha(130,48,4);
        //  CaptchaUtil.out(gifCaptcha,request, response);

//        不使用工具类

        // 设置请求头为输出图片类型
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // 三个参数分别为宽、高、位数
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        // 设置字体
        specCaptcha.setFont(new Font("Verdana", Font.PLAIN, 32));  // 有默认字体，可以不用设置
        // 设置类型，纯数字、纯字母、字母数字混合
       /* TYPE_DEFAULT	数字和字母混合
        TYPE_ONLY_NUMBER	纯数字
        TYPE_ONLY_CHAR	纯字母
        TYPE_ONLY_UPPER	纯大写字母
        TYPE_ONLY_LOWER	纯小写字母
        TYPE_NUM_AND_UPPER	数字和大写字母*/
        specCaptcha.setCharType(1);

        // 验证码存入session
        log.info("验证码 {}", specCaptcha.text());
        // 输出图片流
        specCaptcha.out(response.getOutputStream());
    }



    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("index");
        return modelAndView;
    }


}
