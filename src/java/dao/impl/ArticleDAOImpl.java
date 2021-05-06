/*
*Copyright(C) 2021, Vu Van Hai.
* J3.L.P0004:
* Digital News
*
* Record of change:
* DATE            Version             AUTHOR           DESCRIPTION
* 2020-2-23       1.0                 HaiVV            control result search page
 */
package dao.impl;

import entity.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * The class have method get data from database : get article by id get list
 * article by text search ,get list Recent Articles
 *
 * @author Vu Van Hai
 */
public class ArticleDAOImpl extends DBContext implements dao.ArticleDAO {

    /**
     * Get article by id method
     *
     * @param id  <code>int</code>
     * @return Article
     * @throws Exception
     */
    @Override
    public Article getArticleById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from digital where id = ?";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Article article = new Article(rs.getInt("ID"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getString("author"),
                        rs.getDate("timePost"),
                        rs.getString("shortDes"));
                return article;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return null;
    }

    /**
     * Get list article have integer element method
     *
     * @param top  <code>int</code>
     * @return  List: List of Article
     * @throws Exception
     */
    @Override
    public List<Article> getTopArticles(int top) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<Article> list = new ArrayList<>();
            String query = "select top (?) * from digital\n"
                    + "order by timePost desc";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, top);
            rs = ps.executeQuery();
            while (rs.next()) {
                Article  article= new Article(rs.getInt("ID"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getString("author"),
                        rs.getDate("timePost"),
                        rs.getString("shortDes"));
                list.add(article);
            }
            return list;
        } catch (Exception e) { 
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }
    /**
     * Method get list article have title contains string text between index
     * begin point and end point
     *
     * @param txt  <code>String</code>
     * @param beginPoint <code>int</code>
     * @param endPoint <code>int</code>
     * @return a List: List of Article.
     * @throws Exception
     */ 
    @Override
    public List<Article> search(String txt, int beginPoint, int endPoint) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<Article> list = new ArrayList<>();
            String query = "select * from ("
                    + " select ROW_NUMBER() over (order by ID ASC) as rn, *\n"
                    + " from digital where title \n"
                    + " like ?"
                    + " )as x\n"
                    + " where rn >= ? "
                    + " and rn <= ?";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
            ps.setInt(2, beginPoint);
            ps.setInt(3, endPoint);
            rs = ps.executeQuery();
            while (rs.next()) {
                Article article = new Article(rs.getInt("ID"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getString("author"),
                        rs.getDate("timePost"),
                        rs.getString("shortDes"));
                list.add(article);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        
    }
    /**
     * Method count total article have title contains string text
     *
     * @param txt <code>String<code>
     * @return a integer number
     * @throws Exception
     */
    @Override
    public int countArticle(String txt) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select count(*) from digital \n"
                    + "where title like ?";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
            rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (Exception e) {
             throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

}
