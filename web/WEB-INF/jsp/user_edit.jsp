
<div class="container">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><fmt:message key='user.edit'/></h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-5">
            <h3><fmt:message key='register.aboutYou'/></h3>

            <form name="sentMessage" id="contactForm" action="/user_edit" method="post">
                <div class="control-group form-group">
                    <div class="controls">
                        <label><fmt:message key='name'/></label>
                        <input name="name" type="text" class="form-control" id="name" required
                               data-validation-required-message="Please enter your name." value="${user.name}">

                        <p class="help-block"></p>
                    </div>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label><fmt:message key='password'/>:</label>
                        <input type="password" name="password" class="form-control" id="password" required
                               data-validation-required-message="Please enter your email address." value="${user.password}">
                    </div>
                </div>
                <div id="success"></div>
                <!-- For success/fail messages -->
                <button type="submit" class="btn btn-primary"><fmt:message key='edit'/></button>
            </form>

        </div>



    </div>
