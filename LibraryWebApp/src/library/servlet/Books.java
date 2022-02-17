//$Id$
package library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.GetBookList;

public class Books extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		GetBookList.getBookList();
		
		PrintWriter out = res.getWriter();
		
		int pageid = Integer.parseInt(req.getParameter("page"));
		int per_page = Integer.parseInt(req.getParameter("per_page"));
		
		if(pageid == 1) {
			
		}
		else {
			pageid = pageid-1;
			pageid = pageid*per_page+1;
		}
		
		for(int i=pageid-1;i<per_page;i++) {
			out.println(GetBookList.map_book.get(i));
		}
		
		for(int i=1;i<=3;i++)
		{
		out.println("<b><a href='v1/books?page=" +i + ">" + i + "</a><b>");
		out.print(" <a href='v1/books?page=2&per_page=3'>2</a> ");
		//out.print(" <a href='v1/books?page=3&per_page=3'>3</a> ");
		}
		//out.print("<b><a href="ViewServlet?page=1">1</a> ); 
		
		out.println("<br><br><a href=\"/v1/books?page="+pageid+">Home</a>");
		
		out.print("<table><tr><th>Id</th><th>Name</th></tr>");
		out.print("</table>");
		
		out.close();
	}
}
