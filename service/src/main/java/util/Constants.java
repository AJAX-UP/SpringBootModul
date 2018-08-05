package util;

public class Constants {

    public static final int ZERO = 0;

    public static final int ONE = 1;

    public static final int TWO = 2;

    public static final int THREE = 3;

    public static final int FOUR = 4;

    public static final int TEN = 10;

    public static final int TWO_HUNDRED = 200;

    public static final int SEVEN_HUNDRED = 700;

    /** 好医在线医联体ID **/
    public  static final Integer UNION_ID = 99;

    public static final String TOKEN = "token";

    public static final String LOGIN_USER = "login_user";

    public static final String FIELDS = "fields";

    public static final String APPID = "hyzxht2cfa78f19479027b244a09aee4542c";

    public static final String dateStyle = "yyyy-MM-dd HH:mm:ss";

    /** get 请求**/
    public static final String GET = "get";

    /** post,请求**/
    public static final String POST = "post";

    /** jsonPost,数据类型为json格式的post请求**/
    public static final String JSONPOST = "jsonPost";

    /** /api/DjUser/UserLogin, 账号密码登录请求**/
    public static final String loginByPwd = "/api/DjUser/UserLogin";

    /** /api/DjUser/VerifyCodeLogin, 手机验证码登录请求**/
    public static final String loginByCode = "/api/DjUser/VerifyCodeLogin";

    /** /api/DjCommon/SendVerifyCode, 获取短信验证码请求**/
    public static final String getVerifyCode = "/api/DjCommon/SendVerifyCode";

    /** /api/DjDoctor/GetPlatExpertList, 获取平台专家列表请求**/
    public static final String getExpertDocList = "/api/DjDoctor/GetPlatExpertList";

    /** /api/DjUser/Register, 用户注册请求**/
    public static final String userRegister = "/api/DjUser/Register";

    /** /api/DjUser/ResetPwdBySms, 用户修改密码请求**/
    public static final String resetPwdBySms = "/api/DjUser/ResetPwdBySms";

    public static final String resetPwdByPwd = "/api/DjUser/ChangePassword";

    /** /api/DjUser/ThirdpartyAccountLogin, 第三方绑定账号登录（本项目针对微信）**/
    public static final String wxLogin = "/api/DjUser/ThirdpartyAccountLogin";

    /**
     * 切片图片地址
     */
    public static String THUMBNAIL_PRE_URL = "http://service.zjslide.zwjk.com/slide/thumbnail.htm?kfbpath=";

    public static String SLIDE_PRE_URL = "http://service.zjslide.zwjk.com/slide/viewer.htm?kfbpath=";

    public static String SHOT_LIST_URL = "http://service.zjslide.zwjk.com/slide/shotListWithDescripe.htm";

    public static String PTURL;

    public static Long payCloseTime;

    public static String pdfUploadPath;

    public static String pdfUrl;

    /** 短信平台的url **/
    public static String smsUrl;

    //cos所需参数
    public static int COS_APP_ID;
    public static String COS_SECRET_ID;
    public static String COS_SECRET_KEY;
    public static int VALID_TIME;// sign有效期为30天
    public static final String COSAPI_CGI_URL = "http://web.file.myqcloud.com/files/v1/";
    public static final String COSAPI_CGI_URL2 = "http://sh.file.myqcloud.com/files/v2/";
    public static String COS_BUCKET_NAME;// cos上源目录
    public static String COS_FOLDER_PATH;// cos上文件保存路径
    public static Integer COS_SLICE_SIZE;//切片大小

    public void setCosAppId(int cosAppId) {
        COS_APP_ID = cosAppId;
    }

    public void setCosSecretId(String cosSecretId) {
        COS_SECRET_ID = cosSecretId;
    }

    public void setCosSecretKey(String cosSecretKey) {
        COS_SECRET_KEY = cosSecretKey;
    }

    public void setValidTime(int validTime) {
        VALID_TIME = validTime;
    }

    public void setCosBucketName(String cosBucketName) {
        COS_BUCKET_NAME = cosBucketName;
    }

    public void setCosFolderPath(String cosFolderPath) {
        COS_FOLDER_PATH = cosFolderPath;
    }

    public void setCosSliceSize(Integer cosSliceSize) {
        COS_SLICE_SIZE = cosSliceSize;
    }

    public void setPayCloseTime(Long payCloseTime){
        Constants.payCloseTime = payCloseTime;
    }

    public void setPturl(String pturl){
        Constants.PTURL = pturl;
    }

    public void setSmsUrl(String smsUrl) {
        Constants.smsUrl = smsUrl;
    }

    public void setPdfUploadPath(String pdfUploadPath){
        Constants.pdfUploadPath = pdfUploadPath;
    }

    public void setPdfUrl(String pdfUrl){
        Constants.pdfUrl = pdfUrl;
    }

    /** 微信配置相关 **/

    public static String wxAppid;

    public static String wxSecret;

    public static final String WX_USER_UNION_ID = "wx_user_union_id";	//微信用户union_id

    public void setWxAppid(String wxAppid) { Constants.wxAppid = wxAppid;}

    public void setWxSecret(String wxSecret){ Constants.wxSecret = wxSecret;}
}
