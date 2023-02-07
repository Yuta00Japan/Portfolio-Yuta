package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ChangeBeans;
import model.ClientBeans;
import model.QuantityCheck;
import model.SearchResultBeans;
import model.TotalAmountLogic;
import model.UpdateSearchLogic;
import model.UserInfoBeans;

/**
 * 
 */
@WebServlet("/InventoryUpdateControler")
public class InventoryUpdateControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryUpdateControler() {
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
			
			//javascriptの配列を受けとる
			if(ub.getAuthority().contains("u")) {
				try{
					
					//入力された商品コード
				    String[] itemId = request.getParameterValues("itemNumber");
					
					itemId = itemId[0].split(",");
					//数量		
					String []quantity = request.getParameterValues("itemQuantity");
					
					quantity = quantity[0].split(",");
					//入庫か出庫か
					String []method = request.getParameterValues("itemMethod");
					
					method = method[0].split(",");
					
					//取引先番号
					String []dealCode = request.getParameterValues("dealCode");
					
					dealCode = dealCode[0].split(",");
						
					//取引内容を格納する
				
					//確認画面に表示する商品を検索し、BEANSに格納する
					UpdateSearchLogic search = new UpdateSearchLogic();
					
					//商品番号で検索　->格納
				    List<SearchResultBeans>itemList = search.searchName(itemId);
				    
					//取引先番号で検索　->格納
				    List<ClientBeans> clientList = search.searchClient(dealCode);
				    
				    /**
				     * 左から順に
				     * 商品ID　数量　商品情報　在庫操作内容　取引先番号
				     */
				    ChangeBeans save = new ChangeBeans(itemId,quantity,itemList,method,dealCode);
				    
				    //引き出す場合在庫がマイナスにならないように確認する
				    //                                商品情報　扱う数量　引出OR収納
				    QuantityCheck check = new QuantityCheck(itemList,quantity,method);
				    
				    //原価で入庫金額、出庫金額を算出する処理
				    
				    TotalAmountLogic sum = new TotalAmountLogic();
				    //入庫金額処理
				    int warehousingSum =  sum.warehousingAmount(itemList,quantity,method);
				    //出庫金額処理
				    int dispatchingSum = sum.dispatchingSum(itemList, quantity, method);
				    
					//確認画面に表示する情報をセットする
				    
					request.setAttribute("item", itemList);
					request.setAttribute("client", clientList);
					
					//在庫移動内容
					operation.setAttribute("data", save);
					
					request.setAttribute("quantity", quantity);
					request.setAttribute("method", method);
					
					//入庫金額、出庫金額（原価での計算）
					request.setAttribute("warehousing", warehousingSum);
					request.setAttribute("dispatching", dispatchingSum);
					
					UserInfoBeans users = (UserInfoBeans)operation.getAttribute("user");
					
					request.setAttribute("user",users);
					
					RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/ChangeConfirm.jsp");
					dis.forward(request, response);
				
				
				}catch(Exception e) {
					e.printStackTrace();
					request.setAttribute("error","何らかのエラーが発生しました。");
					RequestDispatcher dis = request.getRequestDispatcher("/View/Deposit_withdraw.jsp");
					dis.forward(request, response);
				}
			}else {
				//権限を持っていなければホーム画面へ戻す
				request.setAttribute("error","あなたに商品管理権限は付与されていません");
			    RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/Opening.jsp");
			    dis.forward(request, response);
			}
		
		
	}
}
