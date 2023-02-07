package controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AnalysisBeans;
import model.ExecuteLogic;

/**
 * Servlet implementation class AnalysisControler
 */
@WebServlet("/AnalysisControler")
public class AnalysisControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalysisControler() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * 出庫記録から売上金額、売上原価、粗利を算出するコントローラです。
     */
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String startday = request.getParameter("startday");
		
		String endday = request.getParameter("endday");
		
		//選択された期間内の売り上げ、仕入原価等を計算する。
		ExecuteLogic exe = new ExecuteLogic();
		
		try {
			/**
			 * 左から順に
			 * 開始日、終了日
			 */
			AnalysisBeans data =(AnalysisBeans)exe.calcSales(startday, endday);
			
			request.setAttribute("analysis",data);
			
			RequestDispatcher calc = request.getRequestDispatcher("/WEB-INF/Calc.jsp");
			calc.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			RequestDispatcher calc = request.getRequestDispatcher("/WEB-INF/Opening.jsp");
			calc.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//
	}

}
