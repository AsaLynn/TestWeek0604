package com.think.caipu.model;

import java.util.List;

/**
 * Created by think on 2018/1/14.
 */

public class CookBookBean {

    @Override
    public String toString() {
        return "CookBookBean{" +
                "caipu=" + caipu +
                '}';
    }

    private List<CaipuBean> caipu;

    public List<CaipuBean> getCaipu() {
        return caipu;
    }

    public void setCaipu(List<CaipuBean> caipu) {
        this.caipu = caipu;
    }

    public static class CaipuBean {

        @Override
        public String toString() {
            return "CaipuBean{" +
                    "name='" + name + '\'' +
                    ", data=" + data +
                    '}';
        }

        /**
         * data : [{"name":"家常菜","url":"xiangha://welcome?so.app?type=caipu&s=%E5%AE%B6%E5%B8%B8%E8%8F%9C"},{"name":"家常","url":"xiangha://welcome?so.app?type=caipu&s=%E5%AE%B6%E5%B8%B8"},{"name":"早餐","url":"xiangha://welcome?so.app?type=caipu&s=%E6%97%A9%E9%A4%90"},{"name":"素菜","url":"xiangha://welcome?so.app?type=caipu&s=%E7%B4%A0%E8%8F%9C"},{"name":"川菜","url":"xiangha://welcome?so.app?type=caipu&s=%E5%B7%9D%E8%8F%9C"},{"name":"下饭菜","url":"xiangha://welcome?so.app?type=caipu&s=%E4%B8%8B%E9%A5%AD%E8%8F%9C"},{"name":"晚餐","url":"xiangha://welcome?so.app?type=caipu&s=%E6%99%9A%E9%A4%90"},{"name":"汤","url":"xiangha://welcome?so.app?type=caipu&s=%E6%B1%A4"},{"name":"凉菜","url":"xiangha://welcome?so.app?type=caipu&s=%E5%87%89%E8%8F%9C"},{"name":"面食","url":"xiangha://welcome?so.app?type=caipu&s=%E9%9D%A2%E9%A3%9F"},{"name":"烤箱","url":"xiangha://welcome?so.app?type=caipu&s=%E7%83%A4%E7%AE%B1"},{"name":"汤羹","url":"xiangha://welcome?so.app?type=caipu&s=%E6%B1%A4%E7%BE%B9"},{"name":"粥","url":"xiangha://welcome?so.app?type=caipu&s=%E7%B2%A5"},{"name":"中餐","url":"xiangha://welcome?so.app?type=caipu&s=%E4%B8%AD%E9%A4%90"},{"name":"清淡","url":"xiangha://welcome?so.app?type=caipu&s=%E6%B8%85%E6%B7%A1"},{"name":"粤菜","url":"xiangha://welcome?so.app?type=caipu&s=%E7%B2%A4%E8%8F%9C"},{"name":"面条","url":"xiangha://welcome?so.app?type=caipu&s=%E9%9D%A2%E6%9D%A1"},{"name":"煲汤","url":"xiangha://welcome?so.app?type=caipu&s=%E7%85%B2%E6%B1%A4"},{"name":"东北菜","url":"xiangha://welcome?so.app?type=caipu&s=%E4%B8%9C%E5%8C%97%E8%8F%9C"},{"name":"西餐","url":"xiangha://welcome?so.app?type=caipu&s=%E8%A5%BF%E9%A4%90"},{"name":"湘菜","url":"xiangha://welcome?so.app?type=caipu&s=%E6%B9%98%E8%8F%9C"},{"name":"荤菜","url":"xiangha://welcome?so.app?type=caipu&s=%E8%8D%A4%E8%8F%9C"},{"name":"热菜","url":"xiangha://welcome?so.app?type=caipu&s=%E7%83%AD%E8%8F%9C"},{"name":"私房菜","url":"xiangha://welcome?so.app?type=caipu&s=%E7%A7%81%E6%88%BF%E8%8F%9C"},{"name":"饼干","url":"xiangha://welcome?so.app?type=caipu&s=%E9%A5%BC%E5%B9%B2"},{"name":"电饼铛","url":"xiangha://welcome?so.app?type=caipu&s=%E7%94%B5%E9%A5%BC%E9%93%9B"},{"name":"孕妇","url":"xiangha://welcome?so.app?type=caipu&s=%E5%AD%95%E5%A6%87"},{"name":"糕点","url":"xiangha://welcome?so.app?type=caipu&s=%E7%B3%95%E7%82%B9"},{"name":"海鲜","url":"xiangha://welcome?so.app?type=caipu&s=%E6%B5%B7%E9%B2%9C"},{"name":"烘焙","url":"xiangha://welcome?so.app?type=caipu&s=%E7%83%98%E7%84%99"},{"name":"意大利面","url":"xiangha://welcome?so.app?type=caipu&s=%E6%84%8F%E5%A4%A7%E5%88%A9%E9%9D%A2"},{"name":"儿童营养","url":"xiangha://welcome?so.app?type=caipu&s=%E5%84%BF%E7%AB%A5%E8%90%A5%E5%85%BB"},{"name":"饺子","url":"xiangha://welcome?so.app?type=caipu&s=%E9%A5%BA%E5%AD%90"},{"name":"冬季菜谱","url":"xiangha://welcome?so.app?type=caipu&s=%E5%86%AC%E5%AD%A3%E8%8F%9C%E8%B0%B1"},{"name":"甜点","url":"xiangha://welcome?so.app?type=caipu&s=%E7%94%9C%E7%82%B9"},{"name":"蛋挞","url":"xiangha://welcome?so.app?type=caipu&s=%E8%9B%8B%E6%8C%9E"},{"name":"儿童早餐","url":"xiangha://welcome?so.app?type=caipu&s=%E5%84%BF%E7%AB%A5%E6%97%A9%E9%A4%90"},{"name":"家常味","url":"xiangha://welcome?so.app?type=caipu&s=%E5%AE%B6%E5%B8%B8%E5%91%B3"},{"name":"果汁","url":"xiangha://welcome?so.app?type=caipu&s=%E6%9E%9C%E6%B1%81"},{"name":"砂锅","url":"xiangha://welcome?so.app?type=caipu&s=%E7%A0%82%E9%94%85"},{"name":"淮扬菜","url":"xiangha://welcome?so.app?type=caipu&s=%E6%B7%AE%E6%89%AC%E8%8F%9C"},{"name":"糖水","url":"xiangha://welcome?so.app?type=caipu&s=%E7%B3%96%E6%B0%B4"},{"name":"宝宝辅食","url":"xiangha://welcome?so.app?type=caipu&s=%E5%AE%9D%E5%AE%9D%E8%BE%85%E9%A3%9F"},{"name":"炖","url":"xiangha://welcome?so.app?type=caipu&s=%E7%82%96"},{"name":"泡菜","url":"xiangha://welcome?so.app?type=caipu&s=%E6%B3%A1%E8%8F%9C"},{"name":"微波炉","url":"xiangha://welcome?so.app?type=caipu&s=%E5%BE%AE%E6%B3%A2%E7%82%89"},{"name":"秋季菜谱","url":"xiangha://welcome?so.app?type=caipu&s=%E7%A7%8B%E5%AD%A3%E8%8F%9C%E8%B0%B1"},{"name":"沙拉","url":"xiangha://welcome?so.app?type=caipu&s=%E6%B2%99%E6%8B%89"},{"name":"煲仔饭","url":"xiangha://welcome?so.app?type=caipu&s=%E7%85%B2%E4%BB%94%E9%A5%AD"},{"name":"7岁儿童","url":"xiangha://welcome?so.app?type=caipu&s=7%E5%B2%81%E5%84%BF%E7%AB%A5"}]
         * name : 热门
         */

        private String name;
        private List<DataBean> data;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {


            @Override
            public String toString() {
                return "DataBean{" +
                        "name='" + name + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }

            /**
             * name : 家常菜
             * url : xiangha://welcome?so.app?type=caipu&s=%E5%AE%B6%E5%B8%B8%E8%8F%9C
             */

            private String name;
            private String url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
