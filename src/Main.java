import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        //md5
        MessageDigest md = MessageDigest.getInstance("MD5");

        String APIKEY = "VCM000000000000005";
        String SECRETKEY = "e46a0ebdbfd141e0aa10f6381eae83b5";

        String md5merchantNo = MD5Utils.stringToMD5("XM000000000000001");
        String md5key = MD5Utils.stringToMD5("9ae76c1d28254ff2a289942dc85700a9");
        String md5nonce = MD5Utils.stringToMD5("xxx");
        //获取时间
        Date date=new Date();
        SimpleDateFormat spl=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newdate=spl.format(date);
        System.out.println("时间搓"+newdate);

        String md5timestamp = MD5Utils.stringToMD5(newdate);
        String md5token = MD5Utils.stringToMD5("token");
        //测试加密
        System.out.println("merchantNo=="+md5merchantNo);
        System.out.println("key=="+md5key);
        System.out.println("nonce=="+md5nonce);
        System.out.println("timestamp=="+md5timestamp);
        System.out.println("token=="+md5token);

        String url = "http://api.ivpai.com/api/v1/getAccessToken/merchant";
        String requsetURL = url.replaceAll("APIKEY",APIKEY).replaceAll("SECRETKEY",SECRETKEY);
        System.out.println(requsetURL);
        String jsonObject = null;
        try {
            jsonObject = HttpUtil.postToken(requsetURL,"md5merchantNo&md5nonce&md5timestamp&md5key");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println(jsonObject);

    }
}
