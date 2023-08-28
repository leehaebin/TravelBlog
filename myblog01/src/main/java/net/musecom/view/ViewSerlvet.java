package net.musecom.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.musecom.database.BlogDto;
import net.musecom.database.BlogImpl;
import net.musecom.database.FileDto;


@WebServlet("/view")
public class ViewSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ViewSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//파일이 있는 경로
		String links = "C:\\lhb\\react\\myblog\\public\\data\\img";		//파일이 있는 경로
		String fdata, flink;
		int num = Integer.parseInt(request.getParameter("num")) ;
		
		BlogImpl blog = new BlogImpl();
		List<FileDto> flists = blog.fileList(num);
		
		request.setAttribute("flist", flists);
		
/*		if(flists.size() >0) {
			for(FileDto flist : flists) {
				fdata = flist.getNewname();
			}	
		}		
*/		
		BlogDto view = blog.bView(num);
		request.setAttribute("view",view);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view.jsp");
		requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
