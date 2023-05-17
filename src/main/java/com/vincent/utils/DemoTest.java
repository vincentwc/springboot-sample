package com.vincent.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

public class DemoTest {


    public static void main(String[] args) {

        Map<Integer, List<String>> map = new HashMap<>();

        List<String> l1 = new ArrayList<>();
        l1.add("1");
        l1.add("2");
        map.put(1, l1);
        List<String> l2 = new ArrayList<>();
        l2.add("4");
        l2.add("5");
        map.put(2, l2);
        Type type = new TypeToken<HashMap<Integer, List<String>>>() {}.getType();

        String str = "{\"1\":[\"1\",\"2\"],\"2\":[\"4\",\"5\"]}";

        Map<Integer, List<String>> map1 = new Gson().fromJson(str, type);

        Map<Integer, Object> mapObj = new HashMap<>();
        Type type2 = new TypeToken<HashMap<Integer, Object>>() {}.getType();
        Map<Integer, Object> map2 = new Gson().fromJson(str, type2);
        System.out.println("==========");


    }
}
