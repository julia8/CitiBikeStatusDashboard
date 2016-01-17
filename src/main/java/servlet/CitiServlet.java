package servlet;

import explore.CitiBike;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "BikeServlet",
        urlPatterns = {"/bike/*"}
)
public class CitiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getPathInfo();
        String[] pathParts = path.split("/");
        String whichSet = "default";
        if(pathParts != null && pathParts.length > 1) {
            whichSet = pathParts[1];
        }

        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().print(CitiBike.getStatus(whichSet).toString());

    }
}