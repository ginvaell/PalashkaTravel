<jsp:useBean id="tour" scope="request" type="DAO.beans.Tour"/>
<!-- Page Content -->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">
                Item page
                <small>Subheading</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="index.html">Home</a>
                </li>
                <li class="active">One Column Portfolio</li>
            </ol>
        </div>
    </div>

    <div class="row">


    <%--<div class="col-md-3">--%>
        <%--<p class="lead">Shop Name</p>--%>
        <%--<div class="list-group">--%>
            <%--<a href="#" class="list-group-item active">Category 1</a>--%>
            <%--<a href="#" class="list-group-item">Category 2</a>--%>
            <%--<a href="#" class="list-group-item">Category 3</a>--%>
        <%--</div>--%>
    <%--</div>--%>

    <div class="col-md-8">

        <div class="thumbnail">
            <img class="img-responsive" src="http://placehold.it/800x300" alt="">
            <div class="caption-full">
                <%--<h4 class="pull-right">$24.99</h4>--%>
                <h4><a href="#">Product Name</a>
                </h4>
                <p>See more snippets like these online store reviews at <a target="_blank" href="http://bootsnipp.com">Bootsnipp - http://bootsnipp.com</a>.</p>
                <p>Want to make these reviews work? Check out
                    <strong><a href="http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/">this building a review system tutorial</a>
                    </strong>over at maxoffsky.com!</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
            </div>
            <%--<div class="ratings">--%>
                <%--<p class="pull-right">3 reviews</p>--%>
                <%--<p>--%>
                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                    <%--<span class="glyphicon glyphicon-star-empty"></span>--%>
                    <%--4.0 stars--%>
                <%--</p>--%>
            <%--</div>--%>
        </div>

        <%--<div class="well">--%>

            <%--<div class="text-right">--%>
                <%--<a class="btn btn-success">Leave a Review</a>--%>
            <%--</div>--%>

            <%--<hr>--%>

            <%--<div class="row">--%>
                <%--<div class="col-md-12">--%>
                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                    <%--<span class="glyphicon glyphicon-star-empty"></span>--%>
                    <%--Anonymous--%>
                    <%--<span class="pull-right">10 days ago</span>--%>
                    <%--<p>This product was great in terms of quality. I would definitely buy another!</p>--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<hr>--%>

            <%--<div class="row">--%>
                <%--<div class="col-md-12">--%>
                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                    <%--<span class="glyphicon glyphicon-star-empty"></span>--%>
                    <%--Anonymous--%>
                    <%--<span class="pull-right">12 days ago</span>--%>
                    <%--<p>I've alredy ordered another one!</p>--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<hr>--%>

            <%--<div class="row">--%>
                <%--<div class="col-md-12">--%>
                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                    <%--<span class="glyphicon glyphicon-star-empty"></span>--%>
                    <%--Anonymous--%>
                    <%--<span class="pull-right">15 days ago</span>--%>
                    <%--<p>I've seen some better than this, but not at this price. I definitely recommend this item.</p>--%>
                <%--</div>--%>
            <%--</div>--%>

        <%--</div>--%>

    </div>

        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title text-primary">Info: </h3>
                </div>
                <div class="panel-body">
                    <div class="list-group">
                        <div class="list-group-item">
                            <i class="fa fa-comment fa-fw"></i> Start:
                                    <span class="pull-right text-primary small"><em>2015-11-11</em>
                                    </span>
                        </div>
                        <div class="list-group-item">
                            <i class="fa fa-twitter fa-fw"></i> End:
                                    <span class="pull-right text-primary small"><em>2015-11-20</em>
                                    </span>
                        </div>
                        <div class="list-group-item">
                            <i class="fa fa-envelope fa-fw"></i> Hotel
                                    <span class="pull-right text-primary"><em>Super Mega Hotel</em>
                                    </span>
                        </div>
                        <div class="list-group-item">
                            <i class="fa fa-envelope fa-fw"></i> Price
                                    <span class="pull-right text-primary"><em>50$</em>
                                    </span>
                        </div>

                    </div>
                    <!-- /.list-group -->

                </div>
            </div>

        </div>

</div>
