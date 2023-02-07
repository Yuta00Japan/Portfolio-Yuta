package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserInfoBeans;

/**
 * Servlet Filter implementation class RegisterCheckFilter
 */
@WebFilter("/RegisterControler")
public class RegisterCheckFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public RegisterCheckFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		/**
		 * userの情報を保持しているかどうかを確認する
		 */
		
		HttpSession hs = ((HttpServletRequest)request).getSession();
		
		HttpServletResponse res = (HttpServletResponse)response;
		
		try {
			UserInfoBeans user =(UserInfoBeans)hs.getAttribute("user");
			
			if(!(user.equals(null))) {
				chain.doFilter(request, response);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
			///LoginControler
			res.sendRedirect("/Inventory_Management_System/LoginControler");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
