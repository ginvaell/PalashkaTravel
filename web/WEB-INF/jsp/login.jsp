<div class="container">


    <form action="j_security_check" class="form-signin">
        <h2 class="form-signin-heading text-primary">Sign in <a href="/registration" class="text-muted">/ Register</a></h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input name="j_username" type="text" id="inputEmail" class="form-control" placeholder="Login" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input name="j_password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>

        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
