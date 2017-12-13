package com.uzpeng.sign.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.qmuiteam.qmui.widget.QMUIEmptyView;
import com.uzpeng.sign.R;
import com.uzpeng.sign.entity.ActivityEntity;

import java.util.List;

/**
 * @author serverliu on 2017/12/12.
 */

public class ActivityFragment extends Fragment {

  private FragmentActivity mainActivity;
  private RecyclerView activitiesList;
  private QMUIEmptyView emptyView;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return LayoutInflater.from(getActivity()).inflate(R.layout.frag_activity, null);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    mainActivity = getActivity();
    initView(view);
  }

  private void initView(@NonNull View view){
    activitiesList = view.findViewById(R.id.activity);
    activitiesList.setLayoutManager(new LinearLayoutManager(mainActivity, LinearLayoutManager.VERTICAL, false));

    emptyView = view.findViewById(R.id.emptyView);
    emptyView.show(true);
  }

  public void initData(ActivityEntity entity){
    if(entity != null) {
      emptyView.show(false);
      activitiesList.setAdapter(new ActivitiesAdapter(entity));
      activitiesList.setVisibility(View.VISIBLE);
    } else {
      emptyView.show(false, "加载失败", null, "重试", null);
    }
  }

  private class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesViewHolder>{
    private List<ActivityEntity.ActivityItemEntity> list;

    ActivitiesAdapter(ActivityEntity entity){
      this.list = entity.getAct_list();
    }

    @Override
    public ActivitiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      return new ActivitiesViewHolder(LayoutInflater.from(mainActivity).inflate(R.layout.items_activity, parent));
    }

    @Override
    public void onBindViewHolder(ActivitiesViewHolder holder, int position) {
      holder.title.setText(list.get(position).getTitle());
      holder.date.setText(list.get(position).getDate());
      holder.loc.setText(list.get(position).getLoc());
      holder.content.setText(list.get(position).getContent());
    }

    @Override
    public int getItemCount() {
      return list.size();
    }
  }

  private class ActivitiesViewHolder extends RecyclerView.ViewHolder{
    private TextView title;
    private TextView date;
    private TextView loc;
    private TextView content;
    private Button sign;

    ActivitiesViewHolder(View itemView) {
      super(itemView);
      title = itemView.findViewById(R.id.act_name);
      date = itemView.findViewById(R.id.act_date);
      loc = itemView.findViewById(R.id.act_loc);
      content = itemView.findViewById(R.id.content);
      sign = itemView.findViewById(R.id.sign);
    }
  }
}
