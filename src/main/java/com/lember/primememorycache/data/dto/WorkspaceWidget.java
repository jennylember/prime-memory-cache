package com.lember.primememorycache.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lember.primememorycache.data.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkspaceWidget implements Identifiable, WidgetData {

    private String id;

    @JsonDeserialize(as = BilingualEntity.class)
    private LocaleItemData name;

    /**
     * Положение верхнего левого угла виджета по оси x
     */
    private int x;

    /**
     * Положение верхнего левого угла виджета по оси y
     */
    private int y;

    /**
     * Ширина
     */
    private int w;

    /**
     * Высота
     */
    private int h;

    /**
     * Флаг, указывающий фронтенду, что виджет закреплен
     */
    @JsonInclude(
            value = JsonInclude.Include.CUSTOM,
            valueFilter = BooleanValueFilter.class
    )
    private boolean pinned;

    private static class BooleanValueFilter {
        @Override
        public boolean equals(Object other) {
            return !Boolean.TRUE.equals(other);
        }
    }
}
