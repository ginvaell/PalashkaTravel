<div class="container">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><fmt:message key='register'/></h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-5">
            <h3><fmt:message key='register.aboutYou'/></h3>

            <form name="sentMessage" id="contactForm" action="/registration" method="post">
                <div class="control-group form-group">
                    <div class="controls">
                        <label><fmt:message key='login'/>:</label>
                        <input type="tel" name="login" class="form-control" id="phone" required
                               data-validation-required-message="Please enter your phone number.">
                    </div>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label><fmt:message key='name'/>:</label>
                        <input type="text" name="name" class="form-control" id="name" required
                               data-validation-required-message="Please enter your name.">

                        <p class="help-block"></p>
                    </div>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label><fmt:message key='password'/>:</label>
                        <input type="password" name="password" class="form-control" id="password" required
                               data-validation-required-message="Please enter your email address.">
                    </div>
                </div>
                <div id="success"></div>
                <!-- For success/fail messages -->
                <button type="submit" class="btn btn-primary"><fmt:message key='register'/></button>
            </form>

        </div>



    </div>
