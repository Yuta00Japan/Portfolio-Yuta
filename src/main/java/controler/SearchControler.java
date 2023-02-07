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
 * Servlet implementation class SearchControler
 */
@WebServlet("/SearchControler")
public class SearchControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchControler() {
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
			//権限を持っていなければフォワードする
			if(ub.getAuthority().contains("s")) {
				
				try {
					
						String action = request.getParameter("act");
						if(action == null) {
					
						//商品番号か商品名
						String nameCode = request.getParameter("name");
						//除外ワード
						String exception = request.getParameter("exception");
						//価格帯指定　始め
						String startPrice = request.getParameter("startPrice");
						//終わり
						String endPrice = request.getParameter("endPrice");
					
						//検索開始　-> 格納
						ItemSearchLogic search = new ItemSearchLogic();
					
						SearchResultBeans result = (SearchResultBeans)search.SearchLogic(nameCode, exception, startPrice, endPrice);
					
						request.setAttribute("result", result);
					}else if(action.equals("all")) {
						
						//全商品の情報を取得
						ItemSearchLogic search = new ItemSearchLogic();
						
						SearchResultBeans result =(SearchResultBeans)search.SearchItemAll();
						
						request.setAttribute("result", result);
					}
					RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/searchResult.jsp");
					dis.forward(request, response);
				
				}catch(Exception e) {
					e.printStackTrace();
					request.setAttribute("error","そのような商品は見つかりませんでした。");
					RequestDispatcher dis = request.getRequestDispatcher("/View/itemSearch.jsp");
					dis.forward(request, response);	
				}
				
			}else {
				request.setAttribute("error","あなたに商品検索権限は付与されていません");
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
