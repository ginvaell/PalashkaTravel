<jsp:useBean id="purchases" scope="request" type="java.util.List<DAO.beans.Purchase>"/>
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


    <div class="col-md-8">

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <fmt:message key='purchase.title'/>
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <div id="dataTables-example_wrapper"
                                 class="dataTables_wrapper form-inline dt-bootstrap no-footer">

                                <div class="row">
                                    <div class="col-sm-12">
                                        <table class="table table-striped table-bordered table-hover"
                                               id="dataTables-example" role="grid"
                                               aria-describedby="dataTables-example_info">
                                            <thead>
                                            <tr role="row">
                                                <th class="sorting" tabindex="0" aria-controls="dataTables-example"
                                                    rowspan="1" colspan="1"
                                                    aria-label="Rendering engine: activate to sort column ascending"
                                                    style="width: 172px;"><fmt:message key='tour'/>
                                                </th>
                                                <th class="sorting_desc" tabindex="0" aria-controls="dataTables-example"
                                                    rowspan="1" colspan="1"
                                                    aria-label="Browser: activate to sort column ascending"
                                                    style="width: 204px;" aria-sort="descending"><fmt:message key='purchase.date'/>
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="dataTables-example"
                                                    rowspan="1" colspan="1"
                                                    aria-label="Engine version: activate to sort column ascending"
                                                    style="width: 149px;"><fmt:message key='amount'/>
                                                </th>
                                                <th class="sorting" tabindex="0" aria-controls="dataTables-example"
                                                    rowspan="1" colspan="1"
                                                    aria-label="CSS grade: activate to sort column ascending"
                                                    style="width: 110px;"><fmt:message key='price'/>
                                                </th>
                                            </tr>
                                            </thead>
                                            <tbody>

                                            <c:forEach items="${purchases}" var="purchase">
                                                <tr class="gradeA odd" role="row">
                                                    <td class=""><a href="/item?id=${purchase.tourId}"><c:out value="${purchase.tour}"/></a></td>
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


    </div>

    <div class="col-md-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title text-primary"><fmt:message key='user.info'/>: </h3>
            </div>
            <div class="panel-body">
                <div class="list-group">
                    <div class="list-group-item">
                        <i class="fa fa-comment fa-fw"></i> <fmt:message key='login'/>:
                                    <span class="pull-right text-primary small"><em><c:out value="${user.login}"/></em>
                                    </span>
                    </div>
                    <div class="list-group-item">
                        <i class="fa fa-comment fa-fw"></i> <fmt:message key='name'/>:
                                    <span class="pull-right text-primary small"><em><c:out value="${user.name}"/></em>
                                    </span>
                    </div>
                    <c:choose>
                        <c:when test="${user.discount > 0}">
                            <div class="list-group-item">
                                <i class="fa fa-comment fa-fw"></i> <fmt:message key='status'/>:
                                    <span class="pull-right text-primary small"><em>VIP</em>
                                    </span>
                            </div>
                            <div class="list-group-item">
                                <i class="fa fa-twitter fa-fw"></i> <fmt:message key='discount'/>:
                                    <span class="pull-right text-primary small"><em><c:out
                                            value="${user.discount}"/>%</em>
                                    </span>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="list-group-item">
                                <i class="fa fa-comment fa-fw"></i> <fmt:message key='status'/>:
                                    <span class="pull-right text-primary small"><em><fmt:message key='plain'/></em>
                                    </span>
                            </div>
                        </c:otherwise>
                    </c:choose>

                </div>
                <!-- /.list-group -->
                <div class="list-group">
                    <a href="/user_edit">
                        <button type="button" class="btn btn-primary"><fmt:message key='edit'/></button>
                    </a>
                </div>


            </div>
        </div>

    </div>

</div>
