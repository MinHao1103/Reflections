package com.cache.api.service;

import com.cache.api.dto.IPlugin;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;

public class PluginMain {

    public static void main(String[] args) {
        Reflections reflections = new Reflections();

        // 使用 Reflections 的 getSubTypesOf() 方法來找到所有實作 IPlugin 類別
        List<Class<? extends IPlugin>> classes = new ArrayList<Class<? extends IPlugin>>(reflections.getSubTypesOf(IPlugin.class));

        for (Class<? extends IPlugin> c : classes) {
            try {
                // 將找到的類創建實例，並且印出類別的名稱
                IPlugin instance = c.newInstance();
                System.out.println(instance.getClass().getName());
            } catch (Exception e) {
            }
        }

    }

}