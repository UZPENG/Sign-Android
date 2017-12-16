package com.uzpeng.sign.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.uzpeng.sign.R;
import com.uzpeng.sign.util.DrawableHelper;

import java.util.ArrayList;

/**
 * @author serverliu on 2017/12/15.
 */

public class CourseFragment extends Fragment {

  private Context context;
  private View title;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.frg_course, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    context = getContext();
    initView(view);
  }

  private void initView(View view){
    RecyclerView courseList = view.findViewById(R.id.course_list);
    courseList.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
    courseList.setAdapter(new CourseListAdapter());

    RecyclerView semesterList = view.findViewById(R.id.semester_list);
    semesterList.offsetTopAndBottom(QMUIDisplayHelper.dpToPx(70));

    title = view.findViewById(R.id.title_course);
    title.setOnClickListener((titleView) ->{
      semesterList.setAnimation(AnimationUtils.loadAnimation(context, R.anim.anim));
    });
  }

  private class CourseListAdapter extends RecyclerView.Adapter<CourseListViewHolder>{

    ArrayList<String> dataSet = new ArrayList<>();

    public CourseListAdapter() {
      for (int i = 0; i < 12; i++) {
        dataSet.add(""+i);
      }
    }

    @Override
    public CourseListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      return new CourseListViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.items_course_row, parent, false));
    }

    @Override
    public void onBindViewHolder(CourseListViewHolder holder, int position) {

      holder.item1.setText(position+1+"");

      holder.item2.setText(position+1+"");
      holder.item2.setTextColor(context.getResources().getColor(R.color.course_item));
      holder.item2.setBackgroundDrawable(DrawableHelper.getRectangleDrawable());

      holder.item3.setText(position+1+"");
      holder.item3.setTextColor(context.getResources().getColor(R.color.course_item));
      holder.item3.setBackgroundDrawable(DrawableHelper.getRectangleDrawable());

      holder.item4.setText(position+1+"");
      holder.item4.setTextColor(context.getResources().getColor(R.color.course_item));
      holder.item4.setBackgroundDrawable(DrawableHelper.getRectangleDrawable());

      holder.item5.setText(position+1+"");
      holder.item5.setTextColor(context.getResources().getColor(R.color.course_item));
      holder.item5.setBackgroundDrawable(DrawableHelper.getRectangleDrawable());

      holder.item6.setText(position+1+"");
      holder.item6.setTextColor(context.getResources().getColor(R.color.course_item));
      holder.item6.setBackgroundDrawable(DrawableHelper.getRectangleDrawable());

      holder.item7.setText(position+1+"");
      holder.item7.setTextColor(context.getResources().getColor(R.color.course_item));
      holder.item7.setBackgroundDrawable(DrawableHelper.getRectangleDrawable());

      holder.item8.setText(position+1+"");
      holder.item8.setTextColor(context.getResources().getColor(R.color.course_item));
      holder.item8.setBackgroundDrawable(DrawableHelper.getRectangleDrawable());
    }

    @Override
    public int getItemCount() {
      return dataSet.size();
    }
  }

  private class  CourseListViewHolder extends RecyclerView.ViewHolder{
    private TextView item1;
    private TextView item2;
    private TextView item3;
    private TextView item4;
    private TextView item5;
    private TextView item6;
    private TextView item7;
    private TextView item8;


    CourseListViewHolder(View itemView) {
      super(itemView);
      item1 = itemView.findViewById(R.id.item_1);
      item2 = itemView.findViewById(R.id.item_2);
      item3 = itemView.findViewById(R.id.item_3);
      item4 = itemView.findViewById(R.id.item_4);
      item5 = itemView.findViewById(R.id.item_5);
      item6 = itemView.findViewById(R.id.item_6);
      item7 = itemView.findViewById(R.id.item_7);
      item8 = itemView.findViewById(R.id.item_8);
    }
  }

}
