package com.fivefivelike.mybaselibrary.utils;


import com.fivefivelike.mybaselibrary.entity.AreaObj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AreaUtils {
    private static AreaUtils area;
    private List<AreaObj> proList = new ArrayList<>();
    private List<AreaObj> cityList = new ArrayList<>();
    private List<AreaObj> areaList = new ArrayList<>();
    private List<AreaObj> allList = new ArrayList<>();
    private Map<String, List<AreaObj>> cityMap = new HashMap<String, List<AreaObj>>();
    private Map<String, List<AreaObj>> areaMap = new HashMap<String, List<AreaObj>>();

    private AreaUtils() {
    }

    public static AreaUtils getInstance() {
        if (area == null) {
            synchronized (AreaUtils.class) {
                if (area == null) {
                    area = new AreaUtils();
                }
            }
        }
        return area;
    }

    public void initData() {
        if(allList==null||allList.size()==0) {
            allArea();
        }
    }
    private void allArea() {
//        Map<String,String>map=new HashMap<>();
//        map.put("uid", SaveUtil.getInstance().getString("uid"));
//        map.put("token", SaveUtil.getInstance().getString("token"));
//        new HttpRequest().Builder().setRequestUrl("")
//                .setRequestName("获取地区")
//                .setRequestParams(map)
//                .setOnHttpListener(new RequestCallback() {
//            @Override
//            public void doSuccess(String data, String info, int status, int what) {
//                HttpBaseList<AreaObj> bean = GsonUtil.getInstance().json2List(data, new TypeToken<HttpBaseList<AreaObj>>() {
//                }.getType());
////                if (bean != null && bean.getList().size() > 0) {
////                    allList.addAll(bean.getList());
////                }
//                getProList();
//                initCityMap();
//                initAreaMap();
//            }
//
//            @Override
//            public void doFailure(String data, String info, int status, int what) {
//
//            }
//
//            @Override
//            public void otherError(int what, Throwable exception) {
//
//            }
//
//            @Override
//            public void noInternet() {
//
//            }
//        })
//                .build()
//                .sendGet();


    }

    /**
     * 获取所有的省
     *
     * @return
     */
    public List<AreaObj> getProList() {
        proList.clear();
        for (int i = 0; i < allList.size(); i++) {
            AreaObj areaObj = allList.get(i);
            if (areaObj.getParentid().equals("0")) {
                proList.add(areaObj);
            }
        }
        return proList;
    }

    /**
     * 获取所有省对应市
     */
    private void initCityMap() {
        for (int i = 0; i < proList.size(); i++) {
            List<AreaObj> list = new ArrayList<AreaObj>();
            String areaid = proList.get(i).getAreaid();
            for (int j = 0; j < allList.size(); j++) {
                AreaObj areaObj = allList.get(j);
                if (areaObj.getParentid().equals(areaid)) {
                    list.add(areaObj);
                    cityList.add(areaObj);
                }
            }
            //省         省下的城市
            cityMap.put(areaid, list);
        }
    }

    /**
     * 获取所有市对应的地区
     */
    private void initAreaMap() {
        for (int i = 0; i < cityList.size(); i++) {
            List<AreaObj> list = new ArrayList<>();
            String areaid = cityList.get(i).getAreaid();
            for (int j = 0; j < allList.size(); j++) {
                AreaObj areaObj = allList.get(j);
                if (areaObj.getParentid().equals(areaid)) {
                    list.add(areaObj);
                }
            }
            areaMap.put(areaid, list);
        }
    }

    public List<AreaObj> getCityList(String proId) {
        return cityMap.get(proId);
    }

    public List<AreaObj> getAreaList(String cityId) {
        return areaMap.get(cityId);
    }

    public AreaObj getCityInfo(String cityName){
        for (Map.Entry<String,List<AreaObj>> entry:cityMap.entrySet()){
            List<AreaObj> list = entry.getValue();
            for (AreaObj areaObj:list){
                if(areaObj.getName().contains(cityName)){
                    return areaObj;
                }
            }
        }
        return  null;
    }
}
