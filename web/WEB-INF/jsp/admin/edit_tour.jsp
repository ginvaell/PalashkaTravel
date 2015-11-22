<jsp:useBean id="hotels" scope="request" type="java.util.List<DAO.beans.Hotel>"/>
<jsp:useBean id="types" scope="request" type="java.util.List<DAO.beans.Type>"/>
<jsp:useBean id="tour" scope="request" type="DAO.beans.Tour"/>


<div class="container">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><fmt:message key='editTour'/></h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-5">
            <form name="sentMessage" id="contactForm" action="/admin/edit_tour" method="post">
                <div class="control-group form-group">
                    <input name="id" value="${tour.id}" hidden>
                    <div class="controls">
                        <label ><fmt:message key='name'/>:</label>
                        <input type="text" name="name" class="form-control" id="name" required
                               data-validation-required-message="Please enter your name." value="${tour.name}">

                        <p class="help-block"></p>
                    </div>
                </div>
                <div class="form-group">
                    <label><fmt:message key='type'/></label>
                    <select name="type" class="form-control">
                        <c:forEach items="${types}" var="type">
                            <c:choose>
                                <c:when test="${type.id == tour.typeId}">
                                    <option selected value="${type.id}">${type.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${type.id}">${type.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label><fmt:message key='hotel'/>/<a href="/admin/add_hotel">Add new hotel</a></label>
                    <select name="hotel" class="form-control">
                        <c:forEach items="${hotels}" var="hotel">
                            <c:choose>
                                <c:when test="${hotel.id == tour.hotelId}">
                                    <option selected value="${hotel.id}">${hotel.name} - ${hotel.city}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${hotel.id}">${hotel.name} - ${hotel.city}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <label>Continues:</label>

                <div class="form-group input-group">
                        <%--<label class="pre">From:</label>--%>
                    <label class="input-group-addon" style="width: 4em"><fmt:message key='from'/></label>
                    <input type="text" name="start" class="form-control " placeholder="yyyy-mm-dd" required
                           value="${tour.start}">
                </div>
                <div class="form-group input-group">
                        <%--<label>To:</label>--%>
                    <label class="input-group-addon" style="width: 4em"><fmt:message key='to'/></label>
                    <input type="text" name="end" class="form-control " placeholder="yyyy-mm-dd" required
                           value="${tour.end}">
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label><fmt:message key='img'/>:</label>
                        <input type="text" name="img" class="form-control" required value="${tour.img}">
                    </div>
                </div>
                <label><fmt:message key='price'/>:</label>

                <div class="form-group input-group">
                    <input type="number" name="price" class="form-control " placeholder="25000" required
                           value="${tour.price}">
                    <label class="input-group-addon">$</label>
                </div>
                <label><fmt:message key='discount'/>:</label>

                <div class="form-group input-group">
                    <input type="number" name="discount" class="form-control " placeholder="10" required
                           value="${tour.discount}">
                    <label class="input-group-addon">%</label>
                </div>

                <div class="form-group input-group">
                    <label><fmt:message key='description'/></label>
                    <textarea name="description" class="form-control" rows="3"
                              style="margin: 0px -9px 0px 0px; width: 488px; height: 84px;"
                              required>${tour.description}</textarea>
                </div>
                <div class="form-group input-group">
                    <label><fmt:message key='text'/></label>
                    <textarea name="text" class="form-control" rows="3"
                              style="margin: 0px -9px 0px 0px; width: 488px; height: 84px;"
                              required>${tour.text}</textarea>
                </div>
                <div id="success"></div>
                <!-- For success/fail messages -->
                <button type="submit" class="btn btn-primary"><fmt:message key='edit'/></button>
            </form>

        </div>


    </div>
