package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.MainCommand;
import co.micol.prj.common.Command;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map<String,Command> map = new HashMap<>();
    
    public FrontController() {
        super();
        
    }

	public void init(ServletConfig config) throws ServletException {
		//호출하는 이름들의 집합
		map.put("/main.do", new MainCommand());
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청을 분석하고 , 적절한 Command 선택,실행,결과를 돌려줄곳을 정하는곳 
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);//~~.do를 보내면 뒤에값이 동작
		String viewPage = command.exec(request, response);
		
		if(!viewPage.endsWith(".do")) {//
			
			if(viewPage.startsWith("Ajax:")) {//ajax=호출한페이지에서결과를받는것
				//Ajax처리
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			viewPage += ".tiles";
		
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(viewPage);
		}
	}

}
