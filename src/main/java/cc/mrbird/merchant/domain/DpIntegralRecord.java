package cc.mrbird.merchant.domain;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 积分实体类
 *
 */
@Table(name = "dp_integral_record")
public class DpIntegralRecord implements Serializable {
    private Integer id;

    private Integer pid;

    private Integer status;

    private Date createtime;
	//管理人员
    private String manager;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}