package jp.wicresoft.jdbc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BasicJdbc {

	public <T> List<T> convertJdbcMapToBean(List<Map<String, Object>> mapList, Class<T> clazz) {
		List<T> resultList = new ArrayList<T>();
		for (Map<String, Object> map : mapList) {
			try {
				// initial Object T
				T object = clazz.newInstance();
				Method[] methods = clazz.getMethods();
				for (String key : map.keySet()) {
					// get each object and name
					Object value = map.get(key);
					// get setMethod
					for (Method method : methods) {
						if (method.getName().equals(translateSetMethodName(key))) {
							method.invoke(object, value);
						}
					}
				}
				resultList.add(object);
			} catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultList;
	}

	private String translateSetMethodName(String key) {
		return "set" + key.substring(0, 1).toUpperCase() + key.substring(1);
	}
}
