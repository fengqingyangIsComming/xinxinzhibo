package cc.mrbird.merchant.domain;
import cc.mrbird.common.annotation.ExportConfig;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商家实体类（主要针对前端展示）
 */
@Table(name = "dp_shop")
public class DpShop implements Serializable {

	private Integer id;

	@ExportConfig(value = "店铺名称")
	private String name;

	@ExportConfig(value = "商家总收入MYR")
	@Transient
	private BigDecimal shopPrice;

	private String logo;

	private BigDecimal avgPrice;

	private String type;

	private String des;

	private Double level;

	private Integer praise;

	@ExportConfig(value = "店铺注册时间")
	private Date created;

	private Date updated;

	private Integer man;

	private Integer jian;

	private BigDecimal sale;

	private String address;

	private Integer typeId;

	private String jingdu;

	private String weidu;

	private String juli;

	@ExportConfig(value = "店铺评价分数")
	private Integer popularity;

	private String businessTime;

	private String images;

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public BigDecimal getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(BigDecimal avgPrice) {
		this.avgPrice = avgPrice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Double getLevel() {
		return level;
	}

	public void setLevel(Double level) {
		this.level = level;
	}

	public Integer getPraise() {
		return praise;
	}

	public void setPraise(Integer praise) {
		this.praise = praise;
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

	public Integer getMan() {
		return man;
	}

	public void setMan(Integer man) {
		this.man = man;
	}

	public Integer getJian() {
		return jian;
	}

	public void setJian(Integer jian) {
		this.jian = jian;
	}

	public BigDecimal getSale() {
		return sale;
	}

	public void setSale(BigDecimal sale) {
		this.sale = sale;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getJingdu() {
		return jingdu;
	}

	public void setJingdu(String jingdu) {
		this.jingdu = jingdu;
	}

	public String getWeidu() {
		return weidu;
	}

	public void setWeidu(String weidu) {
		this.weidu = weidu;
	}

	public String getJuli() {
		return juli;
	}

	public void setJuli(String juli) {
		this.juli = juli;
	}

	public Integer getPopularity() {
		return popularity;
	}

	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}

	public String getBusinessTime() {
		return businessTime;
	}

	public void setBusinessTime(String businessTime) {
		this.businessTime = businessTime;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
	public BigDecimal getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(BigDecimal shopPrice) {
		this.shopPrice = shopPrice;
	}

	//不是表中的字段
	@Transient
	private String typeName;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}