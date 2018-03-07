/*=====================================================================
□ Infomation
  ○ Data : 07.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : Do it android app Programming

□ Function
  ○

□ Study
  ○
=====================================================================*/
package com.eun1310434.tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment1 extends Fragment {
    TextView tv;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);
        Log.e("onCreateView", "onCreateView()");
        if (savedInstanceState != null && savedInstanceState.get("data") != null) {
            // 이전에 저장한 데이터 사용
            tv.setText(savedInstanceState.getString("data"));

        }else{
            tv = (TextView)  rootView.findViewById(R.id.textview);
            button = (Button) rootView.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv.append("\nClick");
                }
            });
        }
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // 데이터 저장
        outState.putString("data", tv.getText().toString());
        Log.e("data", tv.getText().toString());
    }
}
