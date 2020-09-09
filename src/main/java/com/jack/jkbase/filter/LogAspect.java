package com.jack.jkbase.filter;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import com.alibaba.fastjson.JSONObject;
import com.jack.jkbase.annotation.ApiLog;
import com.jack.jkbase.util.Helper;
/**
 *  回写调用API时的接口日志,条件是带有@ApiLog注解
 * @author LIBO
 *
 */
@Aspect
//@Component
public class LogAspect {
	//@Autowired SrvLogsRepository logRepo;
	//带有@ApiLog注解且service及其子包下的方法
	@Around("@annotation(com.jack.jkbase.annotation.ApiLog) and "
			+ "( execution(* com.jack.jkbase.controller..*.*(..)) or execution(* com.jack.jkbase.service..*.*(..)) )")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("LogAspect:"+joinPoint);
		//获取方法参数值数组
        Object[] args = joinPoint.getArgs();
        //得到其方法签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //2.最关键的一步:通过这获取到方法的所有参数名称的字符串数组
        String[] parameterNames = methodSignature.getParameterNames();
        //获取方法参数类型数组
        String ip ="";
        Class<?>[] paramTypeArray = methodSignature.getParameterTypes();
        for(int i=0;i<paramTypeArray.length;i++) {
        	if(HttpServletRequest.class.isAssignableFrom(paramTypeArray[i]) ) {//request
        		HttpServletRequest request =  (HttpServletRequest) args[i];
        		ip = Helper.getIpAddress(request);
        		break;
        	}
        }
        //
        String desc="";
        try {
        	Method method = joinPoint.getTarget().getClass()
                    .getMethod(joinPoint.getSignature().getName(), paramTypeArray);
        	  ApiLog anno = method.getAnnotation(ApiLog.class);
        	  if(anno!=null)desc= anno.value();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        
        //注意，如果调用joinPoint.proceed()方法，则修改的参数值不会生效，必须调用joinPoint.proceed(Object[] args)
        Date btime = new Date();
        Object result = joinPoint.proceed();
        Date etime = new Date();
		long diff = etime.getTime()- btime.getTime();
		//解析返回结果
		String rs = "";
		int level = 0;
		if(result==null) rs="";
		else {
			try {
				JSONObject jo = JSONObject.parseObject(result.toString());
				level = jo.getIntValue("status")-1;
			}catch (Exception e) {
			}
			rs = result.toString();
		}
		level = level<0?0:level;
		/*
		 * logRepo.save(new SrvLogs(desc,methodSignature.getName(),ip
		 * ,extractParam(parameterNames,args),rs,btime,etime,diff,level));
		 */
        //如果这里不返回result，则目标对象实际返回值会被置为null
        return result;
	}
	//将参数用json
	private String extractParam(String[] parameterNames,Object[] objParam) {
		JSONObject jo = new JSONObject();
        for (int i = 0; i < objParam.length; i++) {
        	//空字符串将不解析,8个原生数据类型以及字符串直接输出，对象用json输出
    		Object obj = objParam[i];
    		String name = parameterNames[i];
    		if(obj instanceof HttpServletRequest) continue;//忽略request
    		jo.put(name, obj);
        }
        return jo.toJSONString();
    }
	
}
