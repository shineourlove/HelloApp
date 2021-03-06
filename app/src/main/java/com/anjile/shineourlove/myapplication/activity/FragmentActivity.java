package com.anjile.shineourlove.myapplication.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.anjile.shineourlove.myapplication.R;
import com.anjile.shineourlove.myapplication.fragment.FragmentFish;
import com.anjile.shineourlove.myapplication.fragment.FragmentFour;
import com.anjile.shineourlove.myapplication.fragment.FragmentOne;
import com.anjile.shineourlove.myapplication.fragment.FragmentThree;
import com.anjile.shineourlove.myapplication.fragment.FragmentTwo;
import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class FragmentActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar mBottomNavigationBar;
    private FragmentOne mFragmentOne;
    private FragmentTwo mFragmentTwo;
    private FragmentThree mFragmentThree;
    private FragmentFour mFragmentFour;
    private FragmentFish fragmentFish;
    private BadgeItem badgeItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragement);
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        /**
         * 设置底部item的提示泡泡
         */
        badgeItem = new BadgeItem();
        badgeItem.setHideOnSelect(false)
                .setText("10")
                .setBackgroundColorResource(R.color.orange)
                .setBorderWidth(0);

        mBottomNavigationBar.setMode(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);//设置底部导航按钮的模式
        mBottomNavigationBar.setBarBackgroundColor(R.color.blue);//set background color for navigation bar
        mBottomNavigationBar.setInActiveColor(R.color.white);//unSelected icon color
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.icon_one, R.string.tab_one).setActiveColorResource(R.color.green).setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.drawable.icon_two, R.string.tab_two).setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.icon_three, R.string.tab_three).setActiveColorResource(R.color.lime))
                .addItem(new BottomNavigationItem(R.drawable.icon_four, R.string.tab_four).setActiveColorResource(R.color.glass_green))
                .setFirstSelectedPosition(0)
                .initialise();
        mBottomNavigationBar.setTabSelectedListener(FragmentActivity.this);
        setDefaultFragment();
    }

    /**
     * 设置加载默认的碎片
     */
    private void setDefaultFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragmentFish == null)
            fragmentFish = new FragmentFish();
        transaction.replace(R.id.ll_content, fragmentFish).commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                if (fragmentFish == null)
                    fragmentFish = new FragmentFish();
                transaction.replace(R.id.ll_content, fragmentFish);
                badgeItem.hide();//隐藏右上角的提示
                break;
            case 1:
                if (mFragmentTwo == null) {
                    mFragmentTwo = FragmentTwo.newInstance("Second Fragment");
                }
                transaction.replace(R.id.ll_content, mFragmentTwo);
                badgeItem.setText("新消息");
                badgeItem.show();//显示右上角的提示
                break;
            case 2:
                if (mFragmentThree == null) {
                    mFragmentThree = FragmentThree.newInstance("Third Fragment");
                }
                transaction.replace(R.id.ll_content, mFragmentThree);
                break;
            case 3:
                if (mFragmentFour == null) {
                    mFragmentFour = FragmentFour.newInstance("Forth Fragment");
                }
                transaction.replace(R.id.ll_content, mFragmentFour);
                break;
            default:
                if (fragmentFish == null)
                    fragmentFish = new FragmentFish();
                transaction.replace(R.id.ll_content, fragmentFish);
                break;
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
