# tabBar
tabBar android底部导航控件


<?xml version="1.0" encoding="utf-8"?>
<com.yaoshouyun.tabbar.TabBar xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/tabBar"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:defaultColor="#000000"
    app:defaultIcons="@array/defaultIcons"
    app:selectedColor="#ff0000"
    app:selectedIcons="@array/selectedIcons"
    app:tabNames="@array/tabNames">

</com.yaoshouyun.tabbar.TabBar>


    <string-array name="tabNames">
        <item>抢红包</item>
        <item>发红包</item>
        <item>我的红包</item>
        <item>个人中心</item>
    </string-array>

    <string-array name="defaultIcons">
        <item>@mipmap/radio_grab_n</item>
        <item>@mipmap/radio_give_n</item>
        <item>@mipmap/radio_my_n</item>
        <item>@mipmap/radio_mine_n</item>
    </string-array>

    <string-array name="selectedIcons">
        <item>@mipmap/radio_grab_p</item>
        <item>@mipmap/radio_give_p</item>
        <item>@mipmap/radio_my_p</item>
        <item>@mipmap/radio_mine_p</item>
    </string-array>
