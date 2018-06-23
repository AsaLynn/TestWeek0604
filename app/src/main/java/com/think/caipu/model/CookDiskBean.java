package com.think.caipu.model;

import java.util.List;

/**
 * Created by think on 2018/1/14.
 */

public class CookDiskBean {

    @Override
    public String toString() {
        return "CookDiskBean{" +
                "data=" + data +
                ", res=" + res +
                ", append=" + append +
                '}';
    }

    /**
     * append : []
     * data : {"dishs":[{"allClick":"1.6万","burdens":"腐皮,猪肉末,黑木耳,姜,盐,淀粉,料酒,生抽,老冰糖,蚝油","code":99683537,"customers":{"code":10367388791,"img":"https://s3.cdn.xiangha.com/i/201801/0412/5a4db066d3f6f.jpg/MTUweDE1MA.webp","isGourmet":"2","nickName":"普木"},"dishAddTime":"5天前","exclusive":1,"favorites":"951","hasVideo":"2","img":"https://s3.cdn.xiangha.com/caipu/201801/0819/081907017645.jpg/MjgweDIyMA.webp","isFine":2,"isMakeImg":1,"isVip":1,"judgeId":0,"level":3,"name":"腐皮金卷"},{"allClick":"7824","burdens":"羊肉,葱,姜,料酒,生抽,老抽,盐,冰糖,八角,香叶,开水","code":99692292,"customers":{"code":37472270350,"img":"https://s3.cdn.xiangha.com/i/201801/1122/5a57745228cec.jpg/MTUweDE1MA.webp","isGourmet":"2","nickName":"橘子香味"},"dishAddTime":"4天前","exclusive":1,"favorites":"619","hasVideo":"2","img":"https://s1.cdn.xiangha.com/caipu/201801/1018/101859541903.jpeg/MjgweDIyMA.webp","isFine":2,"isMakeImg":1,"isVip":1,"judgeId":0,"level":3,"name":"喜气洋洋"},{"allClick":"9747","burdens":"大虾,土豆,油,沙拉酱,面粉,淀粉,泡打粉,鸡蛋,葱姜,料酒","code":99695078,"customers":{"code":18947488081,"img":"https://s3.cdn.xiangha.com/i/201604/2001/57166e0b607b9.jpg/MTUweDE1MA.webp","isGourmet":"2","nickName":"浤辰"},"dishAddTime":"4天前","exclusive":1,"favorites":"796","hasVideo":"2","img":"https://s3.cdn.xiangha.com/caipu/201801/0923/092356194014.jpg/MjgweDIyMA.webp","isFine":2,"isMakeImg":1,"isVip":1,"judgeId":0,"level":3,"name":"金丝虾球"},{"allClick":"5730","burdens":"苦瓜,梅汁,盐,油","code":99695227,"customers":{"code":6687315687,"img":"https://s1.cdn.xiangha.com/i/201801/0520/5a4f702d24f0a.jpg/MTUweDE1MA.webp","isGourmet":"2","nickName":"糯米baby"},"dishAddTime":"4天前","exclusive":1,"favorites":"771","hasVideo":"2","img":"https://s3.cdn.xiangha.com/caipu/201801/1000/100041397491.jpg/MjgweDIyMA.webp","isFine":2,"isMakeImg":1,"isVip":1,"judgeId":0,"level":3,"name":"梅汁苦瓜"},{"allClick":"6896","burdens":"荷兰豆,玉米笋,胡萝卜,蟹味菇,油,盐,蚝油,水淀粉,高汤","code":99702478,"customers":{"code":18947488081,"img":"https://s3.cdn.xiangha.com/i/201604/2001/57166e0b607b9.jpg/MTUweDE1MA.webp","isGourmet":"2","nickName":"浤辰"},"dishAddTime":"3天前","exclusive":1,"favorites":"647","hasVideo":"2","img":"https://s3.cdn.xiangha.com/caipu/201801/1021/102158284133.jpg/MjgweDIyMA.webp","isFine":2,"isMakeImg":1,"isVip":1,"judgeId":0,"level":3,"name":"四喜鲜蔬"},{"allClick":"3228","burdens":"银鱼干,大蒜叶,姜丝,大蒜,红辣椒,白糖,鸡精,料酒","code":99657938,"customers":{"code":57893731797,"img":"https://s3.cdn.xiangha.com/i/201703/3002/58dbfddf1a89e.jpg/MTUweDE1MA.webp","isGourmet":"2","nickName":"慧慧家有乖宝宝"},"dishAddTime":"8天前","exclusive":1,"favorites":"489","hasVideo":"2","img":"https://s1.cdn.xiangha.com/caipu/201801/0520/052006586313.jpg/MjgweDIyMA.webp","isFine":1,"isMakeImg":1,"isVip":1,"judgeId":0,"level":1,"name":"香辣银鱼干"},{"allClick":"3979","burdens":"猪脆骨,青椒,红椒,姜末,蒜末,葱末,料酒,生抽,盐,胡椒粉,味精","code":99659685,"customers":{"code":81787724311,"img":"https://s1.cdn.xiangha.com/i/201710/1009/59dc242c76c73.jpg/MTUweDE1MA.webp","isGourmet":"2","nickName":"林乡"},"dishAddTime":"8天前","exclusive":1,"favorites":"601","hasVideo":"2","img":"https://s3.cdn.xiangha.com/caipu/201801/0608/060803567876.jpg/MjgweDIyMA.webp","isFine":1,"isMakeImg":1,"isVip":1,"judgeId":0,"level":1,"name":"双椒爆猪脆骨"},{"allClick":"5307","burdens":"鸭肉,水发腐竹,大葱段,姜末,蒜末,卤料,花椒,干红辣椒碎,酱油,豆瓣酱,盐,胡椒粉,味精,啤酒","code":99660785,"customers":{"code":81787724311,"img":"https://s3.cdn.xiangha.com/i/201710/1009/59dc242c76c73.jpg/MTUweDE1MA.webp","isGourmet":"2","nickName":"林乡"},"dishAddTime":"8天前","exclusive":1,"favorites":"784","hasVideo":"2","img":"https://s1.cdn.xiangha.com/caipu/201801/0611/061143346626.jpg/MjgweDIyMA.webp","isFine":1,"isMakeImg":1,"isVip":1,"judgeId":0,"level":1,"name":"腐竹烧鸭"},{"allClick":"5786","burdens":"山药,紫薯,白糖,绿茶粉","code":99661381,"customers":{"code":74485978479,"img":"https://s1.cdn.xiangha.com/i/201801/1200/5a5795267496c.jpg/MTUweDE1MA.webp","isGourmet":"2","nickName":"苹果树的花"},"dishAddTime":"8天前","exclusive":1,"favorites":"847","hasVideo":"2","img":"https://s1.cdn.xiangha.com/caipu/201801/0613/061310123619.jpg/MjgweDIyMA.webp","isFine":1,"isMakeImg":1,"isVip":1,"judgeId":0,"level":1,"name":"三色山药"},{"allClick":"3943","burdens":"猪肉馅,油,甜面酱,酱油,料酒,葱,姜,盐,味精,淀粉,胡萝卜,木耳,花椒粉,醋,糖,面包糠","code":99661707,"customers":{"code":63651231331,"img":"https://s1.cdn.xiangha.com/i/201706/2923/59551d50d5948.jpg/MTUweDE1MA.webp","isGourmet":"2","nickName":"筱筱德"},"dishAddTime":"8天前","exclusive":1,"favorites":"596","hasVideo":"2","img":"https://s3.cdn.xiangha.com/caipu/201801/0613/061355402781.jpg/MjgweDIyMA.webp","isFine":1,"isMakeImg":1,"isVip":1,"judgeId":0,"level":1,"name":"焦溜丸子"}],"soCi":["家常菜","家常","家","常","菜"]}
     * power : {}
     * res : 2
     */

    private DataBean data;
    private int res;
    private java.util.List<?> append;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "dishs=" + dishs +
                    ", soCi=" + soCi +
                    '}';
        }

        private java.util.List<DishsBean> dishs;
        private java.util.List<String> soCi;

        public List<DishsBean> getDishs() {
            return dishs;
        }

        public void setDishs(List<DishsBean> dishs) {
            this.dishs = dishs;
        }

        public List<String> getSoCi() {
            return soCi;
        }

        public void setSoCi(List<String> soCi) {
            this.soCi = soCi;
        }

        public static class DishsBean {

            @Override
            public String toString() {
                return "DishsBean{" +
                        "allClick='" + allClick + '\'' +
                        ", burdens='" + burdens + '\'' +
                        ", code=" + code +
                        ", customers=" + customers +
                        ", dishAddTime='" + dishAddTime + '\'' +
                        ", exclusive=" + exclusive +
                        ", favorites='" + favorites + '\'' +
                        ", hasVideo='" + hasVideo + '\'' +
                        ", img='" + img + '\'' +
                        ", isFine=" + isFine +
                        ", isMakeImg=" + isMakeImg +
                        ", isVip=" + isVip +
                        ", judgeId=" + judgeId +
                        ", level=" + level +
                        ", name='" + name + '\'' +
                        '}';
            }

            /**
             * allClick : 1.6万
             * burdens : 腐皮,猪肉末,黑木耳,姜,盐,淀粉,料酒,生抽,老冰糖,蚝油
             * code : 99683537
             * customers : {"code":10367388791,"img":"https://s3.cdn.xiangha.com/i/201801/0412/5a4db066d3f6f.jpg/MTUweDE1MA.webp","isGourmet":"2","nickName":"普木"}
             * dishAddTime : 5天前
             * exclusive : 1
             * favorites : 951
             * hasVideo : 2
             * img : https://s3.cdn.xiangha.com/caipu/201801/0819/081907017645.jpg/MjgweDIyMA.webp
             * isFine : 2
             * isMakeImg : 1
             * isVip : 1
             * judgeId : 0
             * level : 3
             * name : 腐皮金卷
             */

            private String allClick;
            private String burdens;
            private int code;
            private CustomersBean customers;
            private String dishAddTime;
            private int exclusive;
            private String favorites;
            private String hasVideo;
            private String img;
            private int isFine;
            private int isMakeImg;
            private int isVip;
            private int judgeId;
            private int level;
            private String name;

            public String getAllClick() {
                return allClick;
            }

            public void setAllClick(String allClick) {
                this.allClick = allClick;
            }

            public String getBurdens() {
                return burdens;
            }

            public void setBurdens(String burdens) {
                this.burdens = burdens;
            }

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public CustomersBean getCustomers() {
                return customers;
            }

            public void setCustomers(CustomersBean customers) {
                this.customers = customers;
            }

            public String getDishAddTime() {
                return dishAddTime;
            }

            public void setDishAddTime(String dishAddTime) {
                this.dishAddTime = dishAddTime;
            }

            public int getExclusive() {
                return exclusive;
            }

            public void setExclusive(int exclusive) {
                this.exclusive = exclusive;
            }

            public String getFavorites() {
                return favorites;
            }

            public void setFavorites(String favorites) {
                this.favorites = favorites;
            }

            public String getHasVideo() {
                return hasVideo;
            }

            public void setHasVideo(String hasVideo) {
                this.hasVideo = hasVideo;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getIsFine() {
                return isFine;
            }

            public void setIsFine(int isFine) {
                this.isFine = isFine;
            }

            public int getIsMakeImg() {
                return isMakeImg;
            }

            public void setIsMakeImg(int isMakeImg) {
                this.isMakeImg = isMakeImg;
            }

            public int getIsVip() {
                return isVip;
            }

            public void setIsVip(int isVip) {
                this.isVip = isVip;
            }

            public int getJudgeId() {
                return judgeId;
            }

            public void setJudgeId(int judgeId) {
                this.judgeId = judgeId;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public static class CustomersBean {

                @Override
                public String toString() {
                    return "CustomersBean{" +
                            "code=" + code +
                            ", img='" + img + '\'' +
                            ", isGourmet='" + isGourmet + '\'' +
                            ", nickName='" + nickName + '\'' +
                            '}';
                }

                /**
                 * code : 10367388791
                 * img : https://s3.cdn.xiangha.com/i/201801/0412/5a4db066d3f6f.jpg/MTUweDE1MA.webp
                 * isGourmet : 2
                 * nickName : 普木
                 */

                private long code;
                private String img;
                private String isGourmet;
                private String nickName;

                public long getCode() {
                    return code;
                }

                public void setCode(long code) {
                    this.code = code;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getIsGourmet() {
                    return isGourmet;
                }

                public void setIsGourmet(String isGourmet) {
                    this.isGourmet = isGourmet;
                }

                public String getNickName() {
                    return nickName;
                }

                public void setNickName(String nickName) {
                    this.nickName = nickName;
                }
            }
        }
    }
}
