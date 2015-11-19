<jsp:useBean id="tour" scope="request" type="DAO.beans.Tour"/>
<jsp:useBean id="user" scope="request" type="DAO.beans.User"/>

<div class="container">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Buying</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-5">
            <h3>How many tours do you want to buy?</h3>

            <form name="sentMessage" id="contactForm" action="/buy" method="post">
                <div class="control-group form-group">
                    <div class="controls">
                        <label>count</label>
                        <input name="count" type="number" class="form-control" id="count" required
                               data-validation-required-message="Please enter your name." value="1">

                        <p class="help-block"></p>
                    </div>
                </div>

                <input type="number" name="price" value="${tour.price}" hidden>
                <input type="number" name="tourId" value="${tour.id}" hidden>

                <div id="success"></div>
                <!-- For success/fail messages -->
                <button type="submit" class="btn btn-primary">Buy</button>
            </form>

        </div>


    </div>
