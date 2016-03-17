import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * MySQL 的 JDBC 包主要有 JConnect 和 org.git.mm.mysql:
 * JConnect 包更新速度快, 很多程序员都在使用该包.
 * org.git.mm.mysql 包, 一些 Java 爱好者编写的, 出现的时间比较长, 国际化程度做的比较好, 而且对中文的支持也较好, 本实例使用该包.
 *		
 * 连接 MySQL 数据库的驱动程序, 声明如下:
 *	org.git.mm.mysql.Driver
 *	
 * URL 地址, 声明如下:
 *	jdbc:mysql://IP:PORT/databaseName?user=UserName&password=PWD&useUnicode=true
 *	参数说明:
 *		IP: 是指 MySQL 主机的 IP 地址,
 * 		PORT: 是指 MySQL 主机的端口号, 3306 为安装 MySQL 时的默认端口号,
 *		useUnicode: 用于设置是否使用 Unicode 输出,
 */
public class DatabaseUtil {
	private Connection conn = null;
	
	public Connection getConnection() {
		if (conn == null) {
			try {
				//加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				
				//建立连接
				conn = DriverManager.getConnection(DatabaseConf.URL, DatabaseConf.USER, DatabaseConf.PASSWORD);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
}