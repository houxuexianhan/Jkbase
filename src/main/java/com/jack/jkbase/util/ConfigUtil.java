package com.jack.jkbase.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

//WEB-INF 目录下的属性文件 的读写  
public class ConfigUtil {
	/*
	public static Object setProperty(String filePath,String propertyName,String propertyValue) throws URISyntaxException, IOException {
        Properties p=new Properties();
        String path = getPathForWebinf();
    	//InputStream in = ConfigUtil.class.getClassLoader().getResourceAsStream(filePath);
	    InputStream in = new FileInputStream(path+filePath);
        p.load(in);//
        in.close();
        Object o = p.setProperty(propertyName,propertyValue);//设置属性值，如属性不存在新建
        OutputStream out=new FileOutputStream(path+filePath);
        p.store(out,"modify");//设置属性头，如不想设置，请把后面一个用""替换掉
        out.flush();//清空缓存，写入磁盘
        out.close();//关闭输出流
        ConfigInfo.initOrRefresh();//刷新缓存
        return o;
    }
	public static void setProperties(String filePath,Set<Entry<String, Object>> data) throws IOException, URISyntaxException{
        Properties p=new Properties();
        String path = getPathForWebinf();
	    InputStream in = new FileInputStream(path+filePath);
    	//InputStream in = ConfigUtil.class.getClassLoader().getResourceAsStream(filePath);
        p.load(in);//
        in.close();
        
    	for ( Entry<String,Object> entry : data) { //先遍历整个 people 对象  
		    p.setProperty( entry.getKey(),entry.getValue().toString());//设置属性值，如属性不存在新建
		}  
        OutputStream out=new FileOutputStream(path+filePath);
        //new File(ConfigUtil.class.getClassLoader().getResource(ConfigInfo.PROPERTIES_DEFAULT).toURI()));//输出流
        p.store(out,"modify");//设置属性头，如不想设置，请把后面一个用""替换掉
        out.flush();//清空缓存，写入磁盘
        out.close();//关闭输出流
        ConfigInfo.initOrRefresh();//刷新缓存
	}
	public static Map<String,String> getAllProperties(String filename) throws IOException {
		//Properties pps = new Properties();
		Properties pps = new OrderedProperties();//采用有序读取方式
		String path = getPathForWebinf();
	    InputStreamReader in = new InputStreamReader(new FileInputStream(path+filename), "utf-8") ;//注意编码
		//InputStream in =ConfigUtil.class.getClassLoader().getResourceAsStream(ConfigInfo.PROPERTIES_DEFAULT);
		pps.load(in);
		in.close();
		Map<String,String> map = new LinkedHashMap<String,String>();
		for(String key:pps.stringPropertyNames()) {
			map.put(key, pps.getProperty(key));
		}
		
		return map;
	}*/
    public static void writeProperties(String saveFileName,Properties p) throws IOException {  
        FileOutputStream fos = new FileOutputStream(getPathForWebinf()+saveFileName, false);//true表示追加打开,false每次都是清空再重写  
        OutputStreamWriter out = new OutputStreamWriter(fos, "utf-8");  
        p.store(out,"modify:"+new Date().toString());//设置属性头，如不想设置，请把后面一个用""替换掉
        out.flush();//清空缓存，写入磁盘
        out.close();//关闭输出流
    }  
    public static Properties readProperties(String filename,boolean ordered) throws IOException {  
    	Properties pps =ordered?new OrderedProperties():new Properties();//采用有序读取方式
		String path = getPathForWebinf();
	    InputStreamReader in = new InputStreamReader(new FileInputStream(path+filename), "utf-8") ;//注意编码
		pps.load(in);
		in.close();
		return pps;
    }  
	//获取WEB-INF路径
	public static String getPathForWebinf(){
		String path = ConfigUtil.class.getResource("/").getPath();//得到工程名WEB-INF/classes/路径
	    path=path.substring(1, path.indexOf("classes"));//从路径字符串中取出工程路径
	    return path;
	}
	public static Map<String,String> pro2Map(Properties pro){
		Map<String,String> map = new LinkedHashMap<>();
		for(String key: pro.stringPropertyNames()) {
			map.put(key, pro.getProperty(key));
		}
		return map;
	}
	public static Properties map2Pro(Map<String,String> map,boolean ordered) {
		Properties pro =ordered? new OrderedProperties():new Properties();
		for(Entry<String,String> e:map.entrySet()) {
			pro.put(e.getKey(), e.getValue());
		}
		return pro;
	}
	public static Properties entrySet2Pro(Set<Entry<String,Object>> set,boolean ordered) {
		Properties pro =ordered? new OrderedProperties():new Properties();
		for(Entry<String,Object> e:set) {
			pro.put(e.getKey(), e.getValue());
		}
		return pro;
	}
}
class OrderedProperties extends Properties{

	private static final long serialVersionUID = 1L;
	   /** 
     * 因为LinkedHashSet有序，所以，key在调用put()的时候，存放到这里也就有序。 
     */  
    private final LinkedHashSet<Object> keys = new LinkedHashSet<>();  
    @Override  
    public Object put(Object key, Object value) {  
        keys.add(key);  
        return super.put(key, value);  
    }  
  
    /** 
     * 因为复写了这个方法，在（方式一）的时候,才输出有序。 
     */  
    @Override  
    public Set<String> stringPropertyNames() {  
        Set<String> set = new LinkedHashSet<>();  
        for (Object key : this.keys) {  
            set.add((String) key);  
        }  
        return set;  
    }  
    /** 
     * 因为复写了这个方法，在（方式二）的时候,才输出有序。 
     */  
    @Override  
    public Set<Object> keySet() {  
        return keys;  
    }  
    /** 
     * 因为复写了这个方法，在（方式四）的时候,才输出有序。 
     */  
    @Override  
    public Enumeration<?> propertyNames() {  
        return Collections.enumeration(keys);  
    }  
}
