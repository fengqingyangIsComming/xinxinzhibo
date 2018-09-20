package cc.mrbird.merchant.domain;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * 商家实体类（商家子类，补充商家缺失的字段）
 */
@Table(name = "dp_shop_user")
public class DpShopUser implements Serializable {
    private Integer id;

    private Integer pid;

    private Long useridx;

    private String username;

    private String phone;

    private String telephone;

    private String email;

    private String paymentType;

    private String product;

    private String impressions;

    private String businessProof;

    private String otherProof;

    private String attach;

    private String storeImage;

    private String pass;

    private Integer status;

    private String country;

    private String pCDistrict;

    private String registrationNumber;

    private String reason;

    private String invitedCode;

    //操作人员
    private String operator;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Long getUseridx() {
        return useridx;
    }

    public void setUseridx(Long useridx) {
        this.useridx = useridx;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getImpressions() {
        return impressions;
    }

    public void setImpressions(String impressions) {
        this.impressions = impressions == null ? null : impressions.trim();
    }

    public String getBusinessProof() {
        return businessProof;
    }

    public void setBusinessProof(String businessProof) {
        this.businessProof = businessProof == null ? null : businessProof.trim();
    }

    public String getOtherProof() {
        return otherProof;
    }

    public void setOtherProof(String otherProof) {
        this.otherProof = otherProof == null ? null : otherProof.trim();
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach == null ? null : attach.trim();
    }

    public String getStoreImage() {
        return storeImage;
    }

    public void setStoreImage(String storeImage) {
        this.storeImage = storeImage == null ? null : storeImage.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getpCDistrict() {
        return pCDistrict;
    }

    public void setpCDistrict(String pCDistrict) {
        this.pCDistrict = pCDistrict;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getInvitedCode() {
        return invitedCode;
    }

    public void setInvitedCode(String invitedCode) {
        this.invitedCode = invitedCode;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}