package Dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * name:周振辉
 * 时间：2017/9/14 19:06
 * 类描述：
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String price;
    private String url;
    private int num;
    @Generated(hash = 1770367634)
    public User(Long id, String name, String price, String url, int num) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.url = url;
        this.num = num;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getNum() {
        return this.num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    
}
