package com.xinao.serlinkoperate.room;

import android.content.Context;

import androidx.room.Room;

import com.xinao.serlinkoperate.room.dao.UserInfoDao;

public class RoomManager {
    private static RoomManager instance;
    private static AppDatabase db;

    public static RoomManager getInstance(Context context) {
        if(instance == null) {
            instance = new RoomManager();
            db = Room.databaseBuilder(context,
                    AppDatabase.class, "database-emp")
//                    .addMigrations(MIGRATION_1_2)
                    .build();
        }
        return instance;
    }

    public UserInfoDao getUserDao(){
        return db.userDao();
    }


//    /**
//     * 数据库版本 2->3 新增book表格
//     */
//    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
//        @Override
//        public void migrate(SupportSQLiteDatabase database) {
//            database.execSQL(
//                    "CREATE TABLE IF NOT EXISTS `history` (`hisName` TEXT PRIMARY KEY , `userId` INTEGER, 'hisType' INTEGER)");
//        }
//    };

}
