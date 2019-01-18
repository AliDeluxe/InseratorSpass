<html>
<head>
<title>Anzeige Erstellen</title>

</head>
 
<body>
    <div id="header">
    		<h1> Anzeige erstellen </h1>
    </div>

  <form name="anzeige" action="anzeige_detail" method="post">
    Titel: <br>
    <input type="text" name="titel" style="300px;" max="100"/> <br> <br>
    Preis(€): <br>
    <input type="number" name="preis" min="0" style="width:100px;"/> <br> <br>
    Beschreibung: <br>
    <textarea name="beschreibung" form="usrform">Beschreiben Sie ihren Artikel</textarea> <br> <br>

        <h4> Kategorie: </h4>
          <li>
            <label>
              <input type="checkbox" name="kategorie1" value="digital">
              Digitale Ware
            </label>
          </li>
          <li>
            <label>
               <input type="checkbox" name="kategorie2" value="hausGarten">
               Haus & Garten
            </label>
          </li>
          <li>
            <label>
              <input type="checkbox" name="kategorie3" value="modeKosmetik">
              Mode & Kosmetik
            </label>
          </li>
          <li>
            <label>
              <input type="checkbox" name="kategorie4" value="elektronik">
              Elektronik & Multimedia
            </label>
          </li>
    <br>


    <input type="submit" value="Erstellen" />
  </form>
 

</body>
</html>
