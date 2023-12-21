package board;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/download")
public class FileDownload extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String attach_file = request.getParameter("attach_file");
		//java.io.File
		File f = new File("G:/file_repo/" + attach_file);
		FileInputStream input = new FileInputStream(f);
		OutputStream output = response.getOutputStream();
		BufferedInputStream bInput = new BufferedInputStream(input);
		BufferedOutputStream bOutput = new BufferedOutputStream(output);
		byte[] buffer = new byte[1024];
		
		try {
			
			while(true) {
				
				int data = bInput.read(buffer);
				if (data == -1) {
				
					break;
				}
				bOutput.write(buffer);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bInput.close();
			bOutput.close();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
