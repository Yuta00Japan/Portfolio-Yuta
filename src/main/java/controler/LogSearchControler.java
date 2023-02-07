package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LogSearchLogic;
import model.LogSearchResultBeans;
import model.TimeModify;
import model.UserInfoBeans;

/**
 * Servlet implementation class LogSearchControler
 */
@WebServlet("/LogSearchControler")
public class LogSearchControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogSearchControler() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession operation = request.getSession();
		UserInfoBeans ub = (UserInfoBeans)operation.getAttribute("user");
		//権限を持っていなければリダイレクトする
		if(ub.getAuthority().contains("s")) {
			try {
				
				String startDay = request.getParameter("startDay");
			
				String endDay = request.getParameter("endDay");
			    //入庫テーブルか出庫テーブルのどちらを参照するかが決定される
				String choise = request.getParameter("or");
				
				//startDay endDayのーを除去するロジック
				TimeModify tm = new TimeModify();
				
				//入庫テーブルか出庫テーブルのどちらにアクセスしたいのかを決定する
				LogSearchLogic log = new LogSearchLogic();
				
				//処理済みのstartDay endDayで検索する
				LogSearchResultBeans results =  (LogSearchResultBeans)log.LogSearch(tm.remove(startDay),tm.remove(endDay),choise);
				
				request.setAttribute("data", results);
	            request.setAttribute("choise", choise);
	            
				RequestDispatcher result = request.getRequestDispatcher("/WEB-INF/LogSearchResult.jsp");
				result.forward(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
				request.setAttribute("error","通信に失敗しました。");
				RequestDispatcher dis = request.getRequestDispatcher("/View/LogSearch.jsp");
				dis.forward(request, response);
			}
		}else {
			request.setAttribute("error","あなたにログ検索権限は付与されていません");
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/Opening.jsp");
			dis.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			
		
		
	}

}
