package servlet;

import com.google.gson.JsonElement;
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
        JsonElement status = getStatus(req.getPathInfo());

        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().print(status.toString());

    }

    protected JsonElement getStatus(String path) {
        String whichSet = null;

        if(path != null) {
            String[] pathParts = path.split("/");
            if (pathParts != null && pathParts.length > 1) {
                whichSet = pathParts[1];
            }
        }
        return CitiBike.getStatus(whichSet);
    }
}