package com.flannep.financial.simplefundapi.viewer;

import com.flannep.financial.simplefundapi.FundInfo;

public class SimpleViewer extends AbstractViewer {
    @Override
    public String getInfo(FundInfo info) {
        String content = "------%s------\n" +
                "基金名称: %s\n" +
                "估值日期: %s\n" +
                "涨跌幅度: %s%%\n";

        return String.format(content
                , info.getFundCode()
                , info.getName()
                , info.getTodaysNavTime()
                , info.getChangePct());
    }
}
