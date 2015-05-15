package bupt.zssdhl.SSHFrame.ServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;




import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import bupt.zssdhl.SSHFrame.Service.TuRingService;

public class TuRingServiceImpl  implements TuRingService{

	private static String APIKEY = "08ece3ec65d409a65e5e2b47e479d134";
	private static String baseURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY;
	
	public static String connectAPI(String info,String username) throws IOException{

	    String INFO = URLEncoder.encode(info,"utf-8");
	    String USERNAME = URLEncoder.encode(username,"utf-8");
	    String getURL = baseURL+"&info="+INFO+"&userid="+ USERNAME;
	    URL getUrl = new URL(getURL);
	    HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
	    connection.connect();

	    // ȡ������������ʹ��Reader��ȡ
	    BufferedReader reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8"));
	    StringBuffer sb = new StringBuffer();
	    String line = "";
	    while ((line = reader.readLine()) != null) {
	        sb.append(line);
	    }
	    reader.close();
	    // �Ͽ�����
	    connection.disconnect();
	    return sb.toString();

	}
	
	private static String parse(String resp){
		
		JSONObject jo = JSONObject.fromObject(resp);
		String code = jo.getString("code");
		switch(code){
			case "100000":
				return parse100000(jo);
				
			case "200000":
				return parse200000(jo);
				
				
			case "302000":
				return parse302000(jo);
				
			case "305000":
				return parse305000(jo);
				
			case "306000":
				return parse306000(jo);
				
			case "308000":
				return parse308000(jo);
				
			case "40002":
				return "����˵��ʲô�ɣ�";
			
			case "40004":
				return "�Բ��𣬽��������ݲ��ӿ�";
				
			case "40005":
				return "�Ҳ�����˵����ʲô��˼��";
				
			case "40006":
				return "�������ˣ����������С�����";
				
			default:
				return "�ұ����ˡ�����";
				
		}
	}
	
	private static String parse100000(JSONObject jo){
		StringBuilder sb = new StringBuilder();
		String text = jo.getString("text");
		sb.append(text);
		return sb.toString();
	}
	
	private static String parse200000(JSONObject jo){
		StringBuilder sb = new StringBuilder();
		String text = jo.getString("text");
		String url = jo.getString("url");
		sb.append(text);
		sb.append(" ��ַ�ǣ�\n");
		sb.append(url);
		return sb.toString();
	}
	
	private static String parse302000(JSONObject jo){
		StringBuilder sb = new StringBuilder();
		String text = jo.getString("text");
		sb.append(text);
		sb.append("\n");
		JSONArray ja = jo.getJSONArray("list");
		for(int i=0; i<ja.size(); i++){
			JSONObject jao = ja.getJSONObject(i);
			sb.append("���⣺ ");
			sb.append(jao.getString("article"));
			sb.append("\n");
			sb.append("��Դ�� ");
			sb.append(jao.getString("source"));
			sb.append("\n");
			sb.append("�����ַ�� \n");
			sb.append(jao.getString("detailurl"));
			sb.append("\n -------- \n");
		}
		
		return sb.toString();
	}

	
	private static String parse305000(JSONObject jo){
		StringBuilder sb = new StringBuilder();
		String text = jo.getString("text");
		sb.append(text);
		sb.append("\n");
		JSONArray ja = jo.getJSONArray("list");
		for(int i=0; i<ja.size(); i++){
			JSONObject jao = ja.getJSONObject(i);
			sb.append("���Σ� ");
			sb.append(jao.getString("trainnum"));
			sb.append("\n");
			sb.append("��ʼվ�� ");
			sb.append(jao.getString("start"));
			sb.append("\n");
			sb.append("����վ�� ");
			sb.append(jao.getString("terminal"));
			sb.append("\n");
			sb.append("����ʱ�䣺 ");
			sb.append(jao.getString("starttime"));
			sb.append("\n");
			sb.append("����ʱ�� �� ");
			sb.append(jao.getString("endtime"));
			sb.append("\n");
			sb.append("�����ַ�� \n");
			sb.append(jao.getString("detailurl"));
			sb.append("\n ------- \n");
		}
		
		return sb.toString();
	}
	
	
	private static String parse306000(JSONObject jo){
		StringBuilder sb = new StringBuilder();
		String text = jo.getString("text");
		sb.append(text);
		sb.append("\n");
		JSONArray ja = jo.getJSONArray("list");
		for(int i=0; i<ja.size(); i++){
			JSONObject jao = ja.getJSONObject(i);
			sb.append("���ࣺ ");
			sb.append(jao.getString("flight"));
			sb.append("\n");
			sb.append("����·�� �� ");
			sb.append(jao.getString("route"));
			sb.append("\n");
			sb.append("���ʱ�䣺 ");
			sb.append(jao.getString("starttime"));
			sb.append("\n");
			sb.append("����ʱ�䣺 ");
			sb.append(jao.getString("endtime"));
			sb.append("\n");
			sb.append("����״̬  �� ");
			sb.append(jao.getString("state"));
			sb.append("\n");
			sb.append("���飺\n ");
			sb.append(jao.getString("detailurl"));
			sb.append("\n -------- \n");
		}
		
		return sb.toString();
	}
	
	private static String parse308000(JSONObject jo){
		StringBuilder sb = new StringBuilder();
		String text = jo.getString("text");
		sb.append(text);
		sb.append("\n");
		JSONArray ja = jo.getJSONArray("list");
		for(int i=0; i<ja.size(); i++){
			JSONObject jao = ja.getJSONObject(i);
			sb.append("���ƣ� ");
			sb.append(jao.getString("name"));
			sb.append("\n");
			sb.append("���飺 ");
			sb.append(jao.getString("info"));
			sb.append("\n");
			sb.append("�������� �� \n");
			sb.append(jao.getString("detailurl"));
			sb.append("\n -------- \n");
		}
		
		return sb.toString();
	}
	
	
	@Override
	public String talking(String info,String username) {
		String resp=null;
		try {
			resp = connectAPI(info,username);
		} catch (IOException e) {
			return "some thing wrong";
		}
		
		return parse(resp);
	} 
}
