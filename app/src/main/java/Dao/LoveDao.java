package Dao;

import java.util.List;

import test.baway.com.nsg.BaseApplication;

/**
 * name:周振辉
 * 时间：2017/9/14 19:13
 * 类描述：
 */

public class LoveDao {
    /**
     * 添加数据，如果有重复则覆盖
     *
     * @param shop
     */
    public static void insertLove(User shop) {
        BaseApplication.getDaoInstant().getUserDao().insertOrReplace(shop);
    }
    /**
     * 删除数据
     *
     * @param id
     */
    public static void deleteLove(long id) {
        BaseApplication.getDaoInstant().getUserDao().deleteByKey(id);
    }

    /**
     * 更新数据
     *
     * @param shop
     */
    public static void updateLove(User shop) {
        BaseApplication.getDaoInstant().getUserDao().update(shop);
    }


    /**
     * 查询全部数据
     */
    public static List<User> queryAll() {
        return BaseApplication.getDaoInstant().getUserDao().loadAll();
    }
}
