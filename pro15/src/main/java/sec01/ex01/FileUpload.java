package sec01.ex01;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@SuppressWarnings("serial")
@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {
	private static final String UPLOAD_DIR = "G:/file_repo";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HttpServletRequest : 스트링 데이터만 처리가능
		// enctype="multipart/form-data" 처리 x
		// -> 아래 값들이 null
		/*
		String file1 = request.getParameter("file1");
		String file2 = request.getParameter("file2");
		String param1 = request.getParameter("param1");
		String param2 = request.getParameter("param2");
		String param3 = request.getParameter("param3");
		System.out.println("file1 " + file1);
		System.out.println("file2 " + file2);
		System.out.println("param1 " + param1);
		System.out.println("param2 " + param2);
		System.out.println("param3 " + param3);
		*/
		
		File saveDir = new File(UPLOAD_DIR);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 저장 경로 설정
		factory.setRepository(saveDir);
		// 최대 크기(파일 사이즈)
		factory.setSizeThreshold(1024 * 1024 * 5); // 약 5메가
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> items =  upload.parseRequest(request);
			for (FileItem item : items) {
				System.out.println("item:" + item);
				// <input type ="file"> 이 아님
				if (item.isFormField()) {
					String str = item.getFieldName() + ":" + item.getString("utf-8");
					System.out.println("str: " + str);
				} else {
					// <input type ="file"> 이다.
					String fieldName = item.getFieldName();
					String fileName = item.getName();
					long fileSize = item.getSize();
					System.out.println("fieldName: " + fieldName);
					System.out.println("fileName: " + fileName);
					System.out.println("fileSize: " + fileSize);
					
					//겹치지 않는 파일명을 만들어준다.
					String uuid = UUID.randomUUID().toString();
					
					item.write(new File(UPLOAD_DIR + File.separator + uuid + "_" + fileName));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
