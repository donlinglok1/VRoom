import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/VRoom" }, initParams = { @WebInitParam(name = "default", value = "deff") })
public class VRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VRoom() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		echo(response, httpConnect("https://darkdusk.org/vroom/api/viewer.php?key=/*YOUR API KEY*/&img=/*YOUR IMG PATH*/"));
		echo(response, httpConnect("https://darkdusk.org/vroom/api/viewer.php?key=/*YOUR API KEY*/&img=/*YOUR IMG PATH*/&mo=AR"));
		echo(response, httpConnect("https://darkdusk.org/vroom/api/viewer.php?key=/*YOUR API KEY*/&img=/*YOUR IMG PATH*/&mo=VR"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		final StringBuffer stringBuffer = new StringBuffer();
		String line = null;
		final BufferedReader reader = request.getReader();
		while ((line = reader.readLine()) != null) {
			stringBuffer.append(line);
		}
		// String postBodyString = stringBuffer.toString();

		echo(response, httpConnect("https://darkdusk.org/vroom/api/viewer.php?key=/*YOUR API KEY*/&img=/*YOUR IMG PATH*/"));
		echo(response, httpConnect("https://darkdusk.org/vroom/api/viewer.php?key=/*YOUR API KEY*/&img=/*YOUR IMG PATH*/&mo=AR"));
		echo(response, httpConnect("https://darkdusk.org/vroom/api/viewer.php?key=/*YOUR API KEY*/&img=/*YOUR IMG PATH*/&mo=VR"));
	}

	private void echo(final HttpServletResponse response, final String result) throws IOException {
		final PrintWriter printWriter = response.getWriter();
		printWriter.print("result");
		printWriter.flush();
		printWriter.close();
	}

	public String httpConnect(final String url) throws IOException {
		final HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.setRequestMethod("GET");

		final StringBuffer stringBuffer = new StringBuffer();
		String line = null;

		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		while ((line = bufferedReader.readLine()) != null) {
			stringBuffer.append(line);
		}
		bufferedReader.close();

		return stringBuffer.toString();
	}
}
