package com.dh.game.vo.base;

public class BaseSkillVO {

	private int id;
	private String url;
	private String name;
	private String dec;
	// private int target;
	private int num;
	// private int probability;
	private int atktype;
	private int numtype;
	private int value;
	private String buff;
	// private int energy;
	// private int cd;
	private int time;
	// private int effect1;
	// private int effect2;
	// private int effect3;
	private int growth;

	// private int effect4;
	// private int effecttype;
	// private int rang;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDec() {
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getAtktype() {
		return atktype;
	}

	public void setAtktype(int atktype) {
		this.atktype = atktype;
	}

	public int getNumtype() {
		return numtype;
	}

	public void setNumtype(int numtype) {
		this.numtype = numtype;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getBuff() {
		return buff;
	}

	public void setBuff(String buff) {
		this.buff = buff;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getGrowth() {
		return growth;
	}

	public void setGrowth(int growth) {
		this.growth = growth;
	}

}
