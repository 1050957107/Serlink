package com.xinao.serlinkoperate.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.xinao.serlinkoperate.room.entity.UserInfo;

import java.util.List;

@Dao
public interface UserInfoDao {

    @Query("SELECT * FROM user_info")
    List<UserInfo> getAll();

    /**
     * 查询登录成功的用户
     * @param loginstate 登录状态
     * @return
     */
    @Query("SELECT * FROM user_info WHERE loginstate IN (:loginstate)")
    UserInfo findLoginSuccess(int loginstate);


    @Query("SELECT * FROM user_info WHERE phone LIKE :phone LIMIT 1")
    UserInfo findByPhone(String phone);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(UserInfo... users);

    @Delete
    void delete(UserInfo... user);

    @Update
    void update(UserInfo... users);
}
