package com.fivefivelike.mybaselibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author  liugongce
 * 本地存储类
 * 保存字符串到本地{@link #saveString(String, String)}
 * 从本地获取保存的字符串{@link #getString(String)}
 * 保存布尔值到本地{@link #saveBoolean(String, Boolean)}
 * 从本地获取保存的布尔值{@link #getBoolean(String)}
 * 根据键移除{@link #remove(String)}
 * 清空文件{@link #clear()}
 */
public class SaveUtil {
	private static SaveUtil save;
	private SharedPreferences sp;
	private SaveUtil(){}
	/**
	 * 得到单一实例
	 * @return
	 */
	public static SaveUtil getInstance(){
		if(save==null){
			synchronized (SaveUtil.class) {
				if(save==null){
					save=new SaveUtil();
				}
			}
		}
		return save;
	}
	/**
	 * 保存字符串到本地
	 * @param key
	 * @param value
	 */
	public void saveString(String key, String value){
		if(sp==null){
			sp= GlobleContext.getInstance().getApplicationContext().getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
		}
		sp.edit().putString(key, value).commit();
	}
	/**
	 * 从本地获取保存的字符串
	 * @param key
	 * @return
	 */
	public String getString(String key){
		if(sp==null){
			sp= GlobleContext.getInstance().getApplicationContext().getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
		}
		return sp.getString(key, "");
	}
	/**
	 * 保存布尔值到本地
	 * @param key
	 * @param value
	 */
	public void saveBoolean(String key, Boolean value){
		if(sp==null){
			sp= GlobleContext.getInstance().getApplicationContext().getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
		}
		sp.edit().putBoolean(key, value).commit();
	}
	/**
	 * 从本地获取保存的布尔值
	 * @param key
	 * @return
	 */
	public boolean getBoolean(String key){
		if(sp==null){
			sp= GlobleContext.getInstance().getApplicationContext().getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
		}
		return sp.getBoolean(key,false);
	}
	/**
	 * 根据键移除
	 * @param key
	 */
	public void remove(String key){
		if(sp==null){
			sp= GlobleContext.getInstance().getApplicationContext().getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
		}
		
		sp.edit().remove(key).commit();
	}
	/**
	 * 清空文件
	 */
	public  void clear(){
		if(sp==null){
			sp= GlobleContext.getInstance().getApplicationContext().getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
		}
		sp.edit().clear();
	}
	
	/**
	 * 获取包名
	 * @return
	 */
	private String getPackageName(){
		if(GlobleContext.getInstance().getApplicationContext()!=null){
			return GlobleContext.getInstance().getApplicationContext().getPackageName();
		}
		return null;
	}

}
