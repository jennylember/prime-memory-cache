package com.lember.primememorycache.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lember.primememorycache.data.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Widget implements Identifiable, WidgetConfigData {
    private String id;

    @JsonDeserialize(as = BilingualEntity.class)
    private LocaleItemData name;

    /**
     * Максимальная ширина по оси X
     */
    private int maxW;

    /**
     * Максимальная высота по оси Y
     */
    private int maxH;

    /**
     * Минимальная ширина по оси X
     */
    private int minW;

    /**
     * Минимальная высота по оси Y
     */
    private int minH;

    /**
     * Тип виджета
     */
    private WidgetType type;

    /**
     * Типы сущностей, с которыми работает данный виджет
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> datasets;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean paging;

    @Override
    public boolean isPaging() {
        return paging;
    }

    @Override
    public void setPaging(boolean paging) {
        this.paging = paging;
    }
}
