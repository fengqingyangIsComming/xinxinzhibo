package cc.mrbird.merchant.domain;

import javax.persistence.Table;
import java.util.Date;

/**
 * Created by  AndyZhou
 * 2018/9/19   09:41
 */
@Table(name = "RoomOnLineUser")
public class RoomOnLineUser {

	//审核通过
	public static final String GET_APPROVED = "1";
	//下线
	public static final String OFF_LINE = "2";
	//封号
	public static final String FREEZE_ONES_ID = "3";

	private Integer userIdx;
	private Integer roomId;
	private Date stardate;
	private Integer publicmic;
	private String postion;
	private String ttsinfo;
	private String flv;
	private String m3u8;
	private String nickname;
	private String photo;

	private double longitude;
	private double latitude;
	private String province;

	public Integer getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(Integer userIdx) {
		this.userIdx = userIdx;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Date getStardate() {
		return stardate;
	}

	public void setStardate(Date stardate) {
		this.stardate = stardate;
	}

	public Integer getPublicmic() {
		return publicmic;
	}

	public void setPublicmic(Integer publicmic) {
		this.publicmic = publicmic;
	}

	public String getPostion() {
		return postion;
	}

	public void setPostion(String postion) {
		this.postion = postion;
	}

	public String getTtsinfo() {
		return ttsinfo;
	}

	public void setTtsinfo(String ttsinfo) {
		this.ttsinfo = ttsinfo;
	}

	public String getFlv() {
		return flv;
	}

	public void setFlv(String flv) {
		this.flv = flv;
	}

	public String getM3u8() {
		return m3u8;
	}

	public void setM3u8(String m3u8) {
		this.m3u8 = m3u8;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
}
