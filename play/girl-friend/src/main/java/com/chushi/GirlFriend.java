package com.chushi;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/2/14 上午 1:05
 * @Description TODO
 * @ProjectName chushi
 * @PackageName com.chushi
 * @ClassName GirlFriend.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class GirlFriend {

    private String name;
    private Character sex;
    private Integer age;
    private Integer height;
    private Integer weight;
    private String desc;
    private String boyFriend;

    public void setBoyFriend(String boyFriend) {
        this.boyFriend = boyFriend;
    }

    public GirlFriend(String name, Character sex, Integer age, Integer height, Integer weight, String desc) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.desc = desc;
    }

    public void kiss() {
        System.out.println(String.format("%s：么么哒", this.name));
    }
}
