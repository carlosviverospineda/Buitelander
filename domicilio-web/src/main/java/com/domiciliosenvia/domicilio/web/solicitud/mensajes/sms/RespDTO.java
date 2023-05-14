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
public class RespDTO {
    @JsonProperty("status")
    private int status;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("result")
    private RespResultDTO result;

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

    public RespResultDTO getResult() {
        return result;
    }

    public void setResult(RespResultDTO result) {
        this.result = result;
    }
}
