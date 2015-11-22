<jsp:useBean id="editUser" scope="request" type="DAO.beans.User"/>
<div class="container">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><fmt:message key='editUser'/></h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-5">
            <form name="sentMessage" id="contactForm" action="/admin/edit_user" method="post">
                <input name="id" value="${editUser.id}" hidden>
                <input name="login" value="${editUser.login}" hidden>
                <input name="name" value="${editUser.name}" hidden>
                <input name="password" value="${editUser.password}" hidden>
                <c:if test="${user.role.equals('admin')}">
                    <div class="form-group">
                        <label><fmt:message key='role'/></label>
                        <select name="role" class="form-control">
                            <c:choose>
                                <c:when test="${'client'.equals(editUser.role)}">
                                    <option selected value="client">Client</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="client">Client</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${'manager'.equals(editUser.role)}">
                                    <option selected value="manager">Manager</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="manager">Manager</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${'admin'.equals(editUser.role)}">
                                    <option selected value="admin">Admin</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="admin">Admin</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </div>
                </c:if>
                <c:if test="${user.role.equals('manager')}">
                    <input name="role" value="${editUser.role}" hidden>
                </c:if>
                <label><fmt:message key='discount'/>:</label>

                <div class="form-group input-group">
                    <input type="number" name="discount" class="form-control " placeholder="10" required
                           value="${editUser.discount}">
                    <label class="input-group-addon">%</label>
                </div>
                <div id="success"></div>
                <!-- For success/fail messages -->
                <button type="submit" class="btn btn-primary"><fmt:message key='edit'/></button>
            </form>

        </div>


    </div>
