package com.json.mapping.module;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SiblingChild {
    @JsonProperty(value = "leafId")
    private Integer leafId;
    @JsonProperty(value = "smsPeriodId")
    private String smsPeriodId;
    @JsonProperty(value = "year")
    private String year;
    @JsonProperty(value = "periodStartDate")
    private String periodStartDate;
    @JsonProperty(value = "periodEndDate")
    private String periodEndDate;
    @JsonProperty(value = "periodDesc")
    private String periodDesc;
    @JsonProperty(value = "periodTag")
    private String periodTag;
    @JsonProperty(value = "periodLabel")
    private String periodLabel;
    @JsonProperty(value = "noOfDays")
    private String noOfDays;
    @JsonProperty(value = "periodSeq")
    private String periodSeq;
    @JsonProperty(value = "switchPeriodSet")
    private String switchPeriodSet;

    public Integer getLeafId() {
        return leafId;
    }

    public void setLeafId(Integer leafId) {
        this.leafId = leafId;
    }

    public String getSmsPeriodId() {
        return smsPeriodId;
    }

    public void setSmsPeriodId(String smsPeriodId) {
        this.smsPeriodId = smsPeriodId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPeriodStartDate() {
        return periodStartDate;
    }

    public void setPeriodStartDate(String periodStartDate) {
        this.periodStartDate = periodStartDate;
    }

    public String getPeriodEndDate() {
        return periodEndDate;
    }

    public void setPeriodEndDate(String periodEndDate) {
        this.periodEndDate = periodEndDate;
    }

    public String getPeriodDesc() {
        return periodDesc;
    }

    public void setPeriodDesc(String periodDesc) {
        this.periodDesc = periodDesc;
    }

    public String getPeriodTag() {
        return periodTag;
    }

    public void setPeriodTag(String periodTag) {
        this.periodTag = periodTag;
    }

    public String getPeriodLabel() {
        return periodLabel;
    }

    public void setPeriodLabel(String periodLabel) {
        this.periodLabel = periodLabel;
    }

    public String getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(String noOfDays) {
        this.noOfDays = noOfDays;
    }

    public String getPeriodSeq() {
        return periodSeq;
    }

    public void setPeriodSeq(String periodSeq) {
        this.periodSeq = periodSeq;
    }

    public String getSwitchPeriodSet() {
        return switchPeriodSet;
    }

    public void setSwitchPeriodSet(String switchPeriodSet) {
        this.switchPeriodSet = switchPeriodSet;
    }
}
