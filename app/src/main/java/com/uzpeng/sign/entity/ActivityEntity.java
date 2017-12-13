package com.uzpeng.sign.entity;

import java.util.List;

/**
 * @author serverliu on 2017/12/13.
 */

public class ActivityEntity {
  /**
   * status : ok
   * last_modify : 1354874658
   * act_list : [{"title":"离散数学","loc":"教学楼A201","date":"2017年11月12日 下午两点","content":"上课","isAct":true,"isDDL":false},{"title":"离散数学","loc":"教学楼A201","date":"2017年11月12日 下午两点","content":"上课","isAct":true,"isDDL":false}]
   */

  private String status;
  private int last_modify;
  private List<ActivityItemEntity> act_list;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getLast_modify() {
    return last_modify;
  }

  public void setLast_modify(int last_modify) {
    this.last_modify = last_modify;
  }

  public List<ActivityItemEntity> getAct_list() {
    return act_list;
  }

  public void setAct_list(List<ActivityItemEntity> act_list) {
    this.act_list = act_list;
  }

  public static class ActivityItemEntity {
    /**
     * title : 离散数学
     * loc : 教学楼A201
     * date : 2017年11月12日 下午两点
     * content : 上课
     * isAct : true
     * isDDL : false
     */

    private String title;
    private String loc;
    private String date;
    private String content;
    private boolean isAct;
    private boolean isDDL;

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public String getLoc() {
      return loc;
    }

    public void setLoc(String loc) {
      this.loc = loc;
    }

    public String getDate() {
      return date;
    }

    public void setDate(String date) {
      this.date = date;
    }

    public String getContent() {
      return content;
    }

    public void setContent(String content) {
      this.content = content;
    }

    public boolean isIsAct() {
      return isAct;
    }

    public void setIsAct(boolean isAct) {
      this.isAct = isAct;
    }

    public boolean isIsDDL() {
      return isDDL;
    }

    public void setIsDDL(boolean isDDL) {
      this.isDDL = isDDL;
    }
  }
}
