package board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sec01.ex01.MemberDAO;
import sec01.ex01.MemberVO;

/*
 * 항목 			커맨드 			뷰네임				응답방식
 * ---------------------------------------------------------
 * 목록 - 		/list, 			/board/list.jsp, 	forward o
 * 글쓰기폼 - 		/writeForm(get), /board/write.jsp, 	forward o
 * 글쓰기 처리 - 	/writeRun(post), /list, 			redirect o
 * 글 하나 읽기 - 	/read, 			/board/read.jsp, 	forward o
 * 글 수정 폼 - 	read.jsp 사용, 	
 * 글 수정 처리 - 	/modifyRun, 	/read, 				redirect
 * 글 삭제 처리 - /delete, 		/list, 				redirect
 */

@SuppressWarnings("serial")
@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	
	//private BoardDAO boardDAO = BoardDAO.getInstance();
	
	private static final String PREFIX = "/WEB-INF/views";
	private static final String SUFFIX = ".jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getPathInfo();
		System.out.println("command:" + command);
		BoardService service = null;
		switch(command) {
		case "/list" :
			service = new BoardListService();
			break;
		case "/writeForm" :
			service = new BoardWriteFormService();
			break;
		case "/writeRun" :
			service = new BoardWriteRunService();
			break;
		case "/read" :
			service = new BoardReadService();
			break;
		case "/modifyRun" :
			service = new BoardModifyRunService();
			break;
		case "/delete" :
			service = new BoardDeleteService();
			break;
	
		}
		
		String viewName = service.execute(request, response);
		
		// forward (jsp로 바로 갈 경우)
		
				if (!viewName.startsWith("redirect:")) {
				String page = PREFIX + viewName + SUFFIX;
				RequestDispatcher dispatcher = request.getRequestDispatcher(page);
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
