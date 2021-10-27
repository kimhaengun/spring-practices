package com.douzone.container.config.soundsystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.container.soundsystem.CDPlayer;
import com.douzone.container.soundsystem.CompactDisct;

//Test Container 생성
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/douzone/container/config/soundsystem/CDPlayerConfig.xml")
public class CDPlayerXmlConfigTest {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	@Autowired
	private CDPlayer cdplayer;
	@Autowired
	private CompactDisct cd;
	
	@Test
	public void testHello() {
		int a= 10 - 9;
		assertEquals(1, a); // a의 결과가 1이여야 성공
	}
	
	@Test
	public void testCDPlayerNotNull() {
		//notnull 체크
		assertNotNull(cdplayer);
	}
	
	@Test
	public void testCompactDiscNotNull() {
		//notnull 체크
		assertNotNull(cd);
	}
	
//	@Ignore <<- 테스트에서 제외시킬 수 있다
	@Test
	public void testPlay() {
		cdplayer.play();
		assertEquals("Playing 붕붕 by 김하온",systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
	}
	
}
