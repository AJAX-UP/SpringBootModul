package util;


import net.sf.json.JSONObject;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：移动远程基础平台接口调用
 * author: syd
 */
public class YdycPt {


    /**
     * 描述：处理请求方法
     * @param requestName 请求相对路径
     * @param data 请求参数（处理后的）
     * @param type 请求类型
     * @return 请求结果
     */
    public static String processRequests(String requestName, String data, String type){
        String r = null;
        if(Constants.GET.equals(type)){
            return HttpClient.sendGet(Constants.PTURL + requestName, data);
        }else if(Constants.POST.equals(type)){
            return HttpClient.sendPost(Constants.PTURL + requestName, data);
        }else if(Constants.JSONPOST.equals(type)){
            return HttpClient.sendPostByJson(Constants.PTURL + requestName, data);
        }

        return r;
    }

    /**
     *描述：用户名密码登录
     * @param username 用户名
     * @param pwd 密码
     * @param unionid 医联体id
     * @return 登录用户信息
     */
    public static String loginByPwd(String username, String pwd, Integer unionid){
        pwd = SHA256Util.hash(pwd);
        unionid = unionid == null ? 0 : unionid;
        Map map = new HashMap();
        map.put("username", username);
        map.put("pwd", pwd);
        map.put("unionid", unionid);
        JSONObject json = JSONObject.fromObject(map);
        return processRequests(Constants.loginByPwd, json.toString(), Constants.JSONPOST);
    }

    /**
     *描述：手机验证码登录
     * @param phone 手机号
     * @param code 手机验证码
     * @param unionid 医联体id
     * @return 登录用户信息
     */
    public static String loginByCode(String phone, String code, Integer unionid){
        unionid = unionid == null ? 0 : unionid;
        Map map = new HashMap();
        map.put("phone", phone);
        map.put("code", code);
        map.put("unionid", unionid);
        JSONObject json = JSONObject.fromObject(map);
        return processRequests(Constants.loginByCode, json.toString(), Constants.JSONPOST);
    }

    /**
     * 描述：获取短信验证码
     * @param phoneNo 手机号码
     * @param purpose 获取验证码目的
     * @param captchaCode 验证码（可为空）
     * @return
     */
    public static String getVerifyCode(String phoneNo, Integer purpose, String captchaCode){
        captchaCode = captchaCode == null ? "" : captchaCode;
        Map map = new HashMap();
        map.put("PhoneNo", phoneNo);
        map.put("Purpose", purpose);
        map.put("CaptchaCode", captchaCode);
        JSONObject json = JSONObject.fromObject(map);
        return processRequests(Constants.getVerifyCode, json.toString(), Constants.JSONPOST);
    }

    /**
     * 描述：用户注册
     * @param phoneNo 手机号码
     * @param verificationCode 手机验证码
     * @param password 密码
     * @return
     */
    public static String userRegister(String phoneNo, String verificationCode, String password){
        Map map = new HashMap();
        map.put("PhoneNo", phoneNo);
        map.put("VerificationCode", verificationCode);
        map.put("Password", password);
        JSONObject json = JSONObject.fromObject(map);
        return processRequests(Constants.userRegister, json.toString(), Constants.JSONPOST);
    }

    /**
     * 描述：忘记密码（重置）
     * @param phone 手机号码
     * @param code 验证码
     * @param pwd 重置密码
     * @return
     */
    public static String resetPwd(String phone, String code, String pwd){
        pwd = SHA256Util.hash(pwd);
        Map map = new HashMap();
        map.put("phone", phone);
        map.put("code", code);
        map.put("pwd", pwd);
        JSONObject json = JSONObject.fromObject(map);
        return processRequests(Constants.resetPwdBySms, json.toString(), Constants.JSONPOST);
    }

    /**
     * 描述：忘记密码（重置）
     * @param oldpwd 新密码
     * @param newpwd 旧密码
     * @return
     */
    public static String resetPwdByPwd(String oldpwd, String newpwd, String token){
        oldpwd = SHA256Util.hash(oldpwd);
        newpwd = SHA256Util.hash(newpwd);
        Map map = new HashMap();
        map.put("OldPassword", oldpwd);
        map.put("NewPassword", newpwd);
        JSONObject json = JSONObject.fromObject(map);
        return HttpClient.sendPostByJsonToken(Constants.PTURL + Constants.resetPwdByPwd, json.toString(), token);
    }

    /**
     * 微信用户登录
     * @param unionId 微信获取的unionId
     * @return 平台用户信息
     */
    public static String wxLogin(String unionId){
        Map map = new HashMap();
        map.put("acount", unionId);
        map.put("type", Constants.ONE);
        map.put("device", "");
        map.put("channel", 0);
        JSONObject json = JSONObject.fromObject(map);
        return  processRequests(Constants.PTURL + Constants.wxLogin, json.toString(), Constants.JSONPOST);
    }

    /**
     * 根据微信返回的code获取用户信息
     * @param code 微信扫码后获取的code
     * @return 微信用户信息
     */
    public static JSONObject getWxUserInfo(String code){
        JSONObject obj = new JSONObject();
        obj = getAccessToken(code);
        if(obj.optInt("R") != 200){
            return obj;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("access_token=" + obj.optString("accessToken"));
        sb.append("&openid=" + obj.optString("openId"));
        String res = HttpClient.sendGet("https://api.weixin.qq.com/sns/userinfo", sb.toString());
            JSONObject resObj = JSONObject.fromObject(res);
            if(resObj.optString("errcode", null) != null){
                obj.put("R", resObj.optInt("errcode"));
                obj.put("I", resObj.optString("errmsg"));
            }else{
                obj.put("R", 200);
            }
        return obj;
    }


    /**
     * 调用微信接口获取access_token等数据
     * @param code 微信扫码后返回的code
     * @return access_token等数据
     */
    public static JSONObject getAccessToken(String code){
        JSONObject obj = new JSONObject();
        StringBuilder sb = new StringBuilder();
        sb.append("appid=" + Constants.wxAppid);
        sb.append("&secret=" + Constants.wxSecret);
        sb.append("&code=" + code);
        sb.append("&grant_type=authorization_code");
        String res = HttpClient.sendGet("https://api.weixin.qq.com/sns/oauth2/access_token", sb.toString());
        try {
            JSONObject resObj = JSONObject.fromObject(res);
            if(resObj.optString("errcode", null) != null){
                obj.put("R", resObj.optInt("errcode"));
                obj.put("I", resObj.optString("errmsg"));
            }else{
                obj.put("R", 200);
                obj.put("accessToken", resObj.optString("access_token"));
                obj.put("openId", resObj.optString("openid"));
                obj.put("unionId", resObj.optString("unionid"));

            }
        } catch (Exception e) {
            obj.put("R", 1);
            obj.put("I", "微信获取数据异常！");
        }
        return obj;
    }

    /**
     *
     * @param modelId 模块ID
     * @param addressCode 地址编码
     * @param commonSection 标准科室ID
     * @param subspeciality 亚专科类型
     * @param consultType 会诊类型
     * @param keyword 查询关键字
     * @param orderFlag 排序方式 1 price desc 2 price asc 3 consultnum（会诊量） desc 4 consultnum asc
     * @param pageSize 页码
     * @param pageNo 单页条数
     * @return 专家医生列表
     */
    public static String getExpertDocList(Integer modelId, String addressCode, Long hospitalId, Integer commonSection,
                                          String subspeciality, Integer consultType, String keyword,
                                          Integer orderFlag, Integer pageNo, Integer pageSize
    ) throws Exception {
        modelId = modelId == null ? Constants.ZERO : modelId;
        addressCode = addressCode == null ? "" : addressCode;
        hospitalId = hospitalId == null ? Constants.ZERO : hospitalId;
        commonSection = commonSection == null ? Constants.ZERO : commonSection;
        subspeciality = subspeciality == null ? "" : subspeciality;
        consultType = consultType == null ? Constants.ZERO : consultType;
        keyword = keyword == null ? "" : keyword;
        orderFlag = orderFlag == null ? Constants.THREE : orderFlag;
        pageNo = pageNo == null ? Constants.ONE : pageNo;
        pageSize = pageSize == null ? Constants.TEN : pageSize;

        String param = "modelID=" + modelId
                + "&addressCode=" + URLEncoder.encode(addressCode, "UTF-8")
                + "&hospital=" + hospitalId
                + "&comSection=" + commonSection
                + "&subspeciality=" + URLEncoder.encode(subspeciality, "UTF-8")
                + "&consultType=" + consultType
                + "&keyword=" + URLEncoder.encode(keyword, "UTF-8")
                + "&orderFlag=" + orderFlag
                + "&pageNo=" + pageNo
                + "&pageSize=" + pageSize;
        return processRequests(Constants.getExpertDocList, param, Constants.GET);
    }
}
