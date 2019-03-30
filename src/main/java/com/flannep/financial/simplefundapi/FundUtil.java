package com.flannep.financial.simplefundapi;

import com.flannep.financial.simplefundapi.exception.FundIDNotExistException;
import com.flannep.financial.simplefundapi.viewer.AbstractViewer;
import com.flannep.financial.simplefundapi.viewer.DetailViewer;
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

    /**
     * 获取单只基金信息
     *
     * @param info
     * @return
     * @deprecated 请使用Viewer获取基金信息
     */
    @Deprecated
    public static String getInfoString(FundInfo info) {
        AbstractViewer viewer = new DetailViewer();
        return AbstractViewer.getInfo(viewer,info);
    }

    /**
     * 获取基金信息
     *
     * @param infoList
     * @return
     * @deprecated 请使用Viewer获取基金信息
     */
    @Deprecated
    public static String getInfoListString(List<FundInfo> infoList) {
        StringBuilder sb = new StringBuilder();

        sb.append("=====基金信息=====\n");
        for (String str : AbstractViewer.getInfo(new DetailViewer(), infoList)) {
            sb.append(str);
        }
        sb.append("==============\n");
        return sb.toString();
    }

}
