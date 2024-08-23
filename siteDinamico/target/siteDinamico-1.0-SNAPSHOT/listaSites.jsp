<%-- 
    Document   : listaSites
    Created on : 21 de ago. de 2024, 14:07:26
    Author     : Aluno
--%>

<%@ page import="java.util.List" %>
<%@page import="com.mycompany.sitedinamico.Sites"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Sites</title>
</head>
<body>
    <h2>Lista de Sites</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome do Site</th>
            <th>Descrição</th>
            <th>Link</th>
            <th>Cliques</th>
            <th>Editar</th>
            <th>Visualizar</th>
            <th>Excluir</th>
        </tr>
        <%
            List<Sites> sitesList = Sites.getAllSites();
            for (Sites site : sitesList) {
        %>
        <tr>
            <td><%= site.getId() %></td>
            <td><%= site.getNomeSite() %></td>
            <td><%= site.getDescricao() %></td>
            <td><a href="<%= site.getLink() %>" target="_blank"><%= site.getLink() %></a></td>
            <td><%= site.getCliques() %></td>
            <td><a href="editarSites.jsp?id=<%= site.getId() %>">Editar</a></td>
            <td><a href="verSites.jsp?id=<%= site.getId() %>">Ver</a></td>
            <td><a href="excluirSites.jsp?id=<%= site.getId() %>">Excluir</a></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>