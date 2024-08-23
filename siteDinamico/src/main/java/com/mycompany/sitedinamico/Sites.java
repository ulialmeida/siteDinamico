/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sitedinamico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Professor
 */
public class Sites {
    private int id ;
    private String nomeSite;
    private String descricao;
    private String link;
    private int cliques;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nomeSite
     */
    public String getNomeSite() {
        return nomeSite;
    }

    /**
     * @param nomeSite the nomeSite to set
     */
    public void setNomeSite(String nomeSite) {
        this.nomeSite = nomeSite;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return the cliques
     */
    public int getCliques() {
        return cliques;
    }

    /**
     * @param cliques the cliques to set
     */
    public void setCliques(int cliques) {
        this.cliques = cliques;
    }
   
    // Método para salvar a categoria no banco de dados
    public boolean salvar() {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO sites (nomeSite,descricao,link) VALUES (?,?,?)";

        try {
            conn = dbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, getNomeSite());
            ps.setString(2, getDescricao());
            ps.setString(3, getLink());
            

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para retornar todas as categorias do banco de dados
    public static List<Sites> getAllSites() {
        List<Sites> sites = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM sites";

        try {
            conn = dbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Sites site = new Sites();
                site.setId(rs.getInt("id"));
                site.setNomeSite(rs.getString("nomeSite"));
                site.setDescricao(rs.getString("descricao"));
                site.setLink(rs.getString("link"));
                site.setCliques(rs.getInt("cliques"));
                sites.add(site);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sites;
    }

    // Método para retornar uma categoria específica do banco de dados
    public static List<Sites> getSite(int id) {
        List<Sites> sites = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM sites WHERE id = ?";

        try {
            conn = dbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                Sites site = new Sites();
                site.setId(rs.getInt("id"));
                site.setNomeSite(rs.getString("nomeSite"));
                site.setDescricao(rs.getString("descricao"));
                site.setLink(rs.getString("link"));
                site.setCliques(rs.getInt("cliques"));
                sites.add(site);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sites;
    }

    // Método para atualizar uma categoria no banco de dados
    public boolean atualizar() {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "UPDATE sites  SET nomeSite = ?, descricao = ?, link = ? WHERE id = ?";

        try {
            conn = dbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, getNomeSite());
            ps.setString(2, getDescricao());
            ps.setString(3, getLink());
            ps.setInt(4, getCliques());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para apagar uma categoria do banco de dados
    public boolean deletar() {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM sites WHERE id = ?";

        try {
            conn = dbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, getId());

            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Método para retornar todas as categorias do banco de dados
    public static List<Sites> getLastSites() {
        List<Sites> sites = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM `sites` ORDER BY `sites`.`nomeSite`  DESC limit 3";

        try {
            conn = dbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Sites site = new Sites();
                site.setId(rs.getInt("id"));
                site.setNomeSite(rs.getString("nomeSite"));
                site.setDescricao(rs.getString("descricao"));
                site.setLink(rs.getString("link"));
                site.setCliques(rs.getInt("cliques"));
                sites.add(site);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sites;
    }
    
     // Método para contar os cliques
    public boolean contaCliques() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String selectSql = "SELECT cliques FROM sites WHERE id = ?";
        String updateSql = "UPDATE sites SET cliques = ? WHERE id = ?";

        try {
            conn = dbUtil.getConnection();
            // Primeiro, busca a quantidade atual de cliques
            ps = conn.prepareStatement(selectSql);
            ps.setInt(1, getId());
            rs = ps.executeQuery();

            int cliquesAtual = 0;
            if (rs.next()) {
                cliquesAtual = rs.getInt("cliques");
            }

            // Incrementa a quantidade de cliques
            int novoCliques = cliquesAtual + 1;

            // Atualiza a quantidade de cliques no banco de dados
            ps = conn.prepareStatement(updateSql);
            ps.setInt(1, novoCliques);
            ps.setInt(2, getId());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }   
}


    
