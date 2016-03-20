public void TCPServer() {
	try {
		//打开 tcp 端口
		ServerSocket server = new ServerSocket(10000);
		server.setSoTimeout(10000); //连接成功后, 等待读取数据超时时间 10 秒
		while(true) {
			Socket socket = server.accept(); //阻塞等待
            ...
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}