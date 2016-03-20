/**
 * 1. 建立 udpSocket 服务.
 * 2. 提供数据, 并将数据封装到数据包中.
 * 3. 通过 Socket 服务的发送功能, 将数据包发送出去.
 * 4. 关闭服务资源.
 */
public void udpSend() {
	try {
		DatagramSocket ds = new DatagramSocket();
		
		//封装数据包
		byte[] buf = "udp 测试".getBytes();
		
		//定义: 发送的字节流, 发送长度, 目的地址, 目的端口
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.116"), 10000);
		ds.send(dp);
		ds.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}