<%--<fmt:setLocale value="en" scope="session" />--%>
<%--<fmt:setBundle basename="resources.messages" var="label" scope="session" />--%>
<!-- Header Carousel -->
<jsp:useBean id="tours" scope="request" type="java.util.List<DAO.beans.Tour>"/>
<jsp:useBean id="hotels" scope="request" type="java.util.List<DAO.beans.Hotel>"/>
<jsp:useBean id="types" scope="request" type="java.util.List<DAO.beans.Type>"/>
<jsp:useBean id="cities" scope="request" type="java.util.List<DAO.beans.City>"/>


<!-- Page Heading/Breadcrumbs -->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Tours
            <small>Subheading</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="index.html">Home</a>
            </li>
            <li class="active">One Column Portfolio</li>
        </ol>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="col-md-9">
        <div class="row">
            <c:forEach items="${tours}" var="tour" varStatus="status">
            <!-- Project One -->

            <c:if test="${status.index % 3 == 0 && status.index != 0}">
        </div>
        <div class="row">
            </c:if>
            <div class="col-sm-4 col-lg-4 col-md-4">
                <div class="thumbnail">
                    <img src="/img/tours/${tour.img}" alt="">

                    <div class="caption">
                        <h4 class="pull-right"><c:out value="${tour.price}"/> $</h4>
                        <h4><a href="/item?id=${tour.id}"><c:out value="${tour.name}"/></a>
                        </h4>

                        <p><c:out value="${tour.description}"/></p>
                    </div>
                    <div class="ratings">
                        <p class="pull-right"><c:out value="${tour.start}"/></p>

                        <p>
                            Starts:
                        </p>
                    </div>
                </div>
            </div>


            </c:forEach>
        </div>
    </div>
    <div class="col-md-3 well">
        <%--<h3 class="text-primary first-titled-pane">Filter</h3>--%>
        <%--<hr>--%>
        <form action="/tours" role="form" method="get">
            <div class="form-group">
                <label>Name of tour:</label>
                <input type="text" name="name" class="form-control" placeholder="Text">
            </div>
            <div class="form-group">
                <label>City</label>
                <select name="city" class="form-control">
                    <option value="-1">ALL</option>
                    <c:forEach items="${cities}" var="city">
                        <option value="${city.id}">${city.city} - ${city.country}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>Type</label>
                <select name="type" class="form-control">
                    <option value="-1">ALL</option>
                    <c:forEach items="${types}" var="type">
                        <option value="${type.id}">${type.name}</option>
                    </c:forEach>
                </select>
            </div>
            <label>Price:</label>

            <div class="form-group input-group">
                <%--<label class="pre">From:</label>--%>
                <label class="input-group-addon" style="width: 4em">from</label>
                <input type="number" name="priceOver" class="form-control " placeholder="25000" >
                <label class="input-group-addon">$</label>
            </div>
            <div class="form-group input-group">
                <%--<label>To:</label>--%>
                <label class="input-group-addon" style="width: 4em">&nbsp to &nbsp</label>
                <input type="number" name="priceUnder" class="form-control " placeholder="25000">
                <label class="input-group-addon">$</label>
            </div>
            <label>Continues:</label>

            <div class="form-group input-group">
                <%--<label class="pre">From:</label>--%>
                <label class="input-group-addon" style="width: 4em">from</label>
                <input type="text" name="dateOver" class="form-control " placeholder="yyyy-mm-dd">
            </div>
            <div class="form-group input-group">
                <%--<label>To:</label>--%>
                <label class="input-group-addon" style="width: 4em">&nbsp to &nbsp</label>
                <input type="text" name="dateUnder" class="form-control " placeholder="yyyy-mm-dd">
            </div>

            <div class="form-group">
                <label>Hotel</label>
                <select name="hotel" class="form-control">
                    <option value="-1">ALL</option>
                    <c:forEach items="${hotels}" var="hotel">
                        <option value="${hotel.id}">${hotel.name} - ${hotel.city}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
    </div>


</div>
</div>


<!-- /.row -->
<hr>
<!-- Pagination -->
<div class="row text-center">
    <div class="col-lg-12">
        <ul class="pagination">
            <li>
                <a href="#">&laquo;</a>
            </li>
            <li class="active">
                <a href="#">1</a>
            </li>
            <li>
                <a href="#">2</a>
            </li>
            <li>
                <a href="#">3</a>
            </li>
            <li>
                <a href="#">4</a>
            </li>
            <li>
                <a href="#">5</a>
            </li>
            <li>
                <a href="#">&raquo;</a>
            </li>
        </ul>
    </div>
</div>
<!-- /.row -->

<hr>


