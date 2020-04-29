package com.lember.primememorycache;

import com.lember.primememorycache.data.Identifiable;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public abstract class FileStorage<T extends Identifiable> extends HashMap<String, T> {

    @Getter
    protected File parentDir;

    @Getter
    protected File file;

    protected FileStorage(@NonNull File parentDir) throws IOException {
        this.file = new File(parentDir, getFileName());
        if (!this.file.exists()) {
            this.file.createNewFile();
        }
        this.parse();
    }

    @Override
    public T put(String key, T item) {
        T result = super.put(key, item);
        synchronize();
        return result;
    }

    @Override
    public void clear() {
        super.clear();
        synchronize();
    }

    public void synchronize() {
        try {
            String jsonContent = Json.toJsonStringOrFail(toList());
            Files.write(file.toPath(), jsonContent.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            log.error("Error saving to file {}: {}", file, e);
        }
    }

    public List<T> toList() {
        return keySet()
                .stream()
                .map(key -> {
                    T item = get(key);
                    item.setId(key);
                    return item;
                })
                .collect(Collectors.toList());
    }

    private void parse() {
        try {
            String json = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
            if (!StringUtils.isEmpty(json)) {
                parseJsonContent(json).forEach(item -> super.put(item.getId(), item));
            }
        } catch (Exception e) {
            log.error("Error parsing widgets file {}: {}", file, e);
        }
    }

    @NonNull
    public abstract String getFileName();

    @NonNull
    protected abstract List<T> parseJsonContent(@NonNull String json);
}