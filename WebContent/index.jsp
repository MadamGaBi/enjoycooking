<%--
    Document   : index
    Created on : May 05, 2016
    Author     : GaBi
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<sql:query var="classificationsList" dataSource="jdbc/EnjoyCooking">
  	SELECT * FROM classification
</sql:query>

            <div id="indexLeftColumn">
                <div id="welcomeText">
                    <p style="font-size: larger">A recipe has no soul, you as the cook must bring 
                    							 soul to the recipe.</p> 
                    							 <p style="text-align: right; font-size: small">Thomas Keller</p>
                    <br>
                    <p>Enjoy cooking salads with the online service bringing you 
                       an amazing idea of creating delicious and healthy food.</p>
                </div>
            </div>

            <div id="indexRightColumn">
                <c:forEach var="classification" items="${classificationsList.rows}">
                    <div class="classificationBox">
                        <a href="classification?${classification.id}">
                        <span class="classificationLabel"></span>
                            <span class="classificationLabelText">${classification.name}</span>

                            <img src="${initParam.classificationImagePath}${classification.name}.jpg"
                                 alt="${classification.name}" class="categoryImage">
                                 
                        </a>
                    </div>
                </c:forEach>
            </div>
         