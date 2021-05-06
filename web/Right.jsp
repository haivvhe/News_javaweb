<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Right</title>
        <link href="css/right.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="right">
            <div class="newst">
                <div class="titleNews">
                    <span>Digital News</span>
                </div>
                <div class="contentNews">
                    <c:catch var="exception">${article.shortDes}</c:catch>
                    <c:if test="${ empty exception}">
                        ${mostRecentPost.shortDes}
                    </c:if>
                    <c:if test="${ not empty exception}">
                        ${article.shortDes}
                    </c:if>                    
                </div>
            </div>
            <div class="newst">
                <div class="titleNews">
                    Search
                </div>
                <form action="search" method="post" autocomplete="off">
                    <input class="searchBox" type="text" name="txtSearch" size="15" value="${txt}" pattern= "^(?=.*\S).+$" required>
                    <input class="searchButton" type="submit" name="btnGo" value="Go">
                </form>                        
            </div>
            <div class="newst">
                <div class="titleNews">
                    <span>Last Articles</span><br>
                </div>
                <c:forEach items="${recentArticle}" var="i">
                    <div class="lastArticles">
                        <a href="detail?id=${i.id}">${i.title}</a>
                    </div>
                </c:forEach>
            </div>
        </div>    
    </body>
</html>
