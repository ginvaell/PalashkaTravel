<jsp:useBean id="hotels" scope="request" type="java.util.List<DAO.beans.Hotel>"/>
<jsp:useBean id="types" scope="request" type="java.util.List<DAO.beans.Type>"/>
<div class="container">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><fmt:message key='addTour'/></h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-5">
            <form name="sentMessage" id="contactForm" action="/admin/add_tour" method="post">
                <div class="control-group form-group">
                    <div class="controls">
                        <label><fmt:message key='name'/>:</label>
                        <input type="text" name="name" class="form-control" id="name" required
                               data-validation-required-message="Please enter your name.">

                        <p class="help-block"></p>
                    </div>
                </div>
                <div class="form-group">
                    <label><fmt:message key='type'/></label>
                    <select name="type" class="form-control">
                        <c:forEach items="${types}" var="type">
                            <option value="${type.id}">${type.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label><fmt:message key='hotel'/>/<a href="/admin/add_hotel"><fmt:message key='addHotel'/></a></label>
                    <select name="hotel" class="form-control">
                        <c:forEach items="${hotels}" var="hotel">
                            <option value="${hotel.id}">${hotel.name} - ${hotel.city}</option>
                        </c:forEach>
                    </select>
                </div>
                <label><fmt:message key='continues'/>:</label>

                <div class="form-group input-group">
                    <%--<label class="pre">From:</label>--%>
                    <label class="input-group-addon" style="width: 4em"><fmt:message key='from'/></label>
                    <input type="text" name="start" class="form-control " placeholder=<fmt:message key='datePlaceholder'/> required>
                </div>
                <div class="form-group input-group">
                    <%--<label>To:</label>--%>
                    <label class="input-group-addon" style="width: 4em"><fmt:message key='to'/></label>
                    <input type="text" name="end" class="form-control " placeholder=<fmt:message key='datePlaceholder'/> required>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label><fmt:message key='img'/>:</label>
                        <input type="text" name="img" class="form-control" required>
                    </div>
                </div>
                <label><fmt:message key='price'/>:</label>
                <div class="form-group input-group">
                    <input type="number" name="price" class="form-control " placeholder="25000" required>
                    <label class="input-group-addon">$</label>
                </div>
                <label><fmt:message key='discount'/>:</label>
                <div class="form-group input-group">
                    <input type="number" name="discount" class="form-control " placeholder="10" required>
                    <label class="input-group-addon">%</label>
                </div>
                <div class="form-group input-group">
                    <label><fmt:message key='description'/>:</label>
                    <textarea name="description" class="form-control" rows="3" style="margin: 0px -9px 0px 0px; width: 488px; height: 84px;" required></textarea>
                </div>
                <div class="form-group input-group">
                    <label><fmt:message key='text'/>:</label>
                    <textarea name="text" class="form-control" rows="3" style="margin: 0px -9px 0px 0px; width: 488px; height: 84px;" required></textarea>
                </div>
                <div id="success"></div>
                <!-- For success/fail messages -->
                <button type="submit" class="btn btn-primary"><fmt:message key='add'/></button>
            </form>

        </div>



    </div>
