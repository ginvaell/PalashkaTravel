<jsp:useBean id="tour" scope="request" type="DAO.beans.Tour"/>
<jsp:useBean id="user" scope="request" type="DAO.beans.User"/>
<!-- Page Content -->

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            <c:out value="${tour.name}"/>
            <small><c:out value="${tour.type}"/></small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="index.html">Home</a>
            </li>
            <li class="active">One Column Portfolio</li>
        </ol>
    </div>
</div>

<div class="row">


    <div class="col-md-8">

        <div class="thumbnail">
            <img class="img-responsive" src="/img/tours/${tour.img}" alt="">

            <div class="caption-full">
                <%--<h4 class="pull-right">$24.99</h4>--%>
                <%--<h4><a href="#">Product Name</a>--%>
                </h4>
                <p><c:out value="${tour.text}"/></p>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquam asperiores aut blanditiis corporis cupiditate deleniti dolorem eveniet excepturi exercitationem in incidunt nesciunt nobis odit praesentium quaerat reiciendis sint velit, veniam.</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquam asperiores aut blanditiis corporis cupiditate deleniti dolorem eveniet excepturi exercitationem in incidunt nesciunt nobis odit praesentium quaerat reiciendis sint velit, veniam.</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquam asperiores aut blanditiis corporis cupiditate deleniti dolorem eveniet excepturi exercitationem in incidunt nesciunt nobis odit praesentium quaerat reiciendis sint velit, veniam.</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquam asperiores aut blanditiis corporis cupiditate deleniti dolorem eveniet excepturi exercitationem in incidunt nesciunt nobis odit praesentium quaerat reiciendis sint velit, veniam.</p>
            </div>


        </div>
    </div>

    <div class="col-md-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title text-primary">Info: </h3>
            </div>
            <div class="panel-body">
                <div class="list-group">
                    <div class="list-group-item">
                        <i class="fa fa-comment fa-fw"></i> Country:
                                    <span class="pull-right text-primary small"><em><c:out
                                            value="${tour.country}"/></em>
                                    </span>
                    </div>
                    <div class="list-group-item">
                        <i class="fa fa-comment fa-fw"></i> City:
                                    <span class="pull-right text-primary small"><em><c:out value="${tour.city}"/></em>
                                    </span>
                    </div>
                    <div class="list-group-item">
                        <i class="fa fa-comment fa-fw"></i> Start:
                                    <span class="pull-right text-primary small"><em><c:out value="${tour.start}"/></em>
                                    </span>
                    </div>
                    <div class="list-group-item">
                        <i class="fa fa-twitter fa-fw"></i> End:
                                    <span class="pull-right text-primary small"><em><c:out value="${tour.end}"/></em>
                                    </span>
                    </div>
                    <div class="list-group-item">
                        <i class="fa fa-envelope fa-fw"></i> Hotel:
                                    <span class="pull-right text-primary"><em><c:out value="${tour.hotel}"/></em>
                                    </span>
                    </div>
                    <div class="list-group-item">
                        <i class="fa fa-envelope fa-fw"></i> Price:
                                    <span class="pull-right text-primary"><em><c:out value="${tour.price}"/>$</em>
                                    </span>
                    </div>

                </div>
                <!-- /.list-group -->
                <div class="list-group">
                    <a href="/buy?id=${tour.id}">
                        <button type="button" class="btn btn-primary">Buy</button>
                    </a>
                </div>

            </div>
        </div>

    </div>

</div>

