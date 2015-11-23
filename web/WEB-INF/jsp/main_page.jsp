<%--<fmt:setLocale value="en" scope="session" />--%>
<%--<fmt:setBundle basename="resources.messages" var="label" scope="session" />--%>
<!-- Header Carousel -->
<jsp:useBean id="tours" scope="request" type="java.util.List<DAO.beans.Tour>"/>
</div>
<header id="myCarousel" class="carousel slide">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
        <div class="item active">
            <div class="fill"
                 style="background-image:url('/img/pages/anywalls.com-62766.jpg');"></div>
            <div class="carousel-caption">
                <h2>Caption 1</h2>
            </div>
        </div>
        <div class="item">
            <div class="fill"
                 style="background-image:url('/img/pages/look.com.ua-29982.jpg');"></div>
            <div class="carousel-caption">
                <h2>Caption 2</h2>
            </div>
        </div>
        <div class="item">
            <div class="fill"
                 style="background-image:url('/img/pages/fonstola.ru-163517.jpg');"></div>
            <div class="carousel-caption">
                <h2>Caption 3</h2>
            </div>
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
        <span class="icon-prev"></span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
        <span class="icon-next"></span>
    </a>
</header>

<!-- Page Content -->
<div class="container">


    <hr>
    <!-- /.row -->
    <div class="row">
        <c:forEach items="${tours}" var="tour" varStatus="status">
        <!-- Project One -->

        <%--<c:if test="${status.index % 3 == 0 && status.index != 0}">--%>
    <%--</div>--%>
    <%--<div class="row">--%>
        <%--</c:if>--%>
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
                        <fmt:message key='start'/>:
                    </p>
                </div>
            </div>
        </div>

        </c:forEach>
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


