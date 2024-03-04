package com.KSW.web.servlet;

import java.io.IOException;

import com.KSW.web.action.ActionForward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("*.us")
public class UserLoginFrontController extends HttpServlet{
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
        ActionForward forward = null;
        
        switch (requestURI) {
		case "/login/Sign-InDB.us": 
			System.out.println("/login/Sign-InDB.us");
			forward = new ActionForward(true, "/login/sign-indb.jsp");
			break;
		case "/login/Sign-up.us":
			System.out.println("/login/Sign-up.us");
			forward = new ActionForward(false, "/login/sign-up.jsp");
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