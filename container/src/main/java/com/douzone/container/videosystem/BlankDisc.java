package com.douzone.container.videosystem;

import java.util.List;

public class BlankDisc implements DigitalVideoDisc {

	private String title;
	private String studio;//영화사
	private List<String> actors;
	
	public BlankDisc(String title, String studio) {
		this.title=title;
		this.studio=studio;
	}
	
	public BlankDisc(String title, String studio,List<String> actors) {
		this.title=title;
		this.studio=studio;
		this.actors=actors;
	}
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing Movie "+studio+ "'s "+title);
	}

}
