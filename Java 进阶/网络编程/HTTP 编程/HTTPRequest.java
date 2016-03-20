import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class HTTPRequest implements IHTTPRequest {
    public String post(String url, String param) {
        String result = "";
        BufferedReader in = null;

        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            URLConnection conn = realUrl.openConnection(); //打开连接

            /** HTTP 协议头， user-agent 必须声明 **/
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0");
            
            /** post 请求设置 **/
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();

            /** Buffer 包装, 大幅提高写速度 **/
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            if (in != null) {
                System.out.println(in.readLine());
                System.out.println(new Date());
            }
        } catch (Exception e) {
            System.out.println("send POST error" + e);
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public String get(String url, String param) {
        String result = "";
        BufferedReader in = null;

        try {
            String urlNameString = url + "?" + param;

            URL realUrl = new URL(urlNameString);
            URLConnection conn = realUrl.openConnection(); //打开连接(url 对象的属性)

            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive"); //设置请求通用属性
            conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0");
            conn.connect();

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            if (in != null) {
                System.out.println(in.readLine());
                System.out.println(new Date());
            }
        } catch (Exception e) {
            System.out.println("send GET error!" + e);
            e.printStackTrace();
        } finally { //关闭输入流
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}