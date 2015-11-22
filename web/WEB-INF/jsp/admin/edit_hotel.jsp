<jsp:useBean id="cities" scope="request" type="java.util.List<DAO.beans.City>"/>
<jsp:useBean id="hotel" scope="request" type="DAO.beans.Hotel"/>
<div class="container">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><fmt:message key='editHotel'/></h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-5">
            <form name="sentMessage" id="contactForm" action="/admin/edit_hotel" method="post">
                <input name="id" value="${hotel.id}" hidden>

                <div class="control-group form-group">
                    <div class="controls">
                        <label><fmt:message key='name'/>:</label>
                        <input type="text" name="name" class="form-control" id="name" required
                               data-validation-required-message="Please enter your name." value="${hotel.name}">

                        <p class="help-block"></p>
                    </div>
                </div>
                <div class="form-group">
                    <label><fmt:message key='city'/>/<a href="/admin/add_city"><fmt:message key='addCity'/></a></label>
                    <select name="city" class="form-control">
                        <c:forEach items="${cities}" var="city">
                            <c:choose>
                                <c:when test="${hotel.cityId == city.id}">
                                    <option value="${city.id}" selected>${city.city} - ${city.country}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${city.id}">${city.city} - ${city.country}</option>
                                </c:otherwise>

                            </c:choose>
                        </c:forEach>
                    </select>
                </div>

                <div id="success"></div>
                <!-- For success/fail messages -->
                <button type="submit" class="btn btn-primary">Edit</button>
            </form>

        </div>


    </div>
