package cx.consumable.entity;

import java.math.BigDecimal;

public class CxConsumable {
    private Integer conId;
    private String conBrand;
    private String conCompatible;
    private String conCode;
    private String conModel;
    private String conDetails;
    private String conNum;
    private BigDecimal conReferencePrice;

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getConBrand() {
        return conBrand;
    }

    public void setConBrand(String conBrand) {
        this.conBrand = conBrand;
    }

    public String getConCompatible() {
        return conCompatible;
    }

    public void setConCompatible(String conCompatible) {
        this.conCompatible = conCompatible;
    }

    public String getConCode() {
        return conCode;
    }

    public void setConCode(String conCode) {
        this.conCode = conCode;
    }

    public String getConModel() {
        return conModel;
    }

    public void setConModel(String conModel) {
        this.conModel = conModel;
    }

    public String getConDetails() {
        return conDetails;
    }

    public void setConDetails(String conDetails) {
        this.conDetails = conDetails;
    }

    public String getConNum() {
        return conNum;
    }

    public void setConNum(String conNum) {
        this.conNum = conNum;
    }

    public BigDecimal getConReferencePrice() {
        return conReferencePrice;
    }

    public void setConReferencePrice(BigDecimal conReferencePrice) {
        this.conReferencePrice = conReferencePrice;
    }
}
