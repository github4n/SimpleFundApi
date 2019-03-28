package com.flannep.financial.simplefundapi;

import com.flannep.financial.simplefundapi.exception.FundIDNotExistException;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FundUtil {

    /**
     * 获取单个基金
     *
     * @param fundID
     * @return
     * @throws Exception
     */
    public static FundInfo getFund(String fundID) throws Exception {
        Map<String, String> header = new HashMap<>();
        String webContent = NetUtil.sendGet(String.format("http://fundgz.1234567.com.cn/js/%s.js", fundID), header);
        webContent = webContent.substring(webContent.indexOf("(") + 1, webContent.lastIndexOf(")"));
        if (webContent.contains("errText")) {
            throw new FundIDNotExistException("基金ID不存在");
        }
        JSONObject json = JSONObject.fromObject(webContent);
        return new FundInfo(json);
    }

    /**
     * 获取指定基金list中的信息
     *
     * @param fundIDs
     * @return
     * @throws Exception
     */
    public static List<FundInfo> getFunds(List<String> fundIDs) throws Exception {
        List<FundInfo> result = new ArrayList<>();
        for (String fundID : fundIDs) {
            result.add(getFund(fundID));
        }
        return result;
    }


    public static String getInfoString(FundInfo info) {
        String content = "------%s------\n" +
                "基金名称: %s\n" +
                "收盘日期: %s\n" +
                "收盘净值: %s\n" +
                "估值日期: %s\n" +
                "估算净值: %s\n" +
                "涨跌幅度: %s%%\n";

        return String.format(content
                , info.getFundCode()
                , info.getName()
                , info.getYesterdayNavDate()
                , info.getYesterdayNav()
                , info.getTodayNavTime()
                , info.getTodayNav()
                , info.getChangePct());

    }

    public static String getInfoListString(List<FundInfo> infoList) {
        StringBuilder sb = new StringBuilder();

        sb.append("=====基金信息=====\n");
        for (FundInfo fundInfo : infoList) {
            sb.append(getInfoString(fundInfo));
        }
        sb.append("==============\n");
        return sb.toString();
    }

}
