package com.flannep.financial.simplefundapi.viewer;

import com.flannep.financial.simplefundapi.FundInfo;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractViewer {

    public abstract String getInfo(FundInfo info);

    /**
     * 获取基金信息
     *
     * @param viewer
     * @param infoList
     * @return
     */
    public static List<String> getInfo(AbstractViewer viewer, List<FundInfo> infoList) {
        List<String> list = new ArrayList<>();
        for (FundInfo fundInfo : infoList) {
            list.add(viewer.getInfo(fundInfo));
        }
        return list;
    }

    /**
     * 获取基金信息
     *
     * @param viewer
     * @param info
     * @return
     */
    public static String getInfo(AbstractViewer viewer, FundInfo info) {
        return viewer.getInfo(info);
    }

}
