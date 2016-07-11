public Collection<String> getURLCollection(String urlString) {
	URL url = null;
	URLConnection conn = null;
	
	Collection<String> urlCollection = new ArrayList<String>();
	try {
		url = new URL();
		conn = url.openConnection();
		conn.connect();
		
		InputStream is = conn.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String nextLine = br.readLine();
		
		//遍历读取网页的全部内容, 并添加到集合对象中
		while (nextLine != null) {
			urlCollection.add(nextLine);
			nextLine = br.readLine();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return urlCollection;
}