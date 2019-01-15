package de.unidue.inf.is;

import de.unidue.inf.is.domain.Anzeige;
import de.unidue.inf.is.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Einfaches Beispiel, das die Vewendung der Template-Engine zeigt.
 */
public final class HauptseiteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static List<Anzeige> anzeigeList = new ArrayList<>();

    // Just prepare static data to display on screen
    static {
        anzeigeList.add(new Anzeige(true,"Anzeige", "blabla" , 35));
        anzeigeList.add(new Anzeige(true,"Fernseher", "blabla" , 150));
        anzeigeList.add(new Anzeige());
        anzeigeList.add(new Anzeige());
        anzeigeList.add(new Anzeige());
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Put the user list in request and let freemarker paint it.
        request.setAttribute("anzeigeliste", anzeigeList);

        request.getRequestDispatcher("/hauptseite.ftl").forward(request, response);
    }



    // WICHTIG
    // ist wahrscheinlich fuer das submitten da, dass man von http aus werte eingibt
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
                    IOException {

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        if (null != firstname && null != lastname && !firstname.isEmpty() && !lastname.isEmpty()) {

            synchronized (anzeigeList) {
//                anzeigeList.add(new User(firstname, lastname));
            }

        }

        doGet(request, response);
    }
}
