<jsp:useBean id="hotels" scope="request" type="java.util.List<DAO.beans.Hotel>"/>
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


    <div class="col-md-9">

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <fmt:message key='hotels'/>/<a href="/admin/add_hotel"><fmt:message key='addNew'/></a>
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
                                                <th ><fmt:message key='name'/></th>
                                                <th><fmt:message key='city'/></th>
                                                <th><fmt:message key='country'/></th>
                                                <th><fmt:message key='edit'/></th>
                                            </tr>
                                            </thead>
                                            <tbody>

                                            <c:forEach items="${hotels}" var="hotel">
                                                <tr class="gradeA odd" role="row">
                                                    <td><c:out value="${hotel.name}"/></td>
                                                    <td><c:out value="${hotel.city}"/></td>
                                                    <td><c:out value="${hotel.country}"/></td>
                                                    <td class="text-center">
                                                        <a class="btn btn-default " href="/admin/edit_hotel?id=${hotel.id}"><span class="glyphicon glyphicon-edit"></span></a>
                                                        <a class="btn btn-primary " href="/admin/delete_hotel?id=${hotel.id}"><span class="glyphicon glyphicon-remove"></span></a>
                                                    </td>
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

    <%@include file="menu.jsp"%>

</div>
