<html>
<head>
<title>Hauptseite</title>

</head>
 
<body>
  <form name="anzeige" action="Hauptseite" method="post">
    Titel: <input type="text" name="title" /> <br/>
    User: <input type="text" name="user" /> <br/>
    <input type="submit" value="Save" />
  </form>
 
  <table class="datatable">
    <tr>
        <th>Titel</th>  <th>User</th>
    </tr>
    <#list anzeigeliste as anzeige>
    <tr>
        <td>${anzeige.title}</td> <td>${anzeige.user}</td>
    </tr>
    </#list>
  </table>
</body>
</html>