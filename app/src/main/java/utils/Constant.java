package utils;

/**
 * name:周振辉
 * 时间：2017/8/31 15:29
 * 类描述：
 */

public class Constant {
    public static final String LINK_MAIN = "http://169.254.96.27/";
    public static final String LINK_MOBILE = LINK_MAIN + "mobile/index.php?act=";
    public static final String LINK_MOBILE_CLASS = LINK_MOBILE + "goods_class";  //分类
    public static final String LINK_MOBILE_CLASS_XQ = LINK_MOBILE_CLASS + "&gc_id=";  //二级列表
    public static final String LINK_MOBILE_SPLB = LINK_MOBILE + "goods&op=goods_list&page=100";  //商品列表
    public static final String LINK_MOBILE_SPXQ = LINK_MOBILE + "goods&op=goods_detail&goods_id=";  //商品详情
    public static final String LINK_MOBILE_SPXQ_WEBVIEW = LINK_MOBILE + "goods&op=goods_body&goods_id=";  //商品详情webview
    public static final String LINK_MOBILE_DL = LINK_MOBILE + "login";  //登陆
    public static final String LINK_MOBILE_ZC = LINK_MOBILE_DL + "&op=register";  //注册







}
