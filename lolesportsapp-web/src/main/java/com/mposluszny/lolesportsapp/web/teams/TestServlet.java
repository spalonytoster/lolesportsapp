package com.mposluszny.lolesportsapp.web.teams;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.mposluszny.lolesportsapp.core.model.Player;
import com.mposluszny.lolesportsapp.core.model.Team;

@WebServlet(urlPatterns="/test")
public class TestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3972034223077833554L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("HALO JESTEM");
		resp.setContentType("application/json");
		
		PrintWriter out = resp.getWriter();
		//out.print("{\"kombi\": \"guwniak\", \"kartel\": \"bejbi\"}");
		
		Player player = new Player();
		player.setIdPlayer(1L);
		player.setIgn("Wildturtle");
		player.setName("Jason");
		player.setSurname("Tran");
		player.setTeam(new Team("TSM", "NA", "2010-10-10"));
		
		//JsonFactory jsonFactory = new JsonFactory();
		//JsonGenerator jsonGenerator = jsonFactory.createGenerator(out);
		//jsonGenerator.writeObject(player);
		JSONObject playerJson = new JSONObject(player);
		out.print(playerJson);
		
		resp.setStatus(200);
	}
}
