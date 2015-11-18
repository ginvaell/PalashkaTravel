<div class="container">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Registration Form</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-5">
            <h3>About you</h3>

            <form name="sentMessage" id="contactForm">
                <div class="control-group form-group">
                    <div class="controls">
                        <label>Name</label>
                        <input type="text" class="form-control" id="name" required
                               data-validation-required-message="Please enter your name.">

                        <p class="help-block"></p>
                    </div>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label>Login</label>
                        <input type="tel" class="form-control" id="phone" required
                               data-validation-required-message="Please enter your phone number.">
                    </div>
                </div>
                <div class="control-group form-group">
                    <div class="controls">
                        <label>Password:</label>
                        <input type="password" class="form-control" id="password" required
                               data-validation-required-message="Please enter your email address.">
                    </div>
                </div>
                <div id="success"></div>
                <!-- For success/fail messages -->
                <button type="submit" class="btn btn-primary">Register</button>
            </form>

        </div>



    </div>