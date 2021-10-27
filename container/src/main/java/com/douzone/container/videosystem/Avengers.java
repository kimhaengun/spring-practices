package com.douzone.container.videosystem;

public class Avengers implements DigitalVideoDisc {

	private String title ="Avengers";
	private String studio ="MARVEL";//영화사
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing Movie "+studio+ "'s "+title);
	}

}
