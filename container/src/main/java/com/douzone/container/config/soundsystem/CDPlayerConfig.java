package com.douzone.container.config.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//스캔할 패키지
@ComponentScan(basePackages = {"com.douzone.container.soundsystem"})
public class CDPlayerConfig {

}
