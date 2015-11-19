<jsp:useBean id="user" scope="request" type="DAO.beans.User"/>

<div class="container">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Registration Form</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-5">
            <h3>About you</h3>

            <form name="sentMessage" id="contactForm" action="/user_edit" method="post">
                <div class="control-group form-group">
                    <div class="controls">
                        <label>Name</label>
                        <input name="name" type="text" class="form-control" id="name" required
                               data-validation-required-message="Please enter your name." value="${user.name}">

                        <p class="help-block"></p>
                    </div>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label>Password:</label>
                        <input type="password" name="password" class="form-control" id="password" required
                               data-validation-required-message="Please enter your email address." value="${user.password}">
                    </div>
                </div>
                <div id="success"></div>
                <!-- For success/fail messages -->
                <button type="submit" class="btn btn-primary">Ok</button>
            </form>

        </div>



    </div>
