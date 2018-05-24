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
    String data;


    //인터페이스를 활용하여 리스너 새로 정의
    //innerClass
    public interface OnDataListener {
        void OnDataListener(String data);
    }

    //리스너 객체
    private OnDataListener listener; //

    public void setOnDataListener(OnDataListener onDataListener){
        // 해당 클래스를 활용하는 곳에서 setOnDateTimeChangedListener를 선언시
        // OnDateTimeChangedListener 생성
        this.listener = onDataListener;
    }

    public void setData(String data){
        if(data == null){
            this.data = "Fragment 1";
        }else{
            this.data = data;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);
        Log.e("onCreateView", "onCreateView()");
        tv = (TextView)  rootView.findViewById(R.id.textview);
        tv.setText(data);
        button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.append("\nClick");
            }
        });
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("onStart", "onStart()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("onPause", "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("onStop", "onStop()");
        listener.OnDataListener(tv.getText().toString());
    }
}
