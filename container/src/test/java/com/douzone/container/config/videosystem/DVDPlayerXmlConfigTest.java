package com.douzone.container.config.videosystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.container.config.soundsystem.CDPlayerConfig;
import com.douzone.container.videosystem.DigitalVideoDisc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:com/douzone/container/config/videosystem/DVDPlayerConfig.xml"})
public class DVDPlayerXmlConfigTest {
	
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
//	@Autowired
//	예외발생 --> XML Bean 설정에서는 id를 자동으로 부여 하지 않는다. (id가 없서)
//	@Qualifier 를 사용할 수 없다.
	private DigitalVideoDisc dvd1;

	//@Qualifer = id 값으로 구분할 수 있다.
	@Autowired
	@Qualifier("ironMan")
	private DigitalVideoDisc dvd2;

	@Autowired
	@Qualifier("avengersInfinityWar")
	private DigitalVideoDisc dvd3;

	@Autowired
	@Qualifier("avengerEndgame")
	private DigitalVideoDisc dvd4;


	@Autowired
	@Qualifier("avengerAgeofUltron")
	private DigitalVideoDisc dvd5;

	@Autowired
	@Qualifier("avengersCaptainAmerica")
	private DigitalVideoDisc dvd6;


	@Autowired
	@Qualifier("avengersDirectorEdition")
	private DigitalVideoDisc dvd7;

	//id가 없어서 주입을 못함
	@Ignore
	@Test
	public void testDvd1NotNull() {
		assertNotNull(dvd1);
	}
	
	@Test
	public void testDvd1NotNull2() {
		assertNotNull(dvd2);
	}
	
	@Test
	public void testDvd1NotNull3() {
		assertNotNull(dvd3);
	}
	
	@Test
	public void testDvd1NotNull4() {
		assertNotNull(dvd4);
	}
	
	@Test
	public void testDvd1NotNull5() {
		assertNotNull(dvd5);
	}
	
	@Test
	public void testDvd1NotNull6() {
		assertNotNull(dvd6);
	}
	
	@Test
	public void testDvd1NotNull7() {
		assertNotNull(dvd7);
	}
}
