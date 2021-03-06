package com.dh.service;

import java.util.Arrays;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.dh.Cache.ServerHandler;
import com.dh.constants.ActivityConstant;
import com.dh.game.constant.CSCommandConstant;
import com.dh.game.vo.message.MessageProto.ChatResponse;
import com.dh.game.vo.message.MessageProto.EChannel;
import com.dh.netty.NettyMessageVO;
import com.dh.resconfig.TipsRes;
import com.dh.timer.ActyTimer;
import com.dh.util.BadWordsFilter;
import com.dh.util.DateUtil;
import com.dh.vo.WorldBossVO;

public class ChatService {
	private final static Logger LOGGER = Logger.getLogger(ChatService.class);

	public final static String[] TAGS = { "【系统公告】", "【系统通知】", "【游戏贴士】" };

	public final static String[] PLAYER_NAME = { " <font color='#05FFD9'>", "</font> " };// 玩家颜色
	public final static String[] NUM = { " <font color='#FD8606'>", "</font> " };// 数字颜色
	public final static String[] HERO_NAME = { " <font color='#00FFA2'>", "</font> " };// 英雄颜色
	public final static String[] EQUIP_NAME = { " <font color='#FFFC19'>", "</font> " };// 装备颜色
	public final static String[] TIP_NAME = { " <font color='#00BB00'>", "</font> " };// 系统小贴士颜色
	public final static String[] SYS_NOTICE_NAME = { " <font color='#FFD306'>", "</font> " };// 系统通知颜色

	private final static String[] EQUIP_UPDATE = { "玩家" + PLAYER_NAME[0], PLAYER_NAME[1] + "历经千辛万苦，终于将 " + NUM[0], NUM[1] + "星装备", "升星至" + NUM[0], NUM[1] + "星装备", "，大家恭喜他吧！" };// 装备升星至5星及其以上时
	private final static String[] HERO_UPDATE = { "玩家" + PLAYER_NAME[0], PLAYER_NAME[1] + "功力大进，将 " + NUM[0], NUM[1] + "星侠客" + HERO_NAME[0], HERO_NAME[1] + "提升为" + NUM[0], NUM[1] + "星侠客，一统江湖指日可待！" };// 侠客升星至5星及其以上时
	private final static String[] RMB_HIRE = { "玩家" + PLAYER_NAME[0], PLAYER_NAME[1] + "受到福星护佑，在元宝招募中获得" + NUM[0], NUM[1] + "星侠客" + HERO_NAME, HERO_NAME + "，实力大增，横行江湖，无人能敌！" };// 元宝招募,英雄招募6星及其以上时
	private final static String[] TEN_HIRE = { "玩家" + PLAYER_NAME[0], PLAYER_NAME[1] + "广招英豪，终于在十连抽中获得" + NUM[0], NUM[1] + "星侠客" + HERO_NAME[0], HERO_NAME[1] };// 十连抽招募,英雄招募6星及其以上时
	private final static String[] SCORE_HIRE = { "玩家" + PLAYER_NAME[0], PLAYER_NAME[1] + "诚心所致，金石为开，在积分中获得" + NUM[0], NUM[1] + "星侠客" + HERO_NAME[0], HERO_NAME[1] };// 积分招募,英雄招募6星及其以上时
	private final static String[] ARENA_RANK = { "经过昨日的精彩比试之后，竞技场称霸前三的玩家已经确定，分别是：天下第一" + PLAYER_NAME[0], PLAYER_NAME[1] + "天下第二" + PLAYER_NAME[0], PLAYER_NAME[1] + "，天下第三" + PLAYER_NAME[0],
			PLAYER_NAME[1] };// 竞技场每日排名前3公告
	private final static String[] WORLD_BOSS_KILL = { "惊天大战之后，" + HERO_NAME[0], HERO_NAME[1] + "被众豪杰杀死，玩家" + PLAYER_NAME[0], PLAYER_NAME[1] + "对BOSS完成了最终一击，获得高级宝石和海量侠客经验，从此大名远扬，无人不晓！" };// 世界BOSS伤害第1公告，世界BOSS死亡时
	private final static String[] WORLD_BOSS_END = { "boss活动已经结束,请各位大侠下次再战" };// 结束时调用
	private final static String[] WORLD_BOSS_RANK_MAIL = { "恭喜你在挑战" + HERO_NAME[0], HERO_NAME[1] + "活动中伤害量达到" + NUM[0], NUM[1] + "，位列第" + NUM[0], NUM[1] + "名，以下是你的排名奖励，请注意查收: " };// 世界boss排名邮件
	private final static String[] WORLD_BOSS_ALL_PLAYERS_MAIL_OVER = { "恭喜你在挑战" + HERO_NAME[0], HERO_NAME[1] + "活动中贡献了自己的一份力量，使得" + HERO_NAME[0], HERO_NAME[1] + "成功被击杀，以下是你的参与奖励，请注意查收" };// 世界boss参与邮件
	private final static String[] WORLD_BOSS_ALL_PLAYERS_MAIL_END = { "恭喜你在挑战" + HERO_NAME[0], HERO_NAME[1] + "活动中贡献了自己的一份力量，使得" + HERO_NAME[0], HERO_NAME[1] + "受到重挫，以下是你的击杀奖励，请注意查收" };// 世界boss参与邮件

	private final static String[] WORLD_BOSS_KILL_MAIL = { "恭喜你在挑战" + HERO_NAME[0], HERO_NAME[1] + "活动中完成了最终一击，以下是你的击杀奖励，请注意查收。" };// 世界boss击杀邮件
	private final static String[] YUAN_ZHENG = { "玩家" + PLAYER_NAME[0], PLAYER_NAME[1] + "经过艰苦大战，通关华山论剑普通模式，雄霸江湖一方，无人敢惹！" };// 通关华山论剑普通模式
	private final static String[] YUAN_ZHENG_JINGYING = { "玩家" + PLAYER_NAME[0], PLAYER_NAME[1] + "经过艰苦大战，击败众多江湖豪杰，通关华山论剑精英模式，论剑无敌！" };// 华山论剑精英模式
	private final static String[] VIP_UPDATE = { "玩家" + PLAYER_NAME[0], PLAYER_NAME[1] + "财大气粗，获得VIP" + NUM[0], NUM[1] + "特权，从此声名远扬！" };// 玩家VIP等级升级至4级及其以上时
	private final static String[] VIP_UPDATE_GIFTPACK = { "玩家" + PLAYER_NAME[0], PLAYER_NAME[1] + "腰缠万贯，获得VIP" + NUM[0], NUM[1] + "特权，并向全服玩家发放了庆祝礼包,快去福利大厅领取吧！" };// 黄瓜仙子礼包,1,4,7,8,9,10
	private final static String[] BUILD_UPDATE = { "玩家" + PLAYER_NAME[0], PLAYER_NAME[1] + "历经千辛万苦，将" + EQUIP_NAME[0], EQUIP_NAME[1] + "提升至" + NUM[0], NUM[1] + "级，受到门下众人敬仰！" };// 议事堂或养心阁升级至整十级
	private final static String[] CHARGE_5K = { "玩家" + PLAYER_NAME[0], PLAYER_NAME[1] + "财神附体，单笔充值达到" + NUM[0], NUM[1] + "元，众位屌丝快去抱大腿！" };// 单笔充值超过5千
	private final static String[] WORLD_BOSS_NOTICE = { "江湖追杀将在", "分钟后开启,请各位做好准备!", "江湖追杀 正在火热进行中,参加即可获得海量侠客经验和银两." };
	private final static int[] WORLD_BOSS_NOTICE_TIMERS = { 30, 45, 50, 55, };
	private final static String[] ACTY_ANS_NOTICE = { "金榜题名活动将于", "分钟后开启,请各位才子做好准备!", "金榜题名活动正在火热进行中，欢迎各位大侠踊跃答题。" };
	private final static String[] ACTY_ANS_END_NOTICE = { "金榜题名活动已经结束，恭喜以下获胜者：【状元】" + PLAYER_NAME[0], PLAYER_NAME[1] + ",【榜眼】" + PLAYER_NAME[0], PLAYER_NAME[1] + ",【探花】" + PLAYER_NAME[0],
			PLAYER_NAME[1] };

	private final static int[] ACTY_ANS_NOTICE_TIMERS = WORLD_BOSS_NOTICE_TIMERS;
	// };
	private static Object MUTEX_WORLDBOSS = new Object();

	public static void sendWorldBossNotice() {
		Calendar now = Calendar.getInstance();
		int minute = now.get(Calendar.MINUTE);

		synchronized (MUTEX_WORLDBOSS) {
			if (WorldBossVO.getInstance().isBattle()) {// 正在战斗中
				if (now.get(Calendar.MINUTE) % 10 == 0) {
					sendSysMsg(ACTY_ANS_NOTICE[2], TAGS[1], 1, HERO_NAME);
				}
			} else {
				int hour = now.get(Calendar.HOUR_OF_DAY) + 1;
				if (hour == ActyTimer.ANS_START_TIMES[0]) {// 开始前一个小时
					if (Arrays.binarySearch(ACTY_ANS_NOTICE_TIMERS, minute) >= 0) {// 在时间数组中
						sendSysMsg(ACTY_ANS_NOTICE[0] + ((60 - minute) > 30 ? 0 : (60 - minute)) + ACTY_ANS_NOTICE[1], TAGS[1], 1, HERO_NAME);
					}
				}
			}
		}
	}

	/**
	 * 答题活动通知
	 * */
	public static void sendAnsActyNotice() {
		Calendar now = Calendar.getInstance();
		int minute = now.get(Calendar.MINUTE);

		synchronized (MUTEX_WORLDBOSS) {
			if (ActivityConstant.isActyOpen(0)) {// 正在战斗中
				if (now.get(Calendar.MINUTE) % 10 == 0) {
					sendSysMsg(WORLD_BOSS_NOTICE[2], TAGS[1], 1, HERO_NAME);
				}
			} else {
				int hour = now.get(Calendar.HOUR_OF_DAY) + 1;
				if (hour == WorldBossVO.START_TIMES[0] || hour == WorldBossVO.START_TIMES[2]) {// 开始前一个小时
					if (Arrays.binarySearch(WORLD_BOSS_NOTICE_TIMERS, minute) >= 0) {// 在时间数组中
						sendSysMsg(WORLD_BOSS_NOTICE[0] + ((60 - minute) > 30 ? 0 : (60 - minute)) + WORLD_BOSS_NOTICE[1], TAGS[1], 1, HERO_NAME);
					}
				}
			}
		}
	}

	/**
	 * 直接包装颜色
	 * 
	 * @param msg
	 * @param name
	 * @param color
	 *            显示颜色
	 */
	public static void sendSysMsg(String msg, String name, String[] color) {
		sendSysMsg(msg, name);
	}

	/** 发送系统消息 */
	public static void sendSysMsg(String msg, String name) {
		sendSysMsg(msg, name, 0, null);
	}

	/**
	 * @param loc
	 *            显示位置
	 */
	public static void sendSysMsg(String msg, String name, int loc, String[] color) {
		try {
			msg = BadWordsFilter.filter(msg);
			if (color != null) {
				msg = new StringBuilder(color[0]).append(msg).append(color[1]).toString();
			}
			ChatResponse.Builder resp = ChatResponse.newBuilder().setDateTime(DateUtil.getNow()).setEChannel(EChannel.SYSTME_NOTICE).setMsg(msg).setName(name);
			NettyMessageVO nettyMessageVO = new NettyMessageVO();
			nettyMessageVO.setCommandCode(CSCommandConstant.CMD_CHAT);
			nettyMessageVO.setData(resp.build().toByteArray());
			ServerHandler.sendToAllOnlinePlayer(nettyMessageVO);
		} catch (Exception e) {
			LOGGER.error("系统消息发送错误" + e.getCause(), e);
		}
	}

	public static void sendSysTips() {
		String msg = new StringBuilder(TIP_NAME[0]).append(TipsRes.getInstance().getRandomTip().getContent()).append(TIP_NAME[1]).toString();
		ChatResponse.Builder resp = ChatResponse.newBuilder().setDateTime(DateUtil.getNow()).setEChannel(EChannel.SYSTME_NOTICE).setMsg(msg).setName(TAGS[2]);
		NettyMessageVO nettyMessageVO = new NettyMessageVO();
		nettyMessageVO.setCommandCode(CSCommandConstant.CMD_CHAT);
		nettyMessageVO.setData(resp.build().toByteArray());
		ServerHandler.sendToAllOnlinePlayer(nettyMessageVO);

	}

	public static String createAnsEndNotice(String[] names) {
		StringBuilder sb = new StringBuilder(ACTY_ANS_END_NOTICE[0]);
		if (names[0] != null) {
			sb.append(names[0]);
		}
		sb.append(ACTY_ANS_END_NOTICE[1]);
		if (names[1] != null) {
			sb.append(names[1]);
		}
		sb.append(ACTY_ANS_END_NOTICE[2]);
		if (names[2] != null) {
			sb.append(names[2]);
			sb.append(ACTY_ANS_END_NOTICE[3]);
		}
		return sb.toString();
	}

	public static String sendBossRankMail(String bossName, int hunt, int rank) {
		return new StringBuilder(WORLD_BOSS_RANK_MAIL[0]).append(bossName).append(WORLD_BOSS_RANK_MAIL[1]).append(hunt).append(WORLD_BOSS_RANK_MAIL[2]).append(rank).append(WORLD_BOSS_RANK_MAIL[3])
				.toString();
	}

	public static String sendAllBossPlayerMailEnd(String bossName) {
		return new StringBuilder(WORLD_BOSS_ALL_PLAYERS_MAIL_END[0]).append(bossName).append(WORLD_BOSS_ALL_PLAYERS_MAIL_END[1]).append(bossName).append(WORLD_BOSS_ALL_PLAYERS_MAIL_END[2]).toString();
	}

	public static String sendAllBossPlayerMailOver(String bossName) {
		return new StringBuilder(WORLD_BOSS_ALL_PLAYERS_MAIL_OVER[0]).append(bossName).append(WORLD_BOSS_ALL_PLAYERS_MAIL_OVER[1]).append(bossName).append(WORLD_BOSS_ALL_PLAYERS_MAIL_OVER[2])
				.toString();
	}

	public static String sendBossKillerMail(String bossName) {
		return new StringBuilder(WORLD_BOSS_KILL_MAIL[0]).append(bossName).append(WORLD_BOSS_KILL_MAIL[1]).toString();
	}

	/** 装备升级 */
	public final static String sendEquipUpdate(String name, String itemName, int oldStar, int newStar) {
		return new StringBuilder(EQUIP_UPDATE[0]).append(name).append(EQUIP_UPDATE[1]).append(String.valueOf(oldStar)).append(EQUIP_UPDATE[2]).append(itemName).append(EQUIP_UPDATE[3])
				.append(String.valueOf(newStar)).append(EQUIP_UPDATE[4]).append(itemName).append(EQUIP_UPDATE[5]).toString();
	}

	/** 英雄升级 */
	public final static String sendHeroUpdate(String playerName, int oldStar, String heroName, int newStar) {
		return new StringBuilder(HERO_UPDATE[0]).append(playerName).append(HERO_UPDATE[1]).append(oldStar).append(HERO_UPDATE[2]).append(heroName).append(HERO_UPDATE[3]).append(newStar)
				.append(HERO_UPDATE[4]).toString();
	}

	/** 元宝招募 */
	public final static String sendRMBHire(String playerName, int star, String heroName) {
		return new StringBuilder(RMB_HIRE[0]).append(playerName).append(RMB_HIRE[1]).append(star).append(RMB_HIRE[2]).append(heroName).append(RMB_HIRE[3]).toString();
	}

	/** 十连抽 */
	public final static String sendTenHire(String playerName, int star, String heroName) {
		return new StringBuilder(TEN_HIRE[0]).append(playerName).append(TEN_HIRE[1]).append(star).append(TEN_HIRE[2]).append(heroName).toString();
	}

	/** 积分招募 */
	public final static String sendScoreHire(String playerName, int star, String heroName) {
		return new StringBuilder(SCORE_HIRE[0]).append(playerName).append(SCORE_HIRE[1]).append(star).append(SCORE_HIRE[2]).append(heroName).toString();
	}

	/** 竞技场排名 */
	public final static String sendArenaRank(String name1, String name2, String name3) {
		return new StringBuilder(ARENA_RANK[0]).append(name1).append(ARENA_RANK[1]).append(name2).append(ARENA_RANK[2]).append(name3).toString();
	}

	/** 世界boss被击杀 */
	public final static String sendWorldBossKill(String heroName, String pName) {
		return new StringBuilder(WORLD_BOSS_KILL[0]).append(heroName).append(WORLD_BOSS_KILL[1]).append(pName).append(WORLD_BOSS_KILL[2]).toString();
	}

	/** 世界boss结束 */
	public final static String sendWorldBossEnd() {
		return TAGS[0] + WORLD_BOSS_END[0];
	}

	/** 华山论剑 */
	public final static String sendYuanZhen(String pName) {
		return new StringBuilder(YUAN_ZHENG[0]).append(pName).append(YUAN_ZHENG[1]).toString();
	}

	/** 华山论剑精英 */
	public final static String sendYuanZhenJingying(String pName) {
		return new StringBuilder(YUAN_ZHENG_JINGYING[0]).append(pName).append(YUAN_ZHENG_JINGYING[1]).toString();
	}

	/** vip升级 */
	public final static String sendVipUpdate(String pName, int vip) {
		return new StringBuilder(VIP_UPDATE[0]).append(pName).append(VIP_UPDATE[1]).append(vip).append(VIP_UPDATE[2]).toString();
	}

	/** 黄瓜仙子礼包 */
	public final static String sendVipGiftPack(String pName, int vip) {
		return new StringBuilder(VIP_UPDATE_GIFTPACK[0]).append(pName).append(VIP_UPDATE_GIFTPACK[1]).append(vip).append(VIP_UPDATE_GIFTPACK[2]).toString();
	}

	/** 建筑升级 */
	public final static String sendBuildUpdate(String pName, String itemName, int level) {
		return new StringBuilder(BUILD_UPDATE[0]).append(pName).append(BUILD_UPDATE[1]).append(itemName).append(BUILD_UPDATE[2]).append(level).append(BUILD_UPDATE[3]).toString();
	}

	/** 充值超过5k */
	public final static String sendChange5K(String pName, int rmb) {
		return new StringBuilder(CHARGE_5K[0]).append(pName).append(CHARGE_5K[1]).append(rmb).append(CHARGE_5K[2]).toString();
	}

	public static String[] getPlayerName() {
		return PLAYER_NAME;
	}

	public static String[] getHeroName() {
		return HERO_NAME;
	}

	public static String[] getEquipName() {
		return EQUIP_NAME;
	}

	public static String[] getTipName() {
		return TIP_NAME;
	}

	public static String[] getSysNoticeName() {
		return SYS_NOTICE_NAME;
	}
}
