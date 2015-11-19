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


    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">

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
            <%--<div class="col-md-7">--%>
            <%--<a href="portfolio-item.html">--%>
            <%--<img class="img-responsive img-hover" src="http://placehold.it/700x300" alt="">--%>
            <%--</a>--%>
            <%--</div>--%>
            <%--<div class="col-md-5">--%>
            <%--<h3><c:out value="${tour.name}" /> </h3>--%>
            <%--<h4><c:out value="${tour.type}" /></h4>--%>

            <%--<p><c:out value="${tour.description}" /></p>--%>
            <%--<a class="btn btn-primary" href="/item?id=${tour.id}"><i>View Project</i></a>--%>
            <%--</div>--%>

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


