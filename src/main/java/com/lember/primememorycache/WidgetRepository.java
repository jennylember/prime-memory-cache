package com.lember.primememorycache;

import java.util.List;
import com.lember.primememorycache.data.*;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;


public interface WidgetRepository {
    @Nullable
    Widget getWidgetById(@NonNull String id);

    @Nullable
    Workspace getWorkspaceById(@NonNull String id);

    @NonNull
    List<Widget> getWidgets();

    @NonNull
    List<Workspace> getWorkspaces();

    void saveWidget(@NonNull Widget widget);

    void saveWorkspace(@NonNull Workspace workspace);

}
