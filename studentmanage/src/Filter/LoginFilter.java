package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        //��ȡ��Ŀ¼����Ӧ�ľ���·��
        String currentURL = request1.getRequestURI();
        //��ȡ����ǰ�ļ������ڱȽ�
        String targetURL = currentURL.substring(currentURL.indexOf("/",1),currentURL.length());
        //System.out.println(targetURL);
        //���session��Ϊ�վͷ��ظ�session�����Ϊ�վͷ���null
        HttpSession session = request1.getSession(false);
        if(!"/Login.jsp".equals(targetURL)&&!"/number.jsp".equals(targetURL)){
            //�жϵ�ǰҳ���Ƿ����ض��ΰ���ĵ�½ҳ��ҳ�棬����ǾͲ���session���жϣ���ֹ��ѭ��
            if(session.getAttribute("StuId")==null && session.getAttribute("TeacherId")==null&&session.getAttribute("AdminId")==null){
                //���sessionΪ�ձ�ʾ�û�û�е�½���ض���login.jspҳ��
                //System.out.println("request.getContextPath()=" + request.getContextPath());  
                response1.sendRedirect(request1.getContextPath()+"/Login.jsp");
                System.out.println(":1");
                return;
            }
            
        }

		chain.doFilter(request1, response1);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
