package sec03.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@SuppressWarnings("serial")
@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {
	
	private MemberDAO memberDao = MemberDAO.getInstance();

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MemberVO> list = memberDao.listMembers();
		response.setContentType("application/json;charset=utf-8");
		
		JSONArray jsonArray = new JSONArray();
		
		for(MemberVO vo : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", vo.getId());
			jsonObject.put("pwd", vo.getPwd());
			jsonObject.put("name", vo.getName());
			jsonObject.put("email", vo.getEmail());
			jsonObject.put("joindate", vo.getJoindate().toString());
			
			String data = jsonObject.toJSONString();
			System.out.println("data:" + data);
			
			jsonArray.add(jsonObject);
		}
		
		
		String data2 = jsonArray.toJSONString();
		System.out.println("data2:" + data2);
		JSONObject resData = new JSONObject();
		resData.put("members", jsonArray);
		System.out.println("resData:" + resData.toJSONString());
		response.getWriter().write(resData.toJSONString());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
