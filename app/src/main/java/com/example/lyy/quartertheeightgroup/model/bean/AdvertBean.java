package com.example.lyy.quartertheeightgroup.model.bean;

import java.util.List;

/**
 * Created by LYY on 2018/1/24.
 */

public class AdvertBean {


    /**
     * msg :
     * code : 0
     * data : [{"aid":1,"createtime":"2017-12-26T21:49:44","icon":"https://www.zhaoapi.cn/images/quarter/ad1.png","productId":null,"title":"第十三界瑞丽模特大赛","type":0,"url":"http://m.mv14449315.icoc.bz/index.jsp"},{"aid":2,"createtime":"2017-12-26T21:49:44","icon":"https://www.zhaoapi.cn/images/quarter/ad2.png","productId":null,"title":"文化艺术节","type":0,"url":"http://m.mv14449315.icoc.bz/index.jsp"},{"aid":3,"createtime":"2017-12-26T21:49:44","icon":"https://www.zhaoapi.cn/images/quarter/ad3.png","productId":null,"title":"直播封面标准","type":0,"url":"http://m.mv14449315.icoc.bz/index.jsp"},{"aid":4,"createtime":"2017-12-26T21:49:44","icon":"https://www.zhaoapi.cn/images/quarter/ad4.png","productId":"1","title":"人气谁最高，金主谁最豪气","type":1,"url":""}]
     */

    public String msg;
    public String code;
    public List<DataEntity> data;

    public static class DataEntity {
        /**
         * aid : 1
         * createtime : 2017-12-26T21:49:44
         * icon : https://www.zhaoapi.cn/images/quarter/ad1.png
         * productId : null
         * title : 第十三界瑞丽模特大赛
         * type : 0
         * url : http://m.mv14449315.icoc.bz/index.jsp
         */

        public int aid;
        public String createtime;
        public String icon;
        public Object productId;
        public String title;
        public int type;
        public String url;
    }
}
