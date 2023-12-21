package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/member2")
public class MemberServlet extends HttpServlet {

	private MemberDAO memberDAO = MemberDAO.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MemberVO> memberList = memberDAO.listMembers();
		
		response.setContentType("text/html;charset=utf-8");
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<html>");
		sb.append("<html>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>회원 목록</h1>");
		sb.append("<table border='1'>");
		sb.append("<tr>");
		sb.append("	<th>아이디</th>");
		sb.append("	<th>비밀번호</th>");
		sb.append("	<th>이름</th>");
		sb.append("	<th>이메일</th>");
		sb.append("	<th>가입일</th>");
		sb.append("<tr>");
		
		for(MemberVO vo : memberList) {
			sb.append("<tr>");
			sb.append("			<td>" + vo.getId() + "</td>");
			sb.append("			<td>" + vo.getPwd().substring(0,2) + "*****" +"</td>");
			sb.append("			<td>" + vo.getName().substring(0, 1) + "*" + vo.getName().substring(vo.getName().length()-1) + "</td>");
			sb.append("			<td>" + vo.getEmail() + "</td>");
			sb.append("			<td>" + vo.getJoindate() + "</td>");
			sb.append("</tr>");
		}
		
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");
		
		PrintWriter out = response.getWriter();
		out.print(sb.toString());
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
