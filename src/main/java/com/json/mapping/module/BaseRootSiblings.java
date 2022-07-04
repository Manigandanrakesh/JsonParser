package com.json.mapping.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties
@JsonRootName("serviceStatus")
public class BaseRootSiblings {
    @JsonProperty(value = "statusFlag")
    private String statusFlag;
    @JsonProperty(value = "statusCode")
    private String statusCode;
    @JsonProperty(value = "statusMsg")
    private String statusMsg;

    public String getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(String statusFlag) {
        this.statusFlag = statusFlag;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }
}
