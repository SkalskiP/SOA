package beerAdvisor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/beerAdvisor/beerPicker")
public class BeerPicker extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String color = request.getParameter("color");

        if (color == null) {
            return;
        }

        BeerMap beerMap = new BeerMap();
        String beer = beerMap.getBeerByColor(BeerColor.valueOf(color.toUpperCase()));

        request.setAttribute("beer", beer);
        request.getRequestDispatcher("/beerAdvisor/finalResult.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}