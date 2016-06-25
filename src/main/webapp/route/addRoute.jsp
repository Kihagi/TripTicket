<h4>Enter Details here </h4><hr>
<form >
  <div class="form-group">
    <label for="routeFrom">FROM :</label>
    <input type="text" class="form-control" id="from-location" name="fromLocationId" placeholder="FROM" required>
  </div>
  <div class="form-group">
    <label for="routeTo">TO :</label>
    <input type="text" class="form-control" id="to-location" name="toLocationId" placeholder="TO" required>
  </div>
  
  <div class="form-group">
   <label for="routeDistance">DISTANCE</label>
    <input type="text" class="form-control" id="route-distance" name="distance" placeholder="DISTANCE" required>
  </div>
  
  <div class="form-group">
   <label for="routeTme">TIME TAKEN :</label>
    <input type="text" class="form-control" id="route-time" name="ApproxTime" placeholder="TIME TAKEN" required>
  </div>
  
  <div class="form-group">
  
   <label for="routeCompany">COMPANY :</label>
    <input type="text" class="form-control" id="route-company" name="companyId" placeholder="COMPANY" required>
  </div>
  
  
</form>
<a class="btn btn-success"  onclick="route.save()">Save</a>