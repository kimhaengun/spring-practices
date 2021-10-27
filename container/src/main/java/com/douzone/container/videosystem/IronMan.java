package com.douzone.container.videosystem;

public class IronMan implements DigitalVideoDisc {

	private String title ="IronMan";
	private String studio ="MARVEL";//영화사
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing Movie "+studio+ "'s "+title);
	}

}
