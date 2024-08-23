<%@page import="com.mycompany.sitedinamico.Sites"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Atualizar Site</title>
</head>
<body>
    <h2>Resultado da Atualização</h2>
    
    <%
        String idS = request.getParameter("id");
        String nomeSite = request.getParameter("nomeSite");
        String descricao = request.getParameter("descricao");
        String link = request.getParameter("link");
        int cliques = Integer.parseInt(request.getParameter("cliques"));

        if (idS != null && !idS.isEmpty()) {
            int id = Integer.parseInt(idS);
            Sites site = new Sites();
            site.setId(id);
            site.setNomeSite(nomeSite);
            site.setDescricao(descricao);
            site.setLink(link);
            site.setCliques(cliques);

            boolean sucesso = site.atualizar();

            if (sucesso) {
                out.println("Site atualizado com sucesso!");
            } else {
                out.println("Erro ao atualizar o site.");
            }
        } else {
            out.println("ID do site não fornecido.");
        }
    %>
    
    <p><a href="listaSites.jsp">Voltar para a lista de sites</a></p>
    <p><a href="cadastrarSites.jsp">Cadastrar novo site</a></p>
</body>
</html>
