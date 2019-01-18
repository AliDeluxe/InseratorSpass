package de.unidue.inf.is;

import de.unidue.inf.is.domain.Anzeige;
import de.unidue.inf.is.domain.User;
import de.unidue.inf.is.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Einfaches Beispiel, das die Vewendung der Template-Engine zeigt.
 */
public final class AnzeigeErstellenServlet extends HttpServlet {

    private Connection con;
    private static final long serialVersionUID = 1L;

    Set<String> kategorien;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/anzeige_erstellen.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        String titel = request.getParameter("titel");
        Double preis = Double.parseDouble(request.getParameter("preis"));
        String beschreibung = request.getParameter("preis");
        kategorien.add(request.getParameter("kategorie1"));
        kategorien.add(request.getParameter("kategorie2"));
        kategorien.add(request.getParameter("kategorie3"));
        kategorien.add(request.getParameter("kategorie4"));


        if (null != titel && null != beschreibung && null != kategorien) {

            Anzeige anzeige = new Anzeige(titel, preis, beschreibung, kategorien);

            try {
                con = DBUtil.getConnection("insdb");
                final String statement = "INSERT INTO anzeigen VALUES(?,?,?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(statement);
                preparedStatement.setString(1, anzeige.getTitel());
                preparedStatement.setString(2, anzeige.getBeschreibung());
                preparedStatement.setDouble(3, anzeige.getPreis());
            } catch (SQLException e) {
                e.printStackTrace();
                //TODO fehlerhandling
            }


        }

        doGet(request, response);
    }

}