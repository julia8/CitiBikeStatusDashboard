package servlet;

import com.google.gson.JsonElement;
import explore.Weather;
import util.HttpDataHandler;
import util.IInputDataHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "WeatherServlet",
        urlPatterns = {"/weather/*"}
)
public class WeatherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Weather w = new Weather(getHandler());
        JsonElement hourly = w.getHourlyConditions();

        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().print(hourly.toString());
    }

    protected IInputDataHandler getHandler() {
        return new HttpDataHandler();
    }
}
