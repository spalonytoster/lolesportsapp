package com.mposluszny.lolesportsapp.web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns="/index.jsp")
public class HomePageServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6462359365077782522L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view =
				request.getRequestDispatcher("index.jsp");
	}
}
