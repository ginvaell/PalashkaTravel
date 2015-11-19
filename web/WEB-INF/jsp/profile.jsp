<jsp:useBean id="purchases" scope="request" type="java.util.List<DAO.beans.Purchase>"/>
<jsp:useBean id="user" scope="request" type="DAO.beans.User"/>
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

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        My Purchases
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <div id="dataTables-example_wrapper"
                                 class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="dataTables_length" id="dataTables-example_length"><label>Show
                                            <select name="dataTables-example_length" aria-controls="dataTables-example"
                                                    class="form-control input-sm">
                                                <option value="10">10</option>
                                                <option value="25">25</option>
                                                <option value="50">50</option>
                                                <option value="100">100</option>
                                            </select> entries</label></div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div id="dataTables-example_filter" class="dataTables_filter">
                                            <label>Search:<input type="search" class="form-control input-sm"
                                                                 placeholder=""
                                                                 aria-controls="dataTables-example"></label></div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <table class="table table-striped table-bordered table-hover dataTable no-footer"
                                               id="dataTables-example" role="grid"
                                               aria-describedby="dataTables-example_info">
                                            <thead>
                                            <tr role="row">
                                                <th class="sorting" tabindex="0" aria-controls="dataTables-example"
                                                    rowspan="1" colspan="1"
                                                    aria-label="Rendering engine: activate to sort column ascending"
                                                    style="width: 172px;">Tour
                                                </th>
                                                <th class="sorting_desc" tabindex="0" aria-controls="dataTables-example"
                                                    rowspan="1" colspan="1"
                                                    aria-label="Browser: activate to sort column ascending"
                                                    style="width: 204px;" aria-sort="descending">Purchase date
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="dataTables-example"
                                                    rowspan="1" colspan="1"
                                                    aria-label="Engine version: activate to sort column ascending"
                                                    style="width: 149px;">Amount
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="dataTables-example"
                                                    rowspan="1" colspan="1"
                                                    aria-label="CSS grade: activate to sort column ascending"
                                                    style="width: 110px;">Price
                                                </th>
                                            </tr>
                                            </thead>
                                            <tbody>

                                            <c:forEach items="${purchases}" var="purchase">
                                                <tr class="gradeA odd" role="row">
                                                    <td class=""><c:out value="${purchase.tour}"/></td>
                                                    <td class="sorting_1"><c:out value="${purchase.date}"/></td>
                                                    <td class=""><c:out value="${purchase.count}"/></td>
                                                    <td class="center"><c:out value="${purchase.price}"/>$</td>
                                                </tr>
                                            </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="dataTables_info" id="dataTables-example_info" role="status"
                                             aria-live="polite">Showing 1 to 10 of 57 entries
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="dataTables_paginate paging_simple_numbers"
                                             id="dataTables-example_paginate">
                                            <ul class="pagination">
                                                <li class="paginate_button previous disabled"
                                                    aria-controls="dataTables-example" tabindex="0"
                                                    id="dataTables-example_previous"><a href="#">Previous</a></li>
                                                <li class="paginate_button active" aria-controls="dataTables-example"
                                                    tabindex="0"><a href="#">1</a></li>
                                                <li class="paginate_button " aria-controls="dataTables-example"
                                                    tabindex="0"><a href="#">2</a></li>
                                                <li class="paginate_button " aria-controls="dataTables-example"
                                                    tabindex="0"><a href="#">3</a></li>
                                                <li class="paginate_button " aria-controls="dataTables-example"
                                                    tabindex="0"><a href="#">4</a></li>
                                                <li class="paginate_button " aria-controls="dataTables-example"
                                                    tabindex="0"><a href="#">5</a></li>
                                                <li class="paginate_button " aria-controls="dataTables-example"
                                                    tabindex="0"><a href="#">6</a></li>
                                                <li class="paginate_button next" aria-controls="dataTables-example"
                                                    tabindex="0" id="dataTables-example_next"><a href="#">Next</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.table-responsive -->

                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
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
        <%--<p>I've seen some better than this, but not at this price. I def4initely recommend this item.</p>--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--</div>--%>

    </div>

    <div class="col-md-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title text-primary">User info: </h3>
            </div>
            <div class="panel-body">
                <div class="list-group">
                    <div class="list-group-item">
                        <i class="fa fa-comment fa-fw"></i> Login:
                                    <span class="pull-right text-primary small"><em><c:out value="${user.login}"/></em>
                                    </span>
                    </div>
                    <div class="list-group-item">
                        <i class="fa fa-comment fa-fw"></i> Name:
                                    <span class="pull-right text-primary small"><em><c:out value="${user.name}"/></em>
                                    </span>
                    </div>
                    <c:choose>
                        <c:when test="${user.discount > 0}">
                            <div class="list-group-item">
                                <i class="fa fa-comment fa-fw"></i> Status:
                                    <span class="pull-right text-primary small"><em>VIP</em>
                                    </span>
                            </div>
                            <div class="list-group-item">
                                <i class="fa fa-twitter fa-fw"></i> Discount:
                                    <span class="pull-right text-primary small"><em><c:out
                                            value="${user.discount}"/>%</em>
                                    </span>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="list-group-item">
                                <i class="fa fa-comment fa-fw"></i> Status:
                                    <span class="pull-right text-primary small"><em>PLAIN</em>
                                    </span>
                            </div>
                        </c:otherwise>
                    </c:choose>

                </div>
                <!-- /.list-group -->
                <div class="list-group">
                    <a href="/user_edit">
                        <button type="button" class="btn btn-primary">Edit</button>
                    </a>
                </div>


            </div>
        </div>

    </div>

</div>
