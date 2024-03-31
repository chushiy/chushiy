package com.chushiy;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/2/14 上午 1:03
 * @Description TODO
 * @ProjectName chushiy
 * @PackageName com.chushiy
 * @ClassName GirlFriendMain.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class GirlFriendMain {

    public static void main(String[] args) {
        GirlFriend girlFriend = new GirlFriend("范冰冰", '女', 19, 168, 90, "肤白貌美大长腿");
        girlFriend.setBoyFriend("yu Qiao");
        girlFriend.kiss();
    }
}
