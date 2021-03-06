package next.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Object user = session.getAttribute("user");
        if (user == null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/login.html");
            requestDispatcher.forward(req, resp);
            return;
        }

        session.removeAttribute("user");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/login.html");
        requestDispatcher.forward(req, resp);
    }
}
