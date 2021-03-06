package library;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Samp
 */
@WebServlet("/Samp")
public class Samp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Samp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		PrintWriter out = response.getWriter();
		//out.println("<table>");
		
		
		int pageid = Integer.parseInt(request.getParameter("page"));
		int per_page = Integer.parseInt(request.getParameter("per_page"));
		
		if(pageid == 1) {
			
		}
		else {
			pageid = pageid-1;
			pageid = pageid*per_page+1;
		}
		
		GetBookList.getBookList();
		
		int totalrecords = GetBookList.row_number-1;

		for(int i=pageid-1;i<pageid+per_page-1;i++) {
			if(i<totalrecords) {
				//out.print("<tr><td>");
				out.println(GetBookList.map_book.get(i));
				//out.println("</td></tr>");
			}
		}
		
		
		int numberofpage = totalrecords/per_page;
		if(totalrecords > numberofpage*per_page) {
			numberofpage = numberofpage+1;
		}
		
		//out.println("<center>");
		
		//for(int i = 1;i <= numberofpage;i++) {
			//out.println("<b><a href=books?page="+i+"&per_page="+per_page+">"+i+"</a></b>");
		//}
		//out.println("</center>");
		
		//out.println("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
