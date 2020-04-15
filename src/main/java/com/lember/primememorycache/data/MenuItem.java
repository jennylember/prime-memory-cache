package com.lember.primememorycache.data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem implements NodeData, Identifiable {
    private String id;

    @JsonDeserialize(as = BilingualEntity.class)
    private LocaleItemData name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonDeserialize(contentAs = MenuItem.class)
    private List<NodeData> children;

    @Override
    public void setName(LocaleItemData localeItemData) {
        this.name = localeItemData;
    }
}
