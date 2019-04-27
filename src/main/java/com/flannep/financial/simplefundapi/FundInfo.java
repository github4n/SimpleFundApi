/**
 * Copyright 2019 bejson.com
 */
package com.flannep.financial.simplefundapi;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Auto-generated: 2019-04-27 10:21:30
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class FundInfo {

    @SerializedName(value = "fundCode", alternate = {"fundcode"})
    private String fundCode;

    @SerializedName(value = "fundName", alternate = {"name"})
    private String name;
    @SerializedName(value = "yesterdayNavDate", alternate = {"jzrq"})
    private String yesterdayNavDate;
    @SerializedName(value = "yesterdayNav", alternate = {"dwjz"})
    private String yesterdayNav;
    @SerializedName(value = "todaysNav", alternate = {"gsz"})
    private String todaysNav;
    @SerializedName(value = "changePct", alternate = {"gszzl"})
    private String changePct;
    @SerializedName(value = "todaysNavTime", alternate = {"gztime"})
    private String todaysNavTime;


    public String getFundCode() {
        return fundCode;
    }

    public String getName() {
        return name;
    }

    public String getYesterdayNavDate() {
        return yesterdayNavDate;
    }

    public double getYesterdayNav() {
        return Double.valueOf(yesterdayNav);
    }

    public double getTodaysNav() {
        return Double.valueOf(todaysNav);
    }

    public double getChangePct() {
        return Double.valueOf(changePct);
    }

    public String getTodaysNavTime() {
        return todaysNavTime;
    }


    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYesterdayNavDate(String yesterdayNavDate) {
        this.yesterdayNavDate = yesterdayNavDate;
    }

    public void setYesterdayNav(double yesterdayNav) {
        this.yesterdayNav = yesterdayNav + "";
    }

    public void setTodaysNav(double todaysNav) {
        this.todaysNav = todaysNav + "";
    }

    public void setChangePct(double changePct) {
        this.changePct = changePct + "";
    }

    public void setTodaysNavTime(String todaysNavTime) {
        this.todaysNavTime = todaysNavTime;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}