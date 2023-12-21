package sec03.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Json")
public class JsonServlet1 extends HttpServlet {
	
	private MemberDAO memberDao = MemberDAO.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MemberVO> list = memberDao.listMembers();
		response.setContentType("application/json;charset=utf-8");
		String data = "";
		data += "{";
		data += "	\"members\": [";
		
		for (int i = 0; i <list.size(); i++) {
			MemberVO vo = list.get(i);
			data += "{";
			data += " 	\"id\" : \"" + vo.getId() + "\",";
			data += " 	\"pw\" : \"" + vo.getPwd() + "\",";
			data += " 	\"name\" : \"" + vo.getName() + "\",";
			data += " 	\"email\" : \"" + vo.getEmail() + "\",";
			data += " 	\"joindate\" : \"" + vo.getJoindate() + "\"";
			data += "}";
			if (i != list.size() -1) {
				data += ", ";
			}
		}
		
		data += "]}";
		System.out.println("data:" + data);
		response.getWriter().write(data);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
