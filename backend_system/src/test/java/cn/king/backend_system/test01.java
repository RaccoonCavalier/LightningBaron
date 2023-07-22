package cn.king.backend_system;

import cn.king.backend_system.util.RandomStringGenerator;

import java.util.HashSet;
import java.util.Set;

public class test01 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set.add("5");

        System.out.println(set.size() + "个");
        for( String s : set){
            System.out.println(s);
        }
    }
}
