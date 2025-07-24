package login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomerLoginSuccessHandler 
implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.out.println("성공시 :"+authentication.getAuthorities());
		
		List<String> roleNames=new ArrayList<String>();
		authentication.getAuthorities().forEach(authoritie->{
			roleNames.add(authoritie.getAuthority());
		});
		
		response.sendRedirect("/main");
	}
}
