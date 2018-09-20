package cc.mrbird.merchant.domain;

import java.io.Serializable;
import java.util.Date;

public class DpInvitrRecord implements Serializable {
    private Long id;

    private Long inviter;

    private Long invitee;

    private Date creatTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInviter() {
        return inviter;
    }

    public void setInviter(Long inviter) {
        this.inviter = inviter;
    }

    public Long getInvitee() {
        return invitee;
    }

    public void setInvitee(Long invitee) {
        this.invitee = invitee;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}