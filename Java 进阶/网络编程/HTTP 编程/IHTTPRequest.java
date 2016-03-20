public interface IHTTPRequest {
    /**
     * 向指定 url 发送 POST 请求.
     *
     * @param url 链接, 必须是 http://www.xxx.com 形式
     * @param param 参数, 必须是 name1=value1&name2=value2 形式
     *
     * @return 返回值
     */
    public String post(String url, String param);

    /**
     * 向指定 url 发送 GET 请求.
     *
     * @param url 链接, 必须是 http://www.xxx.com 形式
     * @param param 参数, 必须是 name1=value1&name2=value2 形式
     *
     * @return 返回值
     */
    public String get(String url, String param);
}
