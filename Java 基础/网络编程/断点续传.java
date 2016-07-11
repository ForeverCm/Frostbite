public void download(long startPosition, long endPosition) {
	try {
		URL url = new URL(urlAddress);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		//设置请求属性和范围
		conn.setRequestProperty("User-Agent", "NetFox");
		String rangeProperty = "bytes=" + startPosition + "-";
		
		if (endPosition > 0) {
			rangeProperty += endPosition;
		}
		
		conn.setRequestProperty("RANGE", rangeProperty);
		conn.connect();
		
		InputStream in = conn.getInputStream();
		String file = url.getFile();
		String name = file.substring(file.lastIndexOf("/") + 1);
		FileOutputStream out = new FileOutputStream("D:/" + name, true);
		
		byte[] buff = new byte[2048];
		int len = 0;
		len = in.read(buff);

		while (len != -1) {
			out.write(buff, 0, len);
			len = in.read(buff);
		}
		
		out.close();
		in.close();
		conn.disconnect();
		
		if ( readToPos > 0 && readToPos == totalLength ) {
			System.exit(0);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}