package beerAdvisor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/beerAdvisor/validateAge")
public class AgeValidator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer age = Integer.valueOf(request.getParameter("age"));

        System.out.println(age);

        if (age > 18) {
            request.getSession().setAttribute("age", age);
            response.sendRedirect("/beerAdvisor/beerSelectionForm.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}