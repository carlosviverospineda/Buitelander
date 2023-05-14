/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.web.solicitud.mensajes.sms;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author jramirez
 */
public class RespFailedRequest {
    @JsonProperty("mobile")
    private String mobile;
    @JsonProperty("transactionId")
    private String transactionId;
    @JsonProperty("status")
    private int status;
    @JsonProperty("reason")
    private String reason;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
