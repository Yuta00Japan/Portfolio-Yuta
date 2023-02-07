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

import model.ItemSearchLogic;
import model.SearchResultBeans;
import model.UserInfoBeans;

/**
 * Servlet implementation class RevisionControler
 */
@WebServlet("/RevisionControler")
public class RevisionControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevisionControler() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession operation = request.getSession();
		
			UserInfoBeans ub = (UserInfoBeans)operation.getAttribute("user");
			//権限を持っていなければリダイレクトする
			if(ub.getAuthority().contains("d")) {
				try {
					//修正したい商品コードを取得
					String number = request.getParameter("number");
			    
					ItemSearchLogic search = new ItemSearchLogic();
					//商品番号をもとに検索した情報を格納
				
					SearchResultBeans result = (SearchResultBeans)search.SearchItem(number);
				
					operation.setAttribute("data", result);
					//検索した商品の情報を表示し、修正画面に遷移
					RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/ModifyExecute.jsp");
					dis.forward(request, response);
			    
				}catch(Exception e) {
					e.printStackTrace();
					request.setAttribute("error","その商品番号は存在しません。");
					RequestDispatcher dis = request.getRequestDispatcher("/View/Modify.jsp");
					dis.forward(request, response);
				}
			}else {
				request.setAttribute("error","あなたに登録内容修正権限は付与されていません");
				RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/Opening.jsp");
				dis.forward(request, response);
			}
		
		
	}

}
