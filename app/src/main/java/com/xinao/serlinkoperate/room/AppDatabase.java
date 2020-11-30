package com.xinao.serlinkoperate.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.xinao.serlinkoperate.room.dao.UserInfoDao;
import com.xinao.serlinkoperate.room.entity.UserInfo;

@Database(entities = {UserInfo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserInfoDao userDao();

}
