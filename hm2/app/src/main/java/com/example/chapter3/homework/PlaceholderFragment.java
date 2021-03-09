package com.example.chapter3.homework;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {
    private View tv;
    private ImageView mImage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation loadAnimation;
                mImage=getView().findViewById(R.id.animation_view);
                loadAnimation = AnimationUtils.loadAnimation(getView().getContext(), R.anim.fade_out);
                mImage.startAnimation(loadAnimation);
                mImage.setAlpha(0);
                Animation loadAnimation1;
                tv=getView().findViewById(R.id.textView2);
                tv.setAlpha(1);
                loadAnimation1 = AnimationUtils.loadAnimation(getView().getContext(), R.anim.fade_in);
                tv.startAnimation(loadAnimation1);
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
            }
        }, 5000);
    }
}
