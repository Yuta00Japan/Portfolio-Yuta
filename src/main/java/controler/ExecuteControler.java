package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ChangeBeans;
import model.ExecuteLogic;
import model.InsertBeans;
import model.SearchResultBeans;
import model.UserInfoBeans;

/**
 * 確認画面を出力する必要がある処理に使用するコントローラーです
 * 
 */

/**
 * Servlet implementation class ExecuteControler
 */
@WebServlet("/ExecuteControler")
public class ExecuteControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteControler() {
        super();
        // TODO Auto-generated constructor stub
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
		
		HttpSession session = request.getSession();
		
		String select = request.getParameter("select");
		
		switch(select) {
			
		case "在庫移動":
			try {
				
				//在庫変更内容を取り出す
				ChangeBeans change = (ChangeBeans)session.getAttribute("data");
				//ログインしているユーザの情報を取り出す
				UserInfoBeans users = (UserInfoBeans)session.getAttribute("user");
				//データベースにアクセスし、在庫を変動させる
				ExecuteLogic exe = new ExecuteLogic(users,change);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("/Inventory_Management_System/ReturnControler");
			
			break;
			
		case "在庫追加":
			try {
				//Beansからデータを取得
				InsertBeans execute = (InsertBeans)session.getAttribute("data");
				//データベースに登録
				ExecuteLogic exe = new ExecuteLogic(execute);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("/Inventory_Management_System/ReturnControler");
			
			break;
		case "登録内容修正":
			try {
				//変更後商品名
				String itemName = request.getParameter("itemname");
				//変更後仕入れ価格
				String itemPrice = request.getParameter("itemprice");
				//変更後商品在庫
				String itemStock = request.getParameter("itemstock");
				//変更後販売価格
				String salesPrice = request.getParameter("salesPrice");
				//変更後商品種別
				String itemType = request.getParameter("itemtype");
				//変更後商品備考
				String itemNote = request.getParameter("itemnote");
				
				//opearationSessionから商品番号を取得する
			    SearchResultBeans result = (SearchResultBeans)session.getAttribute("data");
			    
				//プロシージャで商品の登録情報を修正する
			    ExecuteLogic exe = new ExecuteLogic(result.getItemCode().get(0),itemName,itemPrice,salesPrice,itemStock,itemType,itemNote);
		        
			}catch(Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("/Inventory_Management_System/ReturnControler");
			break;
		}
		
	}

}
