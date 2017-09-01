package cn.software.test;

import java.net.URLEncoder;

import com.baidu.ai.aip.auth.AuthService;
import com.baidu.ai.aip.utils.Base64Util;
import com.baidu.ai.aip.utils.FileUtil;
import com.baidu.ai.aip.utils.HttpUtil;

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String requestUrl="https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";
		String accessToken="";
		String params="";
		AuthService authService=new AuthService();
		String token=authService.getAuth();
		System.out.println(token);
		accessToken=token;
		byte[] b=FileUtil.readFileByBytes("D:/ss/timg.jpg");
		params=Base64Util.encode(b);
		params = "id_card_side=back&" + URLEncoder.encode("image", "UTF-8") + "="
                + URLEncoder.encode(params, "UTF-8");
		System.out.println(params);
		try {
			HttpUtil.post(requestUrl, accessToken, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
