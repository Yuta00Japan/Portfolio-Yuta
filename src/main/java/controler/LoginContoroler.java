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

import model.LoginCheckLogic;
import model.UserInfoBeans;

/**
 * Servlet implementation class LoginContorler
 */
@WebServlet("/LoginControler")
public class LoginContoroler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginContoroler() {
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
				
		//ここから処理が開始する。
		RequestDispatcher start = request.getRequestDispatcher("/WEB-INF/LoginGeneral.jsp");
		start.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			//ログインしたユーザーの情報を保持するセッション
			HttpSession session = request.getSession();
				
			try {
				//入力された社員番号
				String empCode = request.getParameter("empCode");
				
				//入力されたパスワード
				String password = request.getParameter("password");
				
				//従業員番号とパスワードでデータを取得できるかチェック
				LoginCheckLogic start = new LoginCheckLogic();
				
				UserInfoBeans data =(UserInfoBeans)start.LoginLogic(empCode,password);
				
				session.setAttribute("user", data);
				
				RequestDispatcher hello = request.getRequestDispatcher("/WEB-INF/Opening.jsp");
				hello.forward(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
				
				request.setAttribute("error","従業員番号かパスワードが違います");
				RequestDispatcher error = request.getRequestDispatcher("/WEB-INF/LoginGeneral.jsp");
				error.forward(request, response);
			}
	}

}
