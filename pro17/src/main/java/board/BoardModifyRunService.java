package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardModifyRunService implements BoardService {
	
	private BoardDAO boardDAO = BoardDAO.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 수정 처리
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int bno = Integer.parseInt(request.getParameter("bno"));
		BoardVO boardVO = new BoardVO(bno, title, content, null, null, null);
		boolean updateResult = boardDAO.update(boardVO);
		request.getSession().setAttribute("updateResult", updateResult);	
		//System.out.println("수정처리 완료");
		return "redirect:/board/read?bno=" + bno;
	}

	
}


