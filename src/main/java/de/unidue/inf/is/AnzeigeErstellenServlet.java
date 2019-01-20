package de.unidue.inf.is;

import de.unidue.inf.is.domain.Anzeige;
import de.unidue.inf.is.domain.User;
import de.unidue.inf.is.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * Einfaches Beispiel, das die Vewendung der Template-Engine zeigt.
 */
public final class AnzeigeErstellenServlet extends HttpServlet {

    private Connection con;
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/anzeige_erstellen.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        String titel = request.getParameter("titel");
        Double preis = Double.parseDouble(request.getParameter("preis"));
        String beschreibung = request.getParameter("beschreibung");
        String[] kategorien = request.getParameterValues("kategorie");

        if (!titel.isEmpty()) {

            Anzeige anzeige = new Anzeige(titel, preis, beschreibung, kategorien);

            //TODO mit Anmeldung verbinden und aktuellen Benutzer speichern
            String user = "default";

            con = null;

            try {
                con = DBUtil.getExternalConnection("insdb");
                con.setAutoCommit(false);

                Date currentDate = new Date();
                java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());

                String generatedColumns[] = { "ID" };

                final String statementAnzeigen = "INSERT INTO dbp47.anzeige VALUES (DEFAULT,?,?,?,?,?,?)";
                PreparedStatement preparedStatementAnzeige = con.prepareStatement(statementAnzeigen, generatedColumns);
                preparedStatementAnzeige.setString(1, anzeige.getTitel());
                preparedStatementAnzeige.setString(2, anzeige.getBeschreibung());
                preparedStatementAnzeige.setDouble(3, anzeige.getPreis());
                preparedStatementAnzeige.setDate(4, sqlDate);
                preparedStatementAnzeige.setString(5, "sonichu");
                preparedStatementAnzeige.setString(6, "aktiv");
                preparedStatementAnzeige.execute();

                ResultSet rs = preparedStatementAnzeige.getGeneratedKeys();
                int anzeigeId = 0;
                if (rs.next()) {
                    anzeigeId = rs.getInt(1);
                    //System.out.println("Inserted ID -" + anzeigeId); // display inserted record
                }

                for (String kategorie: kategorien) {
                    final String statementKategorie = "INSERT INTO dbp47.HatKategorie VALUES(?,?)";
                    PreparedStatement preparedStatementKategorie = con.prepareStatement(statementKategorie);
                    preparedStatementKategorie.setInt(1, anzeigeId);
                    preparedStatementKategorie.setString(2, kategorie);
                    preparedStatementKategorie.execute();
                }
                con.commit();

            } catch (SQLException e) {
                try {
                    con.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
                //TODO fehlerhandling
            } finally {
                if(con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

            doGet(request, response);


        }

        //doGet(request, response);
    }

}