/*
*Copyright(C) 2021, Vu Van Hai.
* Lab1:
* Digital News
*
* Record of change:
* DATE            Version             AUTHOR           DESCRIPTION
* 2020-2-23       1.0                 HaiVV            control result search page
 */
package controller;

import dao.ArticleDAO;
import dao.impl.ArticleDAOImpl;
import entity.Article;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The class is controller search result page
 *
 * @author Vu Van Hai
 */
public class SearchController extends HttpServlet {

    /**
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * 
     * @param request It is a <code>HttpServletRequest</code> object.
     * @param response  It is a <code>HttpServletResponse</code> object.
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Article mostRecentPost = null;
        List<Article> recentArticle = new ArrayList<>();
        try {
            ArticleDAO articleDAO = new ArticleDAOImpl();
            //begin of set list top 5 recentArticle
            recentArticle = articleDAO.getTopArticles(5);
            request.setAttribute("recentArticle", recentArticle);
            String txtSearch = request.getParameter("txtSearch").trim();
            //set txtSearch
            request.setAttribute("txt", txtSearch);
            String pageIndex = request.getParameter("index");
            if (pageIndex == null) {
                pageIndex = "1";
            }
            int index = Integer.parseInt(pageIndex);
            //set page index
            request.setAttribute("index", index);
            int totalArticle = articleDAO.countArticle(txtSearch);
            int maxPage = totalArticle / 3;
            if (totalArticle % 3 != 0) {
                maxPage++;
            }
            //set max page of result search
            request.setAttribute("maxPage", maxPage);
            int beginPage = index * 3 - 2;
            int endPage = index * 3;
            //set most Top Post
            mostRecentPost = articleDAO.getTopArticles(1).get(0);
            request.setAttribute("mostRecentPost", mostRecentPost);
            //set imagePath
            List<Article> listSearch = articleDAO.search(txtSearch, beginPage, endPage);
            //set list search
            request.setAttribute("list", listSearch);
            request.getRequestDispatcher("SearchResultPage.jsp").forward(request, response);
        } catch (Exception e) {
            // if erro occurs
            request.setAttribute("Error", e);
            request.setAttribute("mostRecentPost", mostRecentPost);
            request.setAttribute("recentArticle", recentArticle);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
