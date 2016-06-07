<%--
    Document   : recipe
    Created on : May 08, 2016
    Author     : GaBi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


            <div id="singleColumn">

                <c:choose>
        			<c:when test="${rCart.numberOfIngredients > 1}">
            			<p>Your recipe contains ${rCart.numberOfIngredients} ingredients.</p>
        			</c:when>
        			<c:when test="${rCart.numberOfIngredients == 1}">
            			<p>Your recipe contains ${rCart.numberOfIngredients} ingredient.</p>
        			</c:when>
        			<c:otherwise>
            			<p>Your have not chosen ingredients for new recipe.</p>
        			</c:otherwise>
    			</c:choose>

                <div id="actionBar">
                
                	<%-- clear recipe cart widget --%>
        			<c:if test="${!empty rCart && rCart.numberOfIngredients != 0}">

            			<c:url var="url" value="/viewRecipe">
                			<c:param name="clear" value="true"/>
            			</c:url>

            			<a href="${url}" class="bubble hMargin">clear recipe cart</a>
        			</c:if>

 					<%-- continue adding ingredients widget --%>
        			<c:set var="value">
            			<c:choose>
                			<%-- if 'selectedClassification' session object exists, send user to previously viewed classification --%>
                			<c:when test="${!empty selectedClassification}">
                    			classification
                			</c:when>
                			<%-- otherwise send user to welcome page --%>
                			<c:otherwise>
                    			index.jsp
                			</c:otherwise>
            			</c:choose>
        			</c:set>
        			
        			<c:url var="url" value="${value}"/>
        			<a href="${url}" class="bubble hMargin">continue adding ingredients</a>
        
                    <%-- mix salad widget --%>
        			<c:if test="${!empty rCart && rCart.numberOfIngredients != 0}">
            			<a href="<c:url value='/bonAppetit'/>" class="bubble hMargin">mix salad &#x279f;</a>
        			</c:if>
                </div>

                
                <c:if test="${!empty rCart && rCart.numberOfIngredients != 0}">

      				<h4 id="subtotal">totalKcal: ${rCart.totalKcal};  totalWeight: ${rCart.totalWeight} g</h4>

      <table id="cartTable">

        <tr class="header">
            <th>vegetable</th>
            <th>name</th>
            <th>kcal</th>
            <th>quantity(1=100g)</th>
        </tr>

        <c:forEach var="cartItem" items="${rCart.ingredients}" varStatus="iter">

          <c:set var="vegetable" value="${cartItem.vegetable}"/>

          <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
            <td>
              <img src="${initParam.vegetablesImagePath}${vegetable.name}.jpg"
                   alt="${vegetable.name}">
            </td>

            <td>${vegetable.name}</td>

            <td>
                ${cartItem.total}
                <br>
                <span class="smallText">( ${vegetable.weight} kcal / 100g )</span>
            </td>

            <td>
                <form action="<c:url value='updateRecipe'/>" method="post">
                    <input type="hidden"
                           name="vegetableId"
                           value="${vegetable.id}">
                    <input type="text"
                           maxlength="3"
                           size="3"
                           value="${cartItem.quantity}"
                           name="quantity"
                           style="margin:5px">
                    <input type="submit"
                           name="submit"
                           value="update">
                </form>
            </td>
          </tr>

        </c:forEach>

      </table>

    </c:if>
</div>