package exerciseOne;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

@WebServlet("/exerciseOne/numbers")
public class Numbers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] values = request.getParameterValues("numbers");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        ArrayList<Double> arr = new ArrayList<>();
        for (String value: values) {
            try {
                Double valueFormat = Double.parseDouble(value);
                arr.add(valueFormat);
            } catch (Exception e) {
                out.println("<h2>Invalid argument</h2>");
                out.println("</html>");
                out.close();
            }
        }
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        arr.forEach(val->{
            sb.append(Double.toString(val) + " ");
        });
        out.println("<p>" + sb.toString() + "</p>");
        out.println("</html>");
        out.close();
    }
}
