<%--<jsp:useBean id="cities" scope="request" type="java.util.List<DAO.beans.City>"/>--%>
<div class="container">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><fmt:message key='addCity'/></h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-5">
            <form name="sentMessage" id="contactForm" action="/admin/add_city" method="post">
                <div class="control-group form-group">
                    <div class="controls">
                        <label><fmt:message key='city'/>:</label>
                        <input type="text" name="city" class="form-control" id="name" required
                               data-validation-required-message="Please enter your name.">

                        <p class="help-block"></p>
                    </div>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label><fmt:message key='country'/>:</label>
                        <input type="text" name="country" class="form-control" required
                               data-validation-required-message="Please enter your name.">

                        <p class="help-block"></p>
                    </div>
                </div>

                <div id="success"></div>
                <!-- For success/fail messages -->
                <button type="submit" class="btn btn-primary"><fmt:message key='add'/></button>
            </form>

        </div>



    </div>
