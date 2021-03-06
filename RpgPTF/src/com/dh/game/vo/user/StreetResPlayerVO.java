package com.dh.game.vo.user;

import java.util.ArrayList;
import java.util.List;

/**
 * 玩家资源点状态VO,用于玩家匹配对手
 * 
 * @author dingqu-pc100
 * 
 */
public class StreetResPlayerVO {
	private int id;// 资源点id
	private int level;// 玩家等级
	private int playerId;
	private int status;// [状态{0:空闲,1:正在战斗,2:战斗失败,3:战斗成功,4:生产状态,5:产出时间结束}]
	private int startTime;// 开始产出时间
	private int endTime;
	private int battleTime;
	private int enemyId;// 对手
//	private int maxCombat;
	private List<StreetDefendLogVO> logs = new ArrayList<StreetDefendLogVO>();

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEnemyId() {
		return enemyId;
	}

	public void setEnemyId(int enemyId) {
		this.enemyId = enemyId;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public List<StreetDefendLogVO> getLogs() {
		return logs;
	}

	public void setLogs(List<StreetDefendLogVO> logs) {
		this.logs = logs;
	}

	public int getBattleTime() {
		return battleTime;
	}

	public void setBattleTime(int battleTime) {
		this.battleTime = battleTime;
	}

	// public int getMaxCombat() {
	// return maxCombat;
	// }
	//
	// public void setMaxCombat(int maxCombat) {
	// this.maxCombat = maxCombat;
	// }

}
