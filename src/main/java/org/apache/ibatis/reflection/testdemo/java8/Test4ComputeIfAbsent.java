package org.apache.ibatis.reflection.testdemo.java8;

import java.lang.reflect.Method;
import java.util.*;

/**
 * 如果已经存在的不会覆盖，不存在的会覆盖
 */
public class Test4ComputeIfAbsent {

    public static void main(String[] args) {
        // 创建一个 HashMap
        HashMap<String, Integer> prices = new HashMap<>();

        // 往HashMap中添加映射项
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // 计算 Shirt 的值
        int shirtPrice = prices.computeIfAbsent("Shirt", key -> 280);
        System.out.println("Price of Shirt: " + shirtPrice);

        // 输出更新后的HashMap
        System.out.println("Updated HashMap: " + prices);

        test4List();
        test4Set();
    }

    /**
     * 已经存在的不会覆盖
     */
    private static void testAlreadyExit(){
        // 创建一个 HashMap
        HashMap<String, Integer> prices = new HashMap<>();

        // 往HashMap中添加映射关系
        prices.put("Shoes", 180);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // Shoes中的映射关系已经存在
        // Shoes并没有计算新值
        int shoePrice = prices.computeIfAbsent("Shoes", (key) -> 280);
        System.out.println("Price of Shoes: " + shoePrice);

        // 输出更新后的 HashMap
        System.out.println("Updated HashMap: " + prices);
    }


    private static void test4List(){
        String name = "test1";
        Map<String,List<String>> testList = new HashMap<>();
        List<String> originList = new ArrayList<>();
        originList.add("abc");
        testList.put(name,originList);
        List<String> list = testList.computeIfAbsent(name, k -> new ArrayList<>());
        list.add("abc");
        list.add("abc1");
        list.add("abc2");
        System.out.println(testList);
        //result = {test1=[abc, abc, abc1, abc2]}
    }

    private static void test4Set(){
        String name = "test1";
        Map<String, Set<String>> testList = new HashMap<>();
        Set<String> originList = new HashSet<>();
        originList.add("abc");
        testList.put(name,originList);
        Set<String> list = testList.computeIfAbsent(name, k -> new HashSet<>());
        list.add("abc");
        list.add("abc1");
        list.add("abc2");
        System.out.println(testList);
        //result = {test1=[abc1, abc, abc2]}
    }



}
