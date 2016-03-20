/**
 * 建立 UDP Socket 服务, 确定接收数据的端口号.
 * 建立一个数据包, 因为需要存储接收到的字节数据, 所以数据包对象中必须足够的功能来提取字节数据中的不同数据信息.
 * 通过 Socket 服务的接收功能, 将收到的数据存入已经定义好的数据包中.
 * 通过数据包对象的特有功能, 将这些不同的数据取出并输出.
 * 关闭服务资源.
 */

public void udpReceive() {
	try {
		//创建 udp 服务, 端口 10000
		DatagramSocket ds = new DatagramSocket(10000);
	
		//定义数据包, 存储数据
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
	
		//通过 Socket 服务的接收方法, 将收到的数据存入数据包中
		ds.receive(dp);
		String ip = dp.getAddress().getHostAddress();
		String data = new String(dp.getData(), 0, dp.getLength);
		int port = dp.getPort();

		System.out.println(ip + "," + data + "," + port);
		ds.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}