package cx.announcement.entity;

import java.util.Date;

public class CxAnnouncement {
    private Integer anId;
    private String anDetails;
    private String anStatus;
    private Date createDate;

    public Integer getAnId() {
        return anId;
    }

    public void setAnId(Integer anId) {
        this.anId = anId;
    }

    public String getAnDetails() {
        return anDetails;
    }

    public void setAnDetails(String anDetails) {
        this.anDetails = anDetails;
    }

    public String getAnStatus() {
        return anStatus;
    }

    public void setAnStatus(String anStatus) {
        this.anStatus = anStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
