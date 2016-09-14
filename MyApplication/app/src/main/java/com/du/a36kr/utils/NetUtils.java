package com.du.a36kr.utils;

/**
 * Created by dllo on 16/9/12.
 * 网址静态类
 */
public class NetUtils {
    /**
     * 新闻界面
     */
    //轮播图
    public final static String ROTATE_IMAGE = "https://rong.36kr.com/api/mobi/roundpics/v4";
    //全部
    public final static String NEWS_ALL = "https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=all&pagingAction=up";
    //早期项目
    public final static String NEWS_EARLY = "https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=67&pagingAction=up";
    //B轮后
    public final static String NEWS_ROTATE = "https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=68&pagingAction=up";
    //大公司
    public final static String NEWS_COMPANY = "https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=23&pagingAction=up";
    //资本
    public final static String NEWS_CAPITAL = "https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=69&pagingAction=up";
    //深度
    public final static String NewS_DEPTH = " https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=70&pagingAction=up";
    //研究
    public final static String NEWS_RESEARCH = "https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=71&pagingAction=up";
    //氪Tv
    public final static String NEWS_TV = "https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=tv&pagingAction=up";
    //详情
    public final static String NEWS_DETAILS = "https://rong.36kr.com/api/mobi/news/5041796";
    //作者
    public final static String NEWS_AUTHOR = " https://rong.36kr.com/api/mobi/news/5041796/author-region";
    /**
     * 股权投资界面接口
     */
    //全部
    public final static String EQUITY_ALL = "https://rong.36kr.com/api/mobi/cf/actions/list?page=1&type=all&pageSize=20";
    //募资中
    public final static String EQUITY_PROCEED = "https://rong.36kr.com/api/mobi/cf/actions/list?page=1&type=underway&pageSize=20";
    //募资完成
    public final static String EQUITY_ACHIEVEMENT = "https://rong.36kr.com/api/mobi/cf/actions/list?page=1&type=raise&pageSize=20";
    //融资成功
    public final static String EQUITY_SUCCESS = "https://rong.36kr.com/api/mobi/cf/actions/list?page=1&type=finish&pageSize=20";
    /**
     * 发现界面接口
     *
     * 近期活动
     */
    //全部
    public final static String DISCOVERY_ALL = "https://rong.36kr.com/api/mobi/activity/list?page=1";
    //Demo Day
    public final static String DISCOVERY_DAY = "https://rong.36kr.com/api/mobi/activity/list?page=1&categoryId=1&pageSize=20";
    //氪空间
    public final static String DISCOVERY_SPACE = "https://rong.36kr.com/api/mobi/activity/list?page=1&categoryId=4&pageSize=20";
    //股权投资
    public final static String DISCOVERY_EQUITY = "https://rong.36kr.com/api/mobi/activity/list?page=1&categoryId=5&pageSize=20";
    //企业服务
    public final static String DISCOVERY_EMPLOYERS = "https://rong.36kr.com/api/mobi/activity/list?page=1&categoryId=6&pageSize=20";
    //极速融资
    public final static String DISCOVERY_FINANCING = "https://rong.36kr.com/api/mobi/activity/list?page=1&categoryId=7&pageSize=20";
    //寻找投资人
    public final static String DISCOVERY_INVESTORS = "https://rong.36kr.com/api/mobi/investor?page=1&pageSize=20";

}
