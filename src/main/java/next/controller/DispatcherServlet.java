package next.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("URI : {}", req.getRequestURI());
        log.debug("method : {}", req.getMethod());

        Controller controller = RequestMapping.controllerMap.get(req.getRequestURI());
        try {
            String url = controller.execute(req, resp);

            if (url.startsWith("redirect")) {
                resp.sendRedirect(getRedirectUrl(url));
                return;
            }

            RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            log.debug("error : {}", e.getMessage());
        }
    }

    private String getRedirectUrl(String url) {
        String[] tokens = url.split(":");
        if (tokens.length > 1) {
            return tokens[1];
        }

        return tokens[0];

    }
}
