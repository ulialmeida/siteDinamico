<%-- 
    Document   : verSite
    Created on : 16 de ago. de 2024, 16:50:17
    Author     : Aluno
--%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.sitedinamico.Sites"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastra Site!</title>
    </head>
    <body>
        <h1>Visualizar</h1>
         <%
        String idS = request.getParameter("id");
        
        if (!idS.isEmpty()) {
            int id = Integer.parseInt(idS);
            List<Sites> sites = Sites.getSites(id);
            for (Sites site : sites) {
            %> 
           <div> Nome Site: <%= site.getNomeSite() %></div>
           <div> Descrição: <%= site.getDescricao () %></div>
           <div> link: <%= site.getLink()%></div>
           <div> cliques <%= site.getCliques() %></div>
           
           
            <%
            }
            } else {
                out.print("Site não encontrado");
            }
           %>
                     
    </body>
    
</html>
