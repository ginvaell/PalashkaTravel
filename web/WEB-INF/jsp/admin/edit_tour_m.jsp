<jsp:useBean id="discount" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="id" scope="request" type="java.lang.Integer"/>


<div class="container">

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><fmt:message key='editTour'/></h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-5">
            <form name="sentMessage" id="contactForm" action="/admin/edit_tour_m" method="post">
                <input name="id" value="${id}" hidden>
                <label><fmt:message key='discount'/>:</label>
                <div class="form-group input-group">
                    <input type="number" name="discount" class="form-control " placeholder="10" required
                           value="${discount}">
                    <label class="input-group-addon">%</label>
                </div>
                <div id="success"></div>
                <!-- For success/fail messages -->
                <button type="submit" class="btn btn-primary"><fmt:message key='edit'/></button>
            </form>

        </div>


    </div>
