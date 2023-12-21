package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDeleteService implements BoardService {
	
	private BoardDAO boardDAO = BoardDAO.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 글 삭제
		int bno = Integer.parseInt(request.getParameter("bno"));
		boolean resulteDelete = boardDAO.delete(bno);
		request.getSession().setAttribute("resulteDelete", resulteDelete);
		System.out.println("글 삭제");
		return "redirect:/board/list";
		
	}

	
}


