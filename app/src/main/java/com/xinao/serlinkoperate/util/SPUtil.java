package com.xinao.serlinkoperate.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtil {
    private static final String TAG = SPUtil.class.getName();
    private String configName;
    private SharedPreferences instance;

    public SPUtil(String configName, Context mContext) {
        instance = mContext.getSharedPreferences(configName, Context.MODE_PRIVATE);
        this.configName = configName;
    }

    public String getConfigName() {
        return configName;
    }

    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return instance.getBoolean(key, defValue);
    }

    public void setBoolean(String key, boolean value) {
        instance.edit().putBoolean(key, value).apply();
    }

    public int getInt(String key) {
        return getInt(key, -1);
    }

    public int getInt(String key, int defValue) {
        return instance.getInt(key, defValue);
    }

    public void setInt(String key, int value) {
        instance.edit().putInt(key, value).apply();
    }

    public float getFloat(String key) {
        return getFloat(key, -1f);
    }

    public float getFloat(String key, float defValue) {
        return instance.getFloat(key, defValue);
    }

    public void setFloat(String key, float value) {
        instance.edit().putFloat(key, value).apply();
    }

    public long getLong(String key) {
        return getLong(key, -1L);
    }

    public long getLong(String key, long defValue) {
        return instance.getLong(key, defValue);
    }

    public void setLong(String key, long value) {
        instance.edit().putLong(key, value).apply();
    }

    public String getString(String key) {
        return getString(key, null);
    }

    public String getString(String key, String defValue) {
        return instance.getString(key, defValue);
    }

    public void setString(String key, String value) {
        if (instance.contains(key)) {
            instance.edit().remove(key);
        }
        instance.edit().putString(key, value).apply();
    }

    public boolean contains(String key) {
        return instance.contains(key);
    }

    public void removeKey(String... keys) {
        for (String key : keys) {
            if (key != null) {
                LoggerUtils.e(TAG, "key:" + key);
                instance.edit().remove(key).commit();
            }
        }
    }

    public void clear() {
        instance.edit().clear().apply();
    }
}
