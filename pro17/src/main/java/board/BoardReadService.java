package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardReadService implements BoardService {
	private BoardDAO boardDAO = BoardDAO.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 데이터 하나 읽기
		BoardVO boardVO = boardDAO.selectByBno(Integer.parseInt(request.getParameter("bno")));
		request.setAttribute("boardVO", boardVO);
		
		System.out.println("글 읽기");
		return "/board/read";
	}

	
}


