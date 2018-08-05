package util;

/**
 * 不需要验证Token的方法
 */
public class UnneedTokenClass {

    public static final String[] UNNEED_TOKEN_METHOD_ARRAY = new String[]{
            "com.ucmed.swagger.common.UserController.getPlace",
            "com.ucmed.swagger.common.UserController.getVerifyCode",
            "com.ucmed.swagger.common.UserController.loginByCode",
            "com.ucmed.swagger.common.UserController.loginByPwd",
            "com.ucmed.swagger.common.UserController.resetPwd",
            "com.ucmed.swagger.common.UserController.userRegister",
            "com.ucmed.swagger.common.DoctorController.getExpertDoctorList",
            "com.ucmed.swagger.common.DoctorController.getExpertEvaluateList",
            "com.ucmed.swagger.common.Common.zjPay",
            "com.ucmed.swagger.bl.CosController.requestUploadInfo",
            "com.ucmed.swagger.bl.CosController.cosUploadResult",
            "com.ucmed.swagger.bl.CosController.checkConnect",
            "com.ucmed.swagger.bl.CosController.requestMoticUploadInfo",
            "com.ucmed.swagger.bl.CosController.updateSlideListStatus",
            "com.ucmed.swagger.bl.CosController.cosUploadResultFromMotic",
            "com.ucmed.swagger.bl.CosController.getMoticServerInfo",
            "com.ucmed.swagger.bl.CosController.getMoticServerInfo",
            "com.ucmed.swagger.common.DoctorController.getExpertDoctorList",
            "com.ucmed.swagger.common.DoctorController.getExpertEvaluateList"};
}
