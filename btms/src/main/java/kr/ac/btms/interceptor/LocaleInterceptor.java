package kr.ac.btms.interceptor;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 사용자 저의 인터셉터는 HandlerInterceptorAdapter를 상속받아야 한다.
public class LocaleInterceptor extends HandlerInterceptorAdapter{

		@Override
		//컨트롤러 실행 전 호출됨.
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
			HttpSession session = request.getSession();
			
			//브라우저에서 전달한 locale 정보 가져옴.
			String locale = request.getParameter("locale");
			
			//최초 요청 시 locale을 한국어로 설정
			if(locale==null) locale= "ko";
			
			//LOCALE 속성 값을 세션에 저장해 SessionLocaleResolver가 사용할 수 있게 한다.
			session.setAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE", new Locale(locale));
			
			return true;
		}
		
		@Override
		//컨트롤러 실행 후 호출
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
		}
		
		@Override
		//jsp 수행 후 호출
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{
		}
}
