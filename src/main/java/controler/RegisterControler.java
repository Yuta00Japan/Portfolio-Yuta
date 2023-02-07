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

import model.InsertBeans;
import model.UserInfoBeans;

/**
 * Servlet implementation class RegisterControler
 */
@WebServlet("/RegisterControler")
public class RegisterControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterControler() {
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
			//権限を持っていなければフォワード
			if(ub.getAuthority().contains("i")) {
				try{
					
					String itemName = request.getParameter("name");
					/*仕入れ価格*/
					String itemPrice = request.getParameter("price");
					/*販売価格*/
					String salesPrice = request.getParameter("salesprice");
			
					String itemStock = request.getParameter("stock");
			
					String itemType = request.getParameter("type");
			
					String itemNote = request.getParameter("note");
			
					//登録内容を格納する
					InsertBeans insert = new InsertBeans(itemName,itemPrice,salesPrice,itemStock,itemType,itemNote);
				    //確認画面へ遷移
					operation.setAttribute("data", insert);
					
					RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/insertConfirm.jsp");
					dis.forward(request, response);
				
				}catch(Exception e) {
		    		e.printStackTrace();
		    		RequestDispatcher dis = request.getRequestDispatcher("/View/itemSearch.jsp");
		    		dis.forward(request, response);
		    	}
			}else {
				request.setAttribute("error","あなたに商品登録権限は付与されていません");
				RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/Opening.jsp");
				dis.forward(request, response);
			}
		
		
	}

}
