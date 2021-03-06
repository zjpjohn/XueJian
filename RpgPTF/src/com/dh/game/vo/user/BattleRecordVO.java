package com.dh.game.vo.user;

import java.util.Date;

public class BattleRecordVO {
	private int playerId;
	private int index;
	private int atktype;
	private int otherPlayerId;
	private int succ;
	private int rank;
	private Date battleDate;

	public Date getBattleDate() {
		return battleDate;
	}

	public void setBattleDate(Date battleDate) {
		this.battleDate = battleDate;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getAtktype() {
		return atktype;
	}

	public void setAtktype(int atktype) {
		this.atktype = atktype;
	}

	public int getOtherPlayerId() {
		return otherPlayerId;
	}

	public void setOtherPlayerId(int otherPlayerId) {
		this.otherPlayerId = otherPlayerId;
	}

	public int getSucc() {
		return succ;
	}

	public void setSucc(int succ) {
		this.succ = succ;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
