package cn.mhope.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestArray {
	public static void main(String[] args) {
		List<Song> songs = new ArrayList<Song>();
		songs.add(new Song(1,"刘德华", "忘情水"));
		songs.add(new Song(22,"张学友", "对你爱不完"));
		songs.add(new Song(15,"黎明", "忘情水"));
		songs.add(new Song(33,"郭富城", "忘情水"));
		songs.add(new Song(10,"张国荣", "忘情水"));
		songs.add(new Song(28,"梅艳芳", "忘情水"));
//		songs.add(new Song("刘德华", "忘情水"));
//		songs.add(new Song("刘德华", "忘情水"));
//		songs.add(new Song("刘德华", "忘情水"));
//		Collections.sort(songs);
		Collections.sort(songs, new SongByName());
		for (Song song : songs) {
			System.out.println(song);
		}
		
	}
}
class SongById implements Comparator<Song>{

	@Override
	public int compare(Song o1, Song o2) {
		// TODO Auto-generated method stub
		return o1.getId()>o2.getId()?1:(o1.getId()<o2.getId()?-1:0);
	}
	
}
class SongByName implements Comparator<Song>{

	@Override
	public int compare(Song o1, Song o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}
class SongBySonger implements Comparator<Song>{

	@Override
	public int compare(Song o1, Song o2) {
		return o1.getSonger().compareTo(o2.getSonger());
	}
	
}
class Song implements Comparable<Song>{
	private int id;
	private String name;
	private String songer;
	
	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", songer=" + songer + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Song() {
		super();
	}
	public Song(int id, String songer, String name) {
		super();
		this.id = id;
		this.name = name;
		this.songer = songer;
	}
	public Song(String songer, String name) {
		super();
		this.name = name;
		this.songer = songer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSonger() {
		return songer;
	}
	public void setSonger(String songer) {
		this.songer = songer;
	}
	@Override
	public int compareTo(Song o) {
		if (this.id>o.id) {
			return 1;
		}else if (this.id<o.id) {
			return -1;
		}else {
			return 0;
		}
	}
	
}
