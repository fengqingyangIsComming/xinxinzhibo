package cc.mrbird.merchant.domain;

import cc.mrbird.common.annotation.ExportConfig;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by  AndyZhou
 * 2018/9/5   10:04
 */
@Table(name = "dp_order")
public class DpOrder implements Serializable {

	private static final long serialVersionUID = -7790334862410409053L;
	/**
	 * 用户支付类型
	 */
	public static final String TYPE_PAY_ONLINE = "1";

	public static final String TYPRE_PAY_OFFLine = "2";
	/**
	 * 支付状态
	 * 状态：1、未付款，2、已付款，3、未发货，4.已发货，5、交易成功，6、交易关闭
	 */
	public static final String STATUS_NON_PAYMENT = "1";
	public static final String STATUS_ACCOUNT_PAID = "2";
	public static final String STATUS_NOT_YET_SHIPPED = "3";
	public static final String STATUS_SHIPPED = "4";
	public static final String STATUS_TRADE_SUCCESSFULLY = "5";
	public static final String STATUS_TRADE_CLOSED = "6";

	/**
	 * 退款状态 1待退款 2退款成功
	 */
	public static final String STATUS_WAIT_REFUND = "1";
	public static final String STATUS_REFUND_SUCCESSFULLY = "2";

	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;
	private String userId;
	private BigDecimal price;

	//@Column(name = "shop_price")
	@ExportConfig(value = "商家总收入")
	private BigDecimal shopPrice;


	private BigDecimal discountPrice;


	private BigDecimal userPrice;


	private Integer paymentType;


	private String billNo;


	private Integer status;


	private Date crateTime;


	private Date updateTime;


	private Date payTime;


	private Date refundTime;


	private Integer refundStatus;


	private String shopId;


	private String shopName;


	private String shopLogo;


	private String shopType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(BigDecimal shopPrice) {
		this.shopPrice = shopPrice;
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public BigDecimal getUserPrice() {
		return userPrice;
	}

	public void setUserPrice(BigDecimal userPrice) {
		this.userPrice = userPrice;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCrateTime() {
		return crateTime;
	}

	public void setCrateTime(Date crateTime) {
		this.crateTime = crateTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Date getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
	}

	public Integer getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(Integer refundStatus) {
		this.refundStatus = refundStatus;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopLogo() {
		return shopLogo;
	}

	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}

	public String getShopType() {
		return shopType;
	}

	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	@Override
	public String toString() {
		return "DpOrder{" +
				"id=" + id +
				", userId='" + userId + '\'' +
				", price=" + price +
				", shopPrice=" + shopPrice +
				", discountPrice=" + discountPrice +
				", userPrice=" + userPrice +
				", paymentType=" + paymentType +
				", billNo='" + billNo + '\'' +
				", status=" + status +
				", crateTime=" + crateTime +
				", updateTime=" + updateTime +
				", payTime=" + payTime +
				", refundTime=" + refundTime +
				", refundStatus=" + refundStatus +
				", shopId='" + shopId + '\'' +
				", shopName='" + shopName + '\'' +
				", shopLogo='" + shopLogo + '\'' +
				", shopType='" + shopType + '\'' +
				'}';
	}
}
