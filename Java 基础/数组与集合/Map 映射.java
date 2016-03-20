/**
 * get(Object Key) 方法返回指定键所映射的值
 * put(K key, V value) 方法来为集合添加数据
 */

public class CityMap {
	public static Map<String, String> model = new LinkedHashMap();
	
	static {
			model.put("北京", new String[]{"北京市"});
			model.put("上海", new String[]{"上海市"});
			model.put("天津", new String[]{"天津市"});
			model.put("重庆", new String[]{"重庆市"});
	}
}

public String[] getProvince() {
	Map<String, String> map = CityMap.model;
	Set<String> st = map.keySet();
	String[] province = st.toArray();
	return province;
}

public String[] getCity(String selectedProvince) {
	Map<String, String> map = CityMap.model;
	String[] arrCity = map.get(selectedProvince);
	return arrCity;
}