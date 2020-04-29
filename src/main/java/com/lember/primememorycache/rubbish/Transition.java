package com.lember.primememorycache.rubbish;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Transition {

    public static final String STATUS_ACTIVE = "Активно";
    public static final String STATUS_INACTIVE = "Неактивно";

    public static final List<String> AVAILABLE_STATUSES = Stream.of("Статус1", "Статус2").collect(Collectors.toList());

    public static Map<String, String> statusesCache = new HashMap<>();

    public String status;

}
