package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/LogController")
public class LogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = null;

	public void init(ServletConfig config) throws ServletException {
		logger = Logger.getRootLogger();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		logger.debug("Chào 1");
		logger.info("Chao 2");
		logger.warn("Chao 3");
		logger.error("Chao 4");

		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html>");
		printWriter.println("<body>");
		printWriter.println("<head><title> Hello </title> </head>");
		printWriter.println("Log4j w/ a log.properties file <br> ");
		printWriter.println(logger.getName());
		printWriter.println("</body>");
		printWriter.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
