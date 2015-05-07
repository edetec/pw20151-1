package br.senai.sc.ti20131n2.pw.servletInto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/contato")
public class Contato extends HttpServlet {
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();

		String fone = request.getParameter("fone");
		String email = request.getParameter("email");
		String mensagem = request.getParameter("mensagem");
		String spam = request.getParameter("spam");
		String uf = request.getParameter("uf");
		
		// ações 
		
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1>Contato</h1>");
		writer.println("<b>Fone: </b>" + fone);
		writer.println("<br />");
		writer.println("<b>E-mail: </b>" + email);
		writer.println("<br />");
		writer.println("<b>Mensagem: </b>" + mensagem);
		if(spam != null && !spam.isEmpty()){
			writer.println("<br />");
			writer.println("<b>Span: </b>" + spam);
		}
		writer.println("<br />");
		writer.println("<b>UF: </b>" + uf);
		writer.println("</body>");
		writer.println("</html>");
	}
}
