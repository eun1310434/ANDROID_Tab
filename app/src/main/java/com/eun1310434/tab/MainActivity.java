/*=====================================================================
□ Infomation
  ○ Data : 21.05.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : Do it android app Programming

□ Function
  ○ Listenr를 활용한 데이터 저장

□ Study
  ○
=====================================================================*/

package com.eun1310434.tab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    Fragment1 fragment1;
    String fragment1_data = null;

    Fragment2 fragment2;
    String fragment2_data = null;

    Fragment3 fragment3;
    String fragment3_data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // activity_main에서 만든 toolbar를 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false); //ActionBar의 이름을 갖고 오지 않는다.

        fragment1 = new Fragment1();
        fragment1.setOnDataListener(new Fragment1.OnDataListener() {
            @Override
            public void OnDataListener(String data) {
                fragment1_data = data ;
            }
        });

        fragment2 = new Fragment2();
        fragment2.setOnDataListener(new Fragment2.OnDataListener() {
            @Override
            public void OnDataListener(String data) {
                fragment2_data = data ;
            }
        });

        fragment3 = new Fragment3();
        fragment3.setOnDataListener(new Fragment3.OnDataListener() {
            @Override
            public void OnDataListener(String data) {
                fragment3_data = data;
            }
        });

        getSupportFragmentManager().beginTransaction().addToBackStack(null).add(R.id.container, fragment1).commit();
        fragment1.setData(fragment1_data);


        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("Fragment1"));
        tabs.addTab(tabs.newTab().setText("Fragment2"));
        tabs.addTab(tabs.newTab().setText("Fragment3"));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                setFragment(position);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }

    public void setFragment(int position){
        Fragment selected = null;
        if (position == 0) {
            selected = fragment1;
            fragment1.setData(fragment1_data);
        } else if (position == 1) {
            selected = fragment2;
            fragment2.setData(fragment2_data);
        } else if (position == 2) {
            selected = fragment3;
            fragment3.setData(fragment3_data);
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).addToBackStack(null).commit();

    }
}
