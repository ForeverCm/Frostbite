public class DownloadMultiThread implements Runnable {
	private String sURL = null;
	private File desFile;
	private long startPos;
	private long endPos;

	public DownloadMultiThread() {

	}
	
	public DownloadMultiThread(String sURL, File desFile, long startPos, long endPos) {
		this.sURL = sURL;
		this.desFile = desFile;
		this.startPos = startPos;
		this.endPos = endPos;
	}
	
	public void run() {
		RandomAccessFile out = new RandomAccessFile(desFile, "rw");
		out.seek(startPos);
		InputStream in = conn.getInputStream();
		BufferedInputStream bin = new BufferedInputStream(in);
		byte[] buff = new byte[2048];
		int len = -1;

		//读取到内存并添加到字节数组
		len = bin.read(buff);
		while (len != -1) {
			out.write(buff, 0, len);
			len = bin.read(buff);
		}
	}
}


public void download(String url, String dest, int threadNum) throws Exception {
	URL downURL = new URL(url);
	HttpURLConnection conn = (HttpURLConnection)downURL.openConnection(); //打开网络连接
	long fileLength = -1;
	int stateFlagCode = conn.getResponseCode(); //获得连续状态标记代码
    
	//网络连接正常
	if (stateFlagCode == 200) {
		fileLength = conn.getContentLength(); //获得文件的长度
		conn.disconnect();
	}
	
	if (fileLength > 0) {
		long byteCounts = fileLength / threadNum + 1; //计算每个线程的字节数
		File file = new File(dest);
		int i = 0;
		while (i < threadNum) {
			//定义开始和结束位置
			long startPosition = byteCounts * i;
			long endPosition = byteCounts * (i + 1);
			if (i == threadNum -1) {
				/* 创建 DownloadMultiThread 线程的实例 */
				DownloadMultiThread fileThread = new DownloadMultiThread(url, file, startPosition, 0); 
				new Thread(fileThread).start(); //启动一个线程对象
			} else {
				DownloadMultiThread fileThread = new DownloadMultiThread(url, file, startPosition, endPosition); 
				new Thread(fileThread).start(); //启动一个线程对象
			}
			i++;
		}
		JOptionPane.showMessageDialog(null, "完成网络资源下载");
	}
}
//注意: 使用多线程下载程序时, 由于创建线程是非常消耗资源的, 如果线程的创建较多, 将极大的影响系统性能, 这时可以使用线程池来提高系统系能, 当需要创建线程时, 可以从线程池中取出空闲线程, 从而提高多线程下载的系统性能.