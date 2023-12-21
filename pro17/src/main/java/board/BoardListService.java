package board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardListService implements BoardService {
	BoardDAO boardDAO = BoardDAO.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//DAO 목록얻기
		System.out.println("목록 얻어옴");
		List<BoardVO> list = boardDAO.selectAll();
		request.setAttribute("list", list);
		return "/board/list";
	}

	
}


