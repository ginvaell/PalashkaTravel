<jsp:useBean id="city" scope="request" type="DAO.beans.City"/>
<div class="container">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><fmt:message key='editCity'/></h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-5">
            <form name="sentMessage" id="contactForm" action="/admin/edit_city" method="post">
                <input name="id" value="${city.id}" hidden>
                <div class="control-group form-group">
                    <div class="controls">
                        <label><fmt:message key='name'/>city:</label>
                        <input type="text" name="city" class="form-control" id="name" required
                               data-validation-required-message="Please enter your name." value="${city.city}">

                        <p class="help-block"></p>
                    </div>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label><fmt:message key='country'/>:</label>
                        <input type="text" name="country" class="form-control" required
                               data-validation-required-message="Please enter your name." value="${city.country}">

                        <p class="help-block"></p>
                    </div>
                </div>

                <div id="success"></div>
                <!-- For success/fail messages -->
                <button type="submit" class="btn btn-primary"><fmt:message key='edit'/></button>
            </form>

        </div>



    </div>
