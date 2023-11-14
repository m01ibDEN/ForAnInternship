package com.m01libDEN.ForAnInternship;

import java.util.*;
import java.util.stream.Collectors;

public class Algorithm {
    private final String string;
    Algorithm(String string) {
        this.string = string;
    }
    private int count(String str, Character c) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.toCharArray()[i] == c) counter++;
        }
        return counter;
    }
    public String util() {
        if(string.isEmpty()) return string;
        Map<String, Integer> map = new TreeMap<>();
        for(char c : this.string.toCharArray()) {
            if(map.containsKey("\"" + c + "\"")) continue;
            map.put("\"" + c + "\"", count(this.string, c));
        }

        LinkedHashMap<String, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return sortedMap.entrySet()
                .toString().replace("=", " : ")
                .replace("[", "").replace("]", "");
    }
}

