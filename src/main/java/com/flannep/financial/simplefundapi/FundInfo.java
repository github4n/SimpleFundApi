package com.flannep.financial.simplefundapi;

import net.sf.json.JSONObject;

/**
 * 代表一个基金的简单信息
 */
public class FundInfo {
    private JSONObject json;

    FundInfo(JSONObject json) {
        if (json == null) {
            throw new NullPointerException("fundinfo json can not be null");
        }
        this.json = json;
    }


    /**
     * 获取基金ID
     *
     * @return 例:001630
     */
    public String getFundCode() {
        if (json.containsKey("fundcode")) {
            return json.getString("fundcode");
        }
        return null;
    }

    /**
     * 获取基金名称
     *
     * @return 例:天弘中证计算机主题指数C
     */
    public String getName() {
        if (json.containsKey("name")) {
            return json.getString("name");
        }
        return null;
    }

    /**
     * 上一个交易日的净值日期
     *
     * @return 例:2019-03-27
     */
    public String getYesterdayNavDate() {
        if (json.containsKey("jzrq")) {
            return json.getString("jzrq");
        }
        return null;
    }

    /**
     * 获取单位净值
     *
     * @return 例如:0.7269
     */
    public String getYesterdayNav() {
        if (json.containsKey("dwjz")) {
            return json.getString("dwjz");
        }
        return null;
    }

    /**
     * 获取当前的估算净值
     *
     * @return 例：0.7174
     */
    public String getTodayNav() {
        if (json.containsKey("gsz")) {
            return json.getString("gsz");
        }
        return null;
    }

    /**
     * 获取当前估算净值和上一日净值的涨跌幅
     *
     * @return 例: -1.30
     */
    public String getChangePct() {
        if (json.containsKey("gszzl")) {
            return json.getString("gszzl");
        }
        return null;
    }

    /**
     * 获取估值日期
     *
     * @return 例: 2019-03-28 15:00
     */
    public String getTodayNavTime() {
        if (json.containsKey("gztime")) {
            return json.getString("gztime");
        }
        return null;
    }

    //public String

    @Override
    public String toString() {
        return json.toString();
    }
}
