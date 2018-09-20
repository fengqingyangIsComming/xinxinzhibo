package cc.mrbird.merchant.domain;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 宝兆用户实体类（Live_UserInfo表）
 * @author Yxy
 * @date 2018/7/26 13:00
 */
@Table(name = "Live_UserInfo")
public class LiveUserInfo implements Serializable {


    private Long userIdx;

    private String userId;

    private Integer gender;

    private String myname;

    private String signatures;

    private String smallpic;

    private String bigpic;

    private Integer starnotify;

    private Date addTime;

    private Date lastLoginTime;

    private Integer rtmpId;

    private Integer level;

    private String devType;

    private Integer grade;

    private Long curexp;

    private String province;

    private String city;

    private String pass;

    private String thirdId;

    private String unionid;

    private String registerIp;

    private String thirdType;

    private String inviteCode;

    private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

    public Long getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(Long userIdx) {
        this.userIdx = userIdx;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getMyname() {
        return myname;
    }

    public void setMyname(String myname) {
        this.myname = myname;
    }

    public String getSignatures() {
        return signatures;
    }

    public void setSignatures(String signatures) {
        this.signatures = signatures;
    }

    public String getSmallpic() {
        return smallpic;
    }

    public void setSmallpic(String smallpic) {
        this.smallpic = smallpic;
    }

    public String getBigpic() {
        return bigpic;
    }

    public void setBigpic(String bigpic) {
        this.bigpic = bigpic;
    }

    public Integer getStarnotify() {
        return starnotify;
    }

    public void setStarnotify(Integer starnotify) {
        this.starnotify = starnotify;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getRtmpId() {
        return rtmpId;
    }

    public void setRtmpId(Integer rtmpId) {
        this.rtmpId = rtmpId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDevType() {
        return devType;
    }

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Long getCurexp() {
        return curexp;
    }

    public void setCurexp(Long curexp) {
        this.curexp = curexp;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public String getThirdType() {
        return thirdType;
    }

    public void setThirdType(String thirdType) {
        this.thirdType = thirdType;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}
