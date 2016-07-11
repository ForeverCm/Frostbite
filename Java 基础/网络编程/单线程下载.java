/**
 * FileOutputStream 类创建输出流对象, 然后使用 write() 方法, 将从输入流获得的网络资源保存到磁盘上, 实现网络资源的单线程下载.
**/

public void download(String urlAddr) {
	try {
		URL url = new URL(urlAddr); //创建 url 对象
		URLConnection urlConn = url.openConnection(); //打开 url 连接
		urlConn.connect(); //连接
		
		InputStream in = urlConn.getInputStream(); //获取字节流
		
		String filePath = url.getFile(); //获取完整路径
		int pos = filePath.lastIndexOf("/") //获得路径中最后一个斜杠的位置
		String fileName = filePath.substring(pos + 1); //截取文件名
		
		FileOutputStream out = new FileOutputStream("D:/" + fileName);//创建输出流对象
		byte[] bt = new byte[1024]; //声明存放下载内容的字节数组
		int len = in.read(bt); //从输入流中读取内容
		
		while(len != -1) {
			out.write(bt, 0, len); //将读取的内容全部写入到输出流
			len = in.read(bt); //继续从输入流中读取内容
		}
		
		//关闭资源
		out.close();
		in.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//注意: 在网络下载时, 通常需要及时的关闭 I/O 流, 因为每个 I/O 流都会占用较多的系统资源, 且不能被垃圾回收机制回收, 当下载资源的用户较多时容易造成系统崩溃.