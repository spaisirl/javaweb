package sec01.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private MemberDAO memberDAO = MemberDAO.getInstance();
	private static final String PREFIX = "/WEB-INF/views/member/";
	private static final String SUFFIX = ".jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		String pathInfo = request.getPathInfo();
		String command = pathInfo.substring(1);
	
		System.out.println("pathInfo:" + pathInfo);
		String viewName = PREFIX;
		switch (command) {
		case "listMembers" :
			List<MemberVO> memberList = memberDAO.listMembers();
			request.setAttribute("memberList", memberList);
			viewName += "memberList";
			break;
		case "memberForm" :
			viewName += "memberForm";
			break;	
		case "addMember":
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVo = new MemberVO(id, pwd, name, email, null);
			memberDAO.addMember(memberVo);
			viewName = "redirect:/member/listMembers";
			break;	
		case "delMember":
			memberDAO.delete(request.getParameter("id"));
			viewName = "redirect:/member/listMembers";
			break;
		case "modifyForm":
			System.out.println(request.getParameter("id"));
			String modifyId = request.getParameter("id");
			MemberVO memberVO = memberDAO.selectByID(modifyId);
			request.setAttribute("memberVO", memberVO);
			viewName += "modifyForm";
			break;
		case "modifyMember":
			String id2 = request.getParameter("id");
			String pwd2 = request.getParameter("pwd");
			String name2 = request.getParameter("name");
			String email2 = request.getParameter("email");
			MemberVO memberVO2 = new MemberVO(id2, pwd2, name2, email2, null);
			boolean result = memberDAO.modifyMember(memberVO2);
			System.out.println("result:" + result);
			request.getSession().setAttribute("result", result);
			viewName = "redirect:/member/listMembers";
			break;
		}
		
		// forward (jsp로 바로 갈 경우)
		
		if (!viewName.startsWith("redirect:")) {
		viewName += SUFFIX;
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
		}
		//redirect
		else {
			String redirectPath = viewName.substring("redirect:".length());
			response.sendRedirect(redirectPath);
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
