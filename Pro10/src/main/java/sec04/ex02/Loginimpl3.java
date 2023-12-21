package sec04.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Loginimpl3 implements HttpSessionListener {
	String id;
	String pw;
	static int total;

    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("세션 생성됨");
    	total++;
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("세션 소멸됨");
    	total--;
    }
	
}
