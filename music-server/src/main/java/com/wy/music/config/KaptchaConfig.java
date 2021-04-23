package com.wy.music.config;
//验证码的配置类

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha getDefaultKaptcha(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.put("kaptcha.border", "no");
        properties.put("kaptcha.textproducer.font.color", "black");
        properties.put("kaptcha.image.width", "160");
        properties.put("kaptcha.image.height", "52");
        properties.put("kaptcha.textproducer.font.size", "30");
        properties.put("kaptcha.session.key", "verifyCode");
        properties.put("kaptcha.textproducer.char.space", "7");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);

        return defaultKaptcha;
    }

}
