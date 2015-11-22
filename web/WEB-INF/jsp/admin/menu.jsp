<%--
  Created by IntelliJ IDEA.
  User: ginva_000
  Date: 22.11.2015
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<div class="col-md-3">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title text-primary"><fmt:message key='menu'/> </h3>
        </div>
        <div class="panel-body">
            <div class="list-group">
                <div class="list-group-item">
                    <a href="/admin/tours" class="text-muted" style="font-size: medium">
                        <span class="glyphicon glyphicon-plane" style="margin-right: 2px"></span> <fmt:message key='tours'/>
                    </a>

                </div>
                <div class="list-group-item">
                    <a href="/admin/users" class="text-muted" style="font-size: medium">
                        <span class="glyphicon glyphicon-user" style="margin-right: 2px"></span> <fmt:message key='users'/>
                    </a>

                </div>

                <c:if test="${user.role.equals('admin')}">
                    <div class="list-group-item">
                        <a href="/admin/hotels" class="text-muted" style="font-size: medium">
                            <span class="glyphicon glyphicon-home" style="margin-right: 2px"></span> <fmt:message key='hotels'/>
                        </a>

                    </div>
                    <div class="list-group-item">
                        <a href="/admin/cities" class="text-muted" style="font-size: medium">
                            <span class="glyphicon glyphicon-globe" style="margin-right: 2px"></span> <fmt:message key='cities'/>
                        </a>

                    </div>
                </c:if>



            </div>
            <!-- /.list-group -->



        </div>
    </div>

</div>