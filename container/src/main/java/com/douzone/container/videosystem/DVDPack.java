package com.douzone.container.videosystem;

import java.util.List;

public class DVDPack {
	private String title;
	private List<DigitalVideoDisc> dvds;
	
	@Override
	public String toString() {
		return "DVDPack [title=" + title + ", dvds=" + dvds + "]";
	}

	public DVDPack(String title, List<DigitalVideoDisc> dvds) {
		this.title = title;
		this.dvds = dvds;
	}
	
}
