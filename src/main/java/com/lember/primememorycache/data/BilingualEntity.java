package com.lember.primememorycache.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BilingualEntity implements LocaleItemData {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;

    private String nameRus;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nameEng;

    public static BilingualEntity of(@Nullable String id, @NonNull String nameRus, @Nullable String nameEng) {
        return new BilingualEntity(id, nameRus, nameEng);
    }

    public static BilingualEntity of(@NonNull String nameRus, @Nullable String nameEng) {
        return new BilingualEntity(null, nameRus, nameEng);
    }
}
