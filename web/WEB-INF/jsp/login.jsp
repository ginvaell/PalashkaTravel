<div class="container">


    <form action="j_security_check" class="form-signin">
        <h2 class="form-signin-heading text-primary"><fmt:message key='signIn'/>/ <a href="/registration" class="text-muted"> <fmt:message key='register'/></a></h2>
        <label for="inputEmail" class="sr-only"><fmt:message key='login'/></label>
        <input name="j_username" type="text" id="inputEmail" class="form-control" placeholder="Login" required autofocus>
        <label for="inputPassword" class="sr-only"><fmt:message key='password'/></label>
        <input name="j_password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key='signIn'/></button>
    </form>
