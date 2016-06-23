<h4>Step 3: Fill your personal Details </h4><hr>
<form method="post" action="completebooking">
  <div class="form-group">
    <label for="idNumber">National Id</label>
    <input type="text" class="form-control" id="idNumber" name="idNumber" placeholder="Id Number">
  </div>
  <div class="form-group">
    <label for="name">Name</label>
    <input type="text" class="form-control" id="name" name="name" placeholder="Full Name">
  </div>
  <div class="form-group">
    <label for="phone">Cell Phone</label>
    <input type="text" class="form-control" id="phone" name="phone" placeholder="Phone Number">
  </div>
  <div class="form-group">
    <label for="phone">Trip Id</label>
    <input type="text" class="form-control" id="tripId" value="45" name="tripId" readonly="readonly" placeholder="Trip Id(Will be autofilled)">
  </div>
  <button type="submit" class="btn btn-default" onClick="completeBooking()">Complete Booking</button>
</form>