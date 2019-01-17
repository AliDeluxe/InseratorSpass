package de.unidue.inf.is;

import de.unidue.inf.is.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Einfaches Beispiel, das die Vewendung der Template-Engine zeigt.
 */
public final class AnzeigeErstellenServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/anzeige_erstellen.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        String titel = request.getParameter("titel");
        String preis = request.getParameter("preis");
        String beschreibung = request.getParameter("preis");
        String kategorie = request.getParameter("kategorie");


        if (null != titel && null != beschreibung && null != kategorie) {



        }

        doGet(request, response);
    }

}