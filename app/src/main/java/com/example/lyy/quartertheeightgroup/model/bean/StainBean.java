package com.example.lyy.quartertheeightgroup.model.bean;

import java.util.List;

/**
 * Created by LYY on 2018/1/25.
 */

public class StainBean {

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"dsfsdfsdf","createTime":"2018-01-25T18:33:18","imgUrls":null,"jid":1159,"praiseNum":null,"shareNum":null,"uid":2825,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"淘宝","praiseNum":"null"}},{"commentNum":null,"content":"不会喝酒不看好不好看","createTime":"2018-01-25T16:50:54","imgUrls":null,"jid":1158,"praiseNum":null,"shareNum":null,"uid":3526,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"任飞！","createTime":"2018-01-25T15:13:02","imgUrls":null,"jid":1157,"praiseNum":null,"shareNum":null,"uid":3526,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"好吧","createTime":"2018-01-25T15:02:24","imgUrls":null,"jid":1156,"praiseNum":null,"shareNum":null,"uid":1758,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1516841991537timg.jpg","nickname":"熊猫","praiseNum":"null"}},{"commentNum":null,"content":"哈哈哈哈","createTime":"2018-01-25T14:58:07","imgUrls":null,"jid":1155,"praiseNum":null,"shareNum":null,"uid":4814,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"叫我飞哥好吗!","praiseNum":"null"}},{"commentNum":null,"content":"'qwe'","createTime":"2018-01-25T14:49:53","imgUrls":null,"jid":1154,"praiseNum":null,"shareNum":null,"uid":3526,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"asd","createTime":"2018-01-25T14:47:37","imgUrls":null,"jid":1153,"praiseNum":null,"shareNum":null,"uid":1497,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15160825477571516082546650.png","nickname":"哈哈","praiseNum":"null"}},{"commentNum":null,"content":"你好世界你好世界","createTime":"2018-01-25T14:31:43","imgUrls":null,"jid":1152,"praiseNum":null,"shareNum":null,"uid":1701,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":", ","createTime":"2018-01-25T14:09:49","imgUrls":null,"jid":1151,"praiseNum":null,"shareNum":null,"uid":4212,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":", ","createTime":"2018-01-25T14:08:17","imgUrls":null,"jid":1150,"praiseNum":null,"shareNum":null,"uid":4212,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}}]
     */

    public String msg;
    public String code;
    public List<DataEntity> data;

    public static class DataEntity {
        /**
         * commentNum : null
         * content : dsfsdfsdf
         * createTime : 2018-01-25T18:33:18
         * imgUrls : null
         * jid : 1159
         * praiseNum : null
         * shareNum : null
         * uid : 2825
         * user : {"age":null,"fans":"null","follow":false,"icon":null,"nickname":"淘宝","praiseNum":"null"}
         */

        public Object commentNum;
        public String content;
        public String createTime;
        public Object imgUrls;
        public int jid;
        public Object praiseNum;
        public Object shareNum;
        public int uid;
        public UserEntity user;

        public static class UserEntity {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : null
             * nickname : 淘宝
             * praiseNum : null
             */

            public Object age;
            public String fans;
            public boolean follow;
            public Object icon;
            public String nickname;
            public String praiseNum;
        }
    }
}
