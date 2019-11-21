package zhangxiaomei;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class getip {

	

	String a= "\r\n";
    String b="utf-8";
    String c="C:\\wzy\\zxm.txt";
  @RequestMapping("ip")
	public String getIpAddr(HttpServletRequest request) {  
		 String ip = request.getHeader("x-forwarded-for"); 

	      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 

	        ip = request.getHeader("Proxy-Client-IP"); 

	      } 

	      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 

	        ip = request.getHeader("WL-Proxy-Client-IP"); 

	      } 

	      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 

	        ip = request.getHeader("HTTP_CLIENT_IP"); 

	      } 

	      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 

	        ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 

	      } 

	      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 

	        ip = request.getRemoteAddr(); 

	      } 
	      System.out.println("ip是"+ip);
	      
	      //
	      try {
	      System.out.println("1111");
	      request.setCharacterEncoding(b);
	      //获取的ip
	              //  String writer= request.getParameter(ip);
	                System.out.println("ip再次确认是"+ip);
	      File file = new File(c);
	      File f=new File(file.getParent());
	      if(!f.exists()){
	       f.mkdirs();
	      }
	     // FileOutputStream fos = new FileOutputStream("UTF-8",true);
	     
	      Writer fos = new OutputStreamWriter(new FileOutputStream(file,true), b);
	     
	      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	String nowtime = sdf.format(new Date());
	    	System.out.println("nowtime是:"+nowtime);
			fos.write(ip+"  "+"访问时间"+nowtime);
	      fos.write(a);
	      //fos.write(writer.getBytes());
	      fos.close();
	      System.out.println("完成");
	      } catch (Exception e) {
	    	   
	      }

	      return "index"; 

  }
}
