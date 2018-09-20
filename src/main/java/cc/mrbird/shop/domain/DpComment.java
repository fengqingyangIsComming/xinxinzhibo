package cc.mrbird.shop.domain;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Table(name = "dp_comment")
public class DpComment implements Serializable {
    private Long id;

    private Integer shopId;

    private Long userId;

    private Double level;

    private Date created;

    private Date updated;

    private String image;

    private Integer isImage;

    private String levelcontent;

    private String impressions;

    private Double percapita;

    private Double mlevel;

    private Double slevel;

    private Double rlevel;

    private String content;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getLevel() {
        return level;
    }

    public void setLevel(Double level) {
        this.level = level;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getIsImage() {
        return isImage;
    }

    public void setIsImage(Integer isImage) {
        this.isImage = isImage;
    }

    public String getLevelcontent() {
        return levelcontent;
    }

    public void setLevelcontent(String levelcontent) {
        this.levelcontent = levelcontent == null ? null : levelcontent.trim();
    }

    public String getImpressions() {
        return impressions;
    }

    public void setImpressions(String impressions) {
        this.impressions = impressions == null ? null : impressions.trim();
    }

    public Double getPercapita() {
        return percapita;
    }

    public void setPercapita(Double percapita) {
        this.percapita = percapita;
    }

    public Double getMlevel() {
        return mlevel;
    }

    public void setMlevel(Double mlevel) {
        this.mlevel = mlevel;
    }

    public Double getSlevel() {
        return slevel;
    }

    public void setSlevel(Double slevel) {
        this.slevel = slevel;
    }

    public Double getRlevel() {
        return rlevel;
    }

    public void setRlevel(Double rlevel) {
        this.rlevel = rlevel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    //用于搜索的时间字段
    @Transient
    private String timeField;

    @Transient
    private String username;

    public String getTimeField() {
        return timeField;
    }

    public void setTimeField(String timeField) {
        this.timeField = timeField;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}