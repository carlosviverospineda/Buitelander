/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domiciliosenvia.domicilio.web.solicitud.mensajes.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author jramirez
 */
public class RespResultDTO {
    @JsonProperty("totalRequest")
    private int totalRequest;
    @JsonProperty("totalFailed")
    private int totalFailed;
    @JsonProperty("receivedRequests")
    private List<RespRecivedRequest> receivedRequests;
    @JsonProperty("failedRequests")
    private List<RespFailedRequest> failedRequests;
    @JsonProperty("dateToSend")
    private String dateToSend;
    @JsonProperty("timeZone")
    private String timeZone;

    public int getTotalRequest() {
        return totalRequest;
    }

    public void setTotalRequest(int totalRequest) {
        this.totalRequest = totalRequest;
    }

    public int getTotalFailed() {
        return totalFailed;
    }

    public void setTotalFailed(int totalFailed) {
        this.totalFailed = totalFailed;
    }

    public List<RespRecivedRequest> getReceivedRequests() {
        return receivedRequests;
    }

    public void setReceivedRequests(List<RespRecivedRequest> receivedRequests) {
        this.receivedRequests = receivedRequests;
    }

    public List<RespFailedRequest> getFailedRequests() {
        return failedRequests;
    }

    public void setFailedRequests(List<RespFailedRequest> failedRequests) {
        this.failedRequests = failedRequests;
    }

    public String getDateToSend() {
        return dateToSend;
    }

    public void setDateToSend(String dateToSend) {
        this.dateToSend = dateToSend;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
