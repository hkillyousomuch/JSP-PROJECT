package com.KSW.web.servlet.Front;

import java.io.IOException;

import com.KSW.web.action.ActionForward;
import com.KSW.web.servlet.Action.BookParamAction;
import com.KSW.web.servlet.Action.CheckLoginDBAction;
import com.KSW.web.servlet.Action.FindIdAction;
import com.KSW.web.servlet.Action.FindPwAction;
import com.KSW.web.servlet.Action.LogOutAction;
import com.KSW.web.servlet.Action.OrderListAction;
import com.KSW.web.servlet.Action.SearchViewAction;
import com.KSW.web.servlet.Action.UserInfoCheckAction;
import com.oracle.wls.shaded.org.apache.bcel.generic.NEW;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("*.bo")
public class MainFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		HttpSession session = req.getSession();
		session.setAttribute("userid", session.getAttribute("userid"));
        ActionForward forward = null;
        switch (requestURI) {
        // 메인페이지로 이동
        case "/main/main-page.bo" :
        	forward = new ActionForward(true, "/main/main-page.jsp");
        	break;
        // 검색페이지로 이동
		case "/search/SearchView.bo": 
			// 검색페이지로 이동할 때에 userid 값을 가져가기 위한 코드 실행
			 forward = new SearchViewAction().execute(req, resp);
			//forward = new ActionForward(true, "/search/searchview.jsp");
			break;
		// 로그인 페이지로 이동
		case "/login/Sign-up-in.bo":
			forward = new ActionForward(true, "/login/sign-up-in.jsp");
			break;
		case "/myPage/myPage.bo":
			forward = new ActionForward(true, "/myPage/myPage.jsp");
			break;
		// 로그아웃
		case "/login/LogOut.bo":
			// 로그아웃을 위한 메서드
			forward = new LogOutAction().execute(req, resp);
			break;
		case "/myPage/OrderList.bo":
			forward = new OrderListAction().execute(req, resp);
			break;
		// 책 상세 페이지 이동
		case "/search/bookDetails.bo":
        	forward = new BookParamAction().execute(req, resp);
			break;
		// 로그인
		case "/login/Sign-InDB.bo": 
			forward = new CheckLoginDBAction().execute(req, resp);
			break;
		case "/login/Sign-up.bo":
			forward = new ActionForward(false, "/login/sign-up.jsp");
			break;
		// 아이디 찾기 페이지로 이동
		case "/login/Find-id.bo":
			System.out.println("/login/Find-id.us");
			forward = new ActionForward(false, "/login/find-id.jsp");
			break;
		// 아이디 찾기 액션
		case "/login/FindId.bo" :
			System.out.println("아이디 찾기 시작");
			forward = new FindIdAction().execute(req, resp);
			break;
		// 아이디 찾기 결과 페이지 이동
		case "/login/FindIdResult.bo":
			forward = new ActionForward(false, "/login/find-id-result.jsp");
			break;
		// 비밀번호 찾기 페이지로 이동
		case "/login/Find-pw.bo":
			System.out.println("/login/Find-pw.us");
			forward = new ActionForward(false, "/login/find-pw.jsp");
			break;
		// 비밀번호 찾기 액션
		case "/login/FindPw.bo":
			forward = new FindPwAction().execute(req, resp);
			break;
		// 비밀번호 찾기 결과 페이지 이동
		case "/login/FindPwResult.bo": 
			forward = new ActionForward(false, "/login/find-pw-result.jsp");
			break;
		case "/myPage/UserInfoCheck.bo": 
			forward = new ActionForward(false, "/myPage/UserInfoCheck.jsp");
			break;
		case "/myPage/UserInfoChange.bo": 
			forward = new UserInfoCheckAction().execute(req, resp);
			break;
		}
		// 페이지 이동에 대한 일괄 처리
        if (forward != null) {
            if (forward.isRedirect()) { // Redirect 방식
                resp.sendRedirect(forward.getPath());
            } else { // Forward 방식
                req.getRequestDispatcher(forward.getPath()).forward(req, resp);
            }
        }
	}
}