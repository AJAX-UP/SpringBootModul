package util;


import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;


import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wjy
 * @create 2018/1/18
 */
public class CommonMethod {
/* _    _   _____   __      _             _
  | |  | | |_  \ \ / /     | |           | |
  | |  | |   | |\ V /   ___| |_ __ _ _ __| |_
  | |/\| |   | | \ /   / __| __/ _` | '__| __|
  \  /\  /\__/ / | |   \__ \ || (_| | |  | |_
   \/  \/\____/  \_/   |___/\__\__,_|_|   \__|*/
    /**
     * 查库表时对consultStatus，verifyStatus进行联合设置
     * @param consult
     * @param consultStatus
     */
   /* public static void dealConsultStatus( Consult consult, Integer consultStatus){
        dealConsultStatus(consult,consultStatus,false);
    }

    *//**
     * 更新consultStatus的状态
     * @param consult
     * @param consultStatus 病例状态,1草稿；2待支付；3待收货；4待诊断；6已诊断。5已退回；60未审核 61审核通过（已诊断+审核通过） 62表示审核不通过 63表示已结算
     * @param isChangeTime true需要更新对应的时间，false表示查不需要更新时间
     *//*
    public static void dealConsultStatus( Consult consult, Integer consultStatus, boolean isChangeTime){
        if(consultStatus == null){
            return;
        }

        if(consultStatus.equals(CONSULT_STATUS.WAIT_VERIFY)){
            consult.setConsultStatus(CONSULT_STATUS.DIAGNOSED);
            consult.setVerifyStatus(VERIFY_STATUS.WAIT_VERIFY);
        }else if(consultStatus.equals(CONSULT_STATUS.VERIFY_PASS)){
            consult.setConsultStatus(CONSULT_STATUS.DIAGNOSED);
            consult.setVerifyStatus(VERIFY_STATUS.VERIFY_PASS);
        }else if(consultStatus.equals(CONSULT_STATUS.VERIFY_NO_PASS)){
            consult.setConsultStatus(CONSULT_STATUS.DIAGNOSED);
            consult.setVerifyStatus(VERIFY_STATUS.VERIFY_NO_PASS);
        }else if(consultStatus.equals(CONSULT_STATUS.FEE_CLEARED)){
            consult.setConsultStatus(CONSULT_STATUS.DIAGNOSED);
            consult.setVerifyStatus(VERIFY_STATUS.FEE_CLEARED);
        }else if(consultStatus.equals(CONSULT_STATUS.DIAGNOSED)){
            consult.setConsultStatus(CONSULT_STATUS.DIAGNOSED);
        }else if(consultStatus.equals(CONSULT_STATUS.RETURNED)){
            consult.setConsultStatus(CONSULT_STATUS.RETURNED);
            if(isChangeTime){
                consult.setVerifyStatus(VERIFY_STATUS.WAIT_VERIFY);
            }
        }else {
            if(isChangeTime){
                consult.setVerifyStatus(VERIFY_STATUS.WAIT_VERIFY);
            }
            consult.setConsultStatus(consultStatus);
        }
    }


    *//**
     * 设置consultStatusList 和 verifyStatusList 的状态
     * @param consult
     * 病例状态,1草稿；2待支付；3待收货；4待诊断；6已诊断。5已退回；60未审核 61审核通过（已诊断+审核通过） 62表示审核不通过 63表示已结算 223从待收货到待诊断
     *//*
    public static void dealConsultStatusList(Consult consult){
        //包含verifyStatus
        JSONArray consultStatusList = consult.getConsultStatusList();
        if(consultStatusList == null || consultStatusList.size() == 0){
            return;
        }
        Set<Integer> consultStatusListTemp = new HashSet<>();
        Set<Integer> verifyStatusListTemp = new HashSet<>();
        consultStatusList.forEach((consultStatus)-> {
            dealConsultStatus(consult, (Integer) consultStatus,false);
            consultStatusListTemp.add(consult.getConsultStatus());
            if(consult.getVerifyStatus() != null){
                verifyStatusListTemp.add(consult.getVerifyStatus());
            }
        });
        JSONArray verifyStatusList = new JSONArray();
        consultStatusList.clear();
        consultStatusListTemp.addAll(consultStatusList);
        consult.setConsultStatusList(consultStatusList);
        verifyStatusListTemp.addAll(verifyStatusList);
        consult.setVerifyStatusList(verifyStatusList);
    }

    *//**
     * 判断更新数据库时返回的值是否为0
     * @param databaseReturn 0表示没有更改 > 0 表示有更改
     *//*
    public static ResultBean<Integer> isChangedDatabase(ResultBean resultBean, Integer databaseReturn){
        resultBean.setRetData(databaseReturn);
        if(databaseReturn == 0){
            resultBean.setRetCode(RET_CODE.FAIL).setRetInfo("没有做任何更改");
        }
        return resultBean;
    }*/


/*
  \ \        / / | \ \   / /                | |
   \ \  /\  / /  | |\ \_/ /    ___ _ __   __| |
    \ \/ /* \/ /   | | \   /    / _ \ '_ \ / _` |
     \  /\  / |__| |  | |    |  __/ | | | (_| |
      \/  \/ \____/   |_|     \___|_| |_|\__,_| *//*

    *//**
     * 处理SlideList 加上图标阅片地址
     * @param type 0病例
     * @param cut 是否截图
     * @param anno 是否能标注
     * @param showAnno 是否显示标注
     * @param label 是否显示标签
     * @return
     *//*
    public static List<Slide> dealSlideList(List<Slide> slideList, int type, boolean cut, boolean anno, boolean showAnno, boolean label) {
        if(slideList == null || slideList.size() == 0) {
            return slideList;
        }
        try {
            StringBuilder sb = new StringBuilder();
            if(cut) {
                sb.append("&SwitchCut=1");
            }
            if(!anno) {
                sb.append("&SwitchAnno=1");
            }
            if(!showAnno) {
                sb.append("&SwitchShowAnno=1");
            }
            if(!label) {
                sb.append("&SwitchLabel=1");
            }

            for (Slide slide : slideList) {
                //未上传完成
                if (slide.getProcessStatus() != PROCESS_STATUS.UPLOAD_FINISHED) {
                    slide.setSlideCaseUrl("#");
                    slide.setUrlThumbnail("/images/blpt/zzsc.png");
                    slide.setSlideUrl("#");
                    //上传已完成
                } else if(StringUtils.isNotBlank(slide.getCosSlidePath())){
                    String zjSlideId = slide.getUuid();
                    String encryptedCosPath = DESCoder.desEncrypt(slide.getCosSlidePath(), SECRET_KEY.BL_DES_KEY);
                    slide.setUrlThumbnail(Constants.THUMBNAIL_PRE_URL + encryptedCosPath);
                    String slideUrl = Constants.SLIDE_PRE_URL + encryptedCosPath;
                    slideUrl += "&ZJSlideID=" + zjSlideId;
                    slideUrl += sb.toString();
                    slide.setSlideUrl("/?#/blSlide?url=" + URLEncoder.encode(slideUrl, "UTF-8"));
                    slide.setSlideCaseUrl("/?#/blViewSlice?uuid=" + slide.getUuid());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("解析病例切片地址失败！");
        }

        return slideList;
    }

    *//**
     * 根据切片列表获取截图列表
     * @param slideList 病理切片列表
     * @param count 截图数量。0表示全部
     * @return
     * @author dff
     *//*
    public static List<SlideShot> getSlideShotList(List<Slide> slideList, int count) {
        List<SlideShot> shotList = new ArrayList<>();
        if(slideList == null || slideList.size() == 0) {
            return shotList;
        }

        for (Slide slide : slideList) {
            String zjSlideId = slide.getUuid();
            String encryptedCosPath = null;
            try {
                encryptedCosPath = DESCoder.desEncrypt(slide.getCosSlidePath(), SECRET_KEY.BL_DES_KEY);
            } catch (Exception e) {
                throw new RuntimeException("解密错误：" + e);
            }
            String shotListString = HttpClient.sendGet(Constants.SHOT_LIST_URL, "ZJSlideID=" + zjSlideId + "&kfbpath=" + encryptedCosPath);
            LOG.info("shotList requestData:" + Constants.SHOT_LIST_URL + "?ZJSlideID=" + zjSlideId + "&kfbpath=" + encryptedCosPath);
            LOG.info("shotList:" + shotList);
            if (null != shotList && StringUtils.isNotBlank(shotListString)) {
                JSONArray jsonArray = JSONArray.fromObject(shotListString);
                if(jsonArray != null && jsonArray.size() > 0) {
                    for (int j = 0; j < jsonArray.size(); j++) {
                        SlideShot shot = new SlideShot();
                        shot.setUrl(jsonArray.optJSONObject(j).optString("url"));
                        shot.setDescription(jsonArray.optJSONObject(j).optString("description"));
                        shotList.add(shot);
                        if (count != 0 && shotList.size() >= count) {
                            break;
                        }
                    }
                }
                if (count != 0 && shotList.size() >= count) {
                    break;
                }
            }
        }

        return shotList;
    }*/
}
