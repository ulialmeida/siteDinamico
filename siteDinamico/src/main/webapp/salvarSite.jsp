<%-- 
    Document   : salvarSite
    Created on : 16 de ago. de 2024, 14:24:39
    Author     : Aluno
--%>

<%@page import="com.mycompany.sitedinamico.Sites"%>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Visualizar Site</title>
</head>
<body>
    <h1>Visualizar Site</h1>
    <%
        String idS = request.getParameter("id");
        if (idS != null && !idS.isEmpty()) {
            try {
                int id = Integer.parseInt(idS);
                List<Sites> sites = Sites.getSite(id);
                if (sites.isEmpty()) {
                    out.println("Site não encontrado.");
                } else {
                    Sites site = sites.get(0); // Assumindo que getSite retorna uma lista com um único item.
    %>
    <div><strong>Nome:</strong> <%= site.getNomeSite() %></div>
    <div><strong>Descrição:</strong> <%= site.getDescricao() %></div>
    <div><strong>Link:</strong> <%= site.getLink() %></div>
    <div><strong>Cliques:</strong> <%= site.getCliques() %></div>
    <%
                }
            } catch (NumberFormatException e) {
                out.println("ID do site inválido.");
            }
        } else {
            out.println("ID do site não fornecido.");
        }
    %>
    <p><a href="listaSites.jsp">Voltar para a lista de sites</a></p>
    <p><a href="cadastrarSites.jsp">Cadastrar novo site</a></p>
</body>
</html>