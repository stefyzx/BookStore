package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import beans.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;

public class MainServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MainServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		//�����Ǹ�����ҳ������Ҫ��ʾ�������ϼ��鱾����Num������һ��list����
		Integer pageNum=(Integer)request.getSession().getAttribute("MainPage_pageNum");
		Integer pageSize=(Integer)request.getSession().getAttribute("MainPage_pageSize");
		List<BookBean> bList=null;
		BookDAO bDAO=new BookDAO();
		bList=bDAO.getNearlyBooks(pageNum,pageSize);
		request.getSession().setAttribute("MainPage_BookList",bList);
		request.getSession().setAttribute("MainPage_BooksCount", bDAO.getBooksCount());
		bDAO.CloseBookDAO();
		
		List<ClassficationBean> cList=null;
		ClassficationDAO cDAO=new ClassficationDAO();
		cList=cDAO.findAllClassfication();
		request.getSession().setAttribute("MainPage_ClassficationList",cList);
		cDAO.CloseClassficationDAO();
		
		response.sendRedirect("/BookStore/JSP/MainPage.jsp");//�ض�����ҳ��
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}