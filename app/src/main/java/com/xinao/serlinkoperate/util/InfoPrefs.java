package com.xinao.serlinkoperate.util;

import android.content.Context;

public class InfoPrefs {
    private static SPUtil sp;

    public static void init(String configName, Context context) {
        if (sp == null || !sp.getConfigName().equals(configName)) {
            sp = new SPUtil(configName,context);
        }
    }

    public static void setData(String key, String value) {
        sp.setString(key, value);
    }

    public static void setIntData(String key, int value) {
        sp.setInt(key, value);
    }

    public static String getData(String key) {
        return sp.getString(key, "0");
    }

    public static int getIntData(String key) {
        return sp.getInt(key, 0);
    }

    public static boolean hasKey(String key) {
        return sp.contains(key);
    }

    public static void deleteData() {
        if (sp != null)
            sp.clear();
    }

    public static boolean contains(String key) {
        if (sp != null) {
            return sp.contains(key);
        }
        return false;
    }

    public static void removeKey(String... keys) {
        if (sp != null) {
            sp.removeKey(keys);
        }
    }
}
