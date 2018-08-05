package util;


import javax.servlet.http.HttpServletRequest;


/**
 * 描述：处理获取地址相关功能
 * @author syd
 *
 */
public class GetPlace {


    /**
     * 描述：根据ip获取地里信息
     */
    public static String getPlaceByIp(HttpServletRequest request){
        String requestName = "http://int.dpool.sina.com.cn/iplookup/iplookup.php";
        String ip = IpUtil.getIpAddr(request);
        if("0:0:0:0:0:0:0:1".equals(ip) || ip.indexOf("192.168") == 0) {
            ip = "218.75.35.101";
        }
        String requestData = "format=json&ip=" + ip;
        String r = HttpClient.sendGet(requestName, requestData);
        return r;
    }

//    public static void main(String[] args) {
//        String requestName = "http://int.dpool.sina.com.cn/iplookup/iplookup.php";
//        String requestData = "format=json&ip=" + "218.75.35.101";
//        LOG.info("GetPlaceRequest:" + requestName + "?" + requestData);
//        String r = HttpClient.sendGet(requestName, requestData);
//        System.out.println(r);
//    }
}
