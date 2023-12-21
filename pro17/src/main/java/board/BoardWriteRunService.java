package board;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class BoardWriteRunService implements BoardService {
	
	private BoardDAO boardDAO = BoardDAO.getInstance();
	private static final String UPLOAD_DIR = "G:/file_repo";
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
				// 데이터 입력 요청
		
				/*
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				String writer = request.getParameter("writer");
				String attach_file = request.getParameter("attach_file");
				BoardVO boardVO = new BoardVO(0, title, content, writer, null, attach_file);
				boolean insertResult = boardDAO.insert(boardVO);
				System.out.println("insertResult:" + insertResult);
				request.getSession().setAttribute("insertResult", insertResult);
				*/
				
				File saveDir = new File(UPLOAD_DIR);
				
				DiskFileItemFactory factory = new DiskFileItemFactory();
				
				factory.setRepository(saveDir);
				
				factory.setSizeThreshold(1024 * 1024 * 5);
				
				
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				try {
					String title = null;
					String content = null;
					String writer = null;
					String attach_file = null;
					
					
					List<FileItem> items = upload.parseRequest(request);
					
					for (FileItem item : items) {
						System.out.println("item:" + item);
						
						
						if (item.isFormField()) {
//							String str = item.getFieldName() + ":" + item.getName();
//							System.out.println("str: " + str);
							String itemValue = item.getString("utf-8"); 
							switch (item.getFieldName()) { // fieldName : write.jsp에 있는 name="content" 등 불려오기
							case "title":
								title = itemValue;
								break;
							case "content":
								content = itemValue;
								break;
							case "writer":
								writer = itemValue;
								break;
							}
						} else {
							//String fieldName = item.getFieldName();
							attach_file = item.getName();
							//long fileSize = item.getSize();
							System.out.println("attach_file: " + attach_file);
							
							String uuid =  UUID.randomUUID().toString();
							attach_file = uuid + "_" + item.getName();
							item.write(new File(UPLOAD_DIR + "/" + attach_file));
						}
						
						
					} // for
					
					// VO
					BoardVO boardVO = new BoardVO(0, title, content, writer, null, attach_file);
					boolean insertResult = boardDAO.insert(boardVO);
					request.getSession().setAttribute("insertResult", insertResult);
					
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
				
				//System.out.println("글쓰기 처리 함");
				return "redirect:/board/list";

	}
	

}


