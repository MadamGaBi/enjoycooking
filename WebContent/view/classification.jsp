<%--
    Document   : classification
    Created on : May 05, 2016
    Author     : GaBi
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


 <%--
<sql:query var="classificationsList" dataSource="jdbc/EnjoyCooking">
    SELECT * FROM classification
</sql:query>

<sql:query var="selectedClassification" dataSource="jdbc/EnjoyCooking">
    SELECT name FROM classification WHERE id = ?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query>

<sql:query var="classificationVegetables" dataSource="jdbc/EnjoyCooking">
    SELECT * FROM vegetables WHERE classification_id = ?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query>--%>

 
 
            <div id="categoryLeftColumn">

                <c:forEach var="classification" items="${classificationsList}">
                
                    <c:choose>
                        <c:when test="${classification.name == selectedClassification.name}">
                            <div class="categoryButton" id="selectedCategory">
                                <span class="categoryText">
                               ${classification.name}
                             
                                </span>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <a href="classification?${classification.id}" class="categoryButton">
                                <span class="categoryText">
                                ${classification.name}
       
                                </span>
                            </a>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
 
            </div>
 
            <div id="categoryRightColumn">

                <p id="categoryTitle">${selectedClassification.name}</p>

                <table id="productTable">

                    <c:forEach var="vegetables" items="${classificationVegetables}" varStatus="iter">

                        <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                            <td>
                                <img src="${initParam.vegetablesImagePath}${vegetables.name}.jpg"
                                     alt="${vegetables.name}">
                            </td>
                            <td>
                                ${vegetables.name}
                                <br>
                                <!-- <span class="smallText">${vegetables.name}</span>  -->
                            </td>
                            <td>
                                ${vegetables.kcalPer100g} / (kcal / 100g)
                            </td>
                            <td>
                                <form action="addToRecipe" method="post">
                                    <input type="hidden"
                                           name="vegetableId"
                                           value="${vegetables.id}">
                                    <input type="submit"
                                           value="add to recipe">
                                </form>
                            </td>
                        </tr>

                    </c:forEach>

                </table>
            </div>
                