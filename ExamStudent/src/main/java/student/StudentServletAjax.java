package student;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/student/*")
public class StudentServletAjax extends HttpServlet {
	
	private StudentDao studentDao = StudentDao.getInstance();
	private static final String PREFIX = "/WEB-INF/student/";
	private static final String SUFFIX = ".jsp";
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		String pathInfo = request.getPathInfo();
		String command = pathInfo.substring(1);
	
		System.out.println("pathInfo:" + pathInfo);
		String viewName = PREFIX;
		switch (command) {
		case "list" :
			List<StudentVo> list = studentDao.studentlist();
			request.setAttribute("list", list);
			viewName += "list";
			break;
		case "register_form" :
			viewName += "register_form";
			break;
		case "addStudent":
			Integer s_no = Integer.parseInt(request.getParameter("s_no"));
			String s_name = request.getParameter("s_name");
			Integer s_year = Integer.parseInt(request.getParameter("s_year"));
			String s_gender = request.getParameter("s_gender");
			String s_major = request.getParameter("s_major");
			Integer s_score = Integer.parseInt(request.getParameter("s_score"));
			StudentVo studentVo = new StudentVo(s_no, s_name, s_year, s_gender, s_major, s_score);
			studentDao.addStudent(studentVo);
			viewName = "redirect:/student/list";
			break;	
		case "delete":
			studentDao.delete(Integer.parseInt(request.getParameter("s_no")));
			viewName = "redirect:/student/list";
			break;
		case "modify_form":
			//System.out.println(Integer.parseInt(request.getParameter("s_no")));
			String modifySno = request.getParameter("s_no");
			StudentVo vo = studentDao.selectByID(modifySno);
			request.setAttribute("vo", vo);
			viewName += "modify_form";
			break;
		case "modifyStudent":
			Integer s_no2 = Integer.parseInt(request.getParameter("s_no"));
			String s_name2 = request.getParameter("s_name");
			Integer s_year2 = Integer.parseInt(request.getParameter("s_year"));
			String s_gender2 = request.getParameter("s_gender");
			String s_major2 = request.getParameter("s_major");
			Integer s_score2 = Integer.parseInt(request.getParameter("s_score"));
			
			StudentVo studentVo2 = new StudentVo(s_no2, s_name2, s_year2, s_gender2, s_major2, s_score2);
			boolean result = studentDao.modifyStudent(studentVo2);
			System.out.println("result:" + result);
			request.getSession().setAttribute("result", result);
			viewName = "redirect:/student/list";
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
