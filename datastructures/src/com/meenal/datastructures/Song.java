package com.meenal.datastructures;

import java.util.HashSet;

public class Song {
	private String name;
	private Song nextSong;

	public Song(String name) {
		this.name = name;
	}

	public void setNextSong(Song nextSong) {
		this.nextSong = nextSong;
	}

	public boolean isRepeatingPlaylist() {
		HashSet<String> s = new HashSet<String>();
		while (this.name != null) {
			if (s.contains(this.name))
				return true;
			s.add(this.name);
			if(this.nextSong != null) {
				this.name = this.nextSong.name;
				this.nextSong = this.nextSong.nextSong;
			} else {
				this.name = null;
				this.nextSong = null;
			}
			
		}
		return false;
	}

	public static void main(String[] args) {
		Song first = new Song("Hello");
		Song second = new Song("Eye of the tiger");

		first.setNextSong(second);
		second.setNextSong(first);

		System.out.println(first.isRepeatingPlaylist());
	}
}
