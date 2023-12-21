package sec04.ex01;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class LoginImpl implements HttpSessionBindingListener {
	String id;
	String pw;
	static int total = 0;
	
	public LoginImpl(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	
	// 해당 클래스로 만들어진 객체가 세션 영역에 값으로 설정(바인딩) 될 때
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("valueBound");
		total++;
	
	}
	
	// 세션에 바인딩된 객체가 제거 될 때
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
			System.out.println("valueUnbound");
			total--;
	}
}
