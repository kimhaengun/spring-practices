package com.douzone.container.config.videosystem.mixing;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/*
 * <---------------JavaConfig1, JavaConfig2
 *      import
 *   javaConfig1+javaConfig2
 */
@Configuration
@Import({DVDConfig.class,DVDPlayerConfig.class})
public class VideoSystemConfig {
	
}
