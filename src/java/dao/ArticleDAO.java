/*
*Copyright(C) 2021, Vu Van Hai.
* J3.L.P0004:
* Digital News
*
* Record of change:
* DATE            Version             AUTHOR           DESCRIPTION
* 2020-2-23       1.0                 HaiVV            control result search page
 */
package dao;

import entity.Article;
import java.util.List;

/**
 * The class is inter face contains method Connection to get article and get
 * list article and count article ,get list article has title contains text
 *
 * @author Vu Van Hai
 */
public interface ArticleDAO {

    /**
     * Get article by id method
     *
     * @param id <code>int</code>
     * @return Article
     * @throws Exception
     */
    public Article getArticleById(int id) throws Exception;

    /**
     * Get list article have integer element method
     *
     * @param top  <code>int</code>
     * @return List: List of Article
     * @throws Exception
     */
    public List<Article> getTopArticles(int top) throws Exception;

    /**
     * Method get list article have title contains string text between index
     * begin point and end point
     *
     * @param txt  <code>String</code>
     * @param beginPoint <code>int</code>
     * @param endPoint <code>int</code>
     * @return List: List of Article
     * @throws Exception
     */
    public List<Article> search(String txt, int beginPoint, int endPoint) throws Exception;

    /**
     * Method count total article have title contains string text
     *
     * @param txt <code>String<code>
     * @return  Integer
     * @throws Exception
     */
    public int countArticle(String txt) throws Exception;
}
