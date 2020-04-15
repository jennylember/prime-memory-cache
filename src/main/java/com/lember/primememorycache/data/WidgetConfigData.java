package com.lember.primememorycache.data;

import java.util.List;

public interface WidgetConfigData {
    List<String> getDatasets();

    void setDatasets(List<String> var1);

    int getMaxH();

    void setMaxH(int var1);

    int getMaxW();

    void setMaxW(int var1);

    int getMinH();

    void setMinH(int var1);

    int getMinW();

    void setMinW(int var1);

    LocaleItemData getName();

    void setName(LocaleItemData var1);

    boolean isPaging();

    void setPaging(boolean var1);

    WidgetType getType();

    void setType(WidgetType var1);
}
