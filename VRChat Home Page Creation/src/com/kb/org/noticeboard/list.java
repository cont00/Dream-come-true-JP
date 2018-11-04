package com.kb.org.noticeboard;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public list() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null || pageNum.equals("0"))
			pageNum = "1";
		
		NoticeBoardDAO nbd = new NoticeBoardDAO();
		ArrayList<NoticeBoardDTO> al_nbd = nbd.getPage(Integer.parseInt(pageNum));
		
		int rows = nbd.getRows();
		
		request.setAttribute("al_nbd", al_nbd);
		request.setAttribute("pageNums", rows/5);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Noticeboard/list.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}