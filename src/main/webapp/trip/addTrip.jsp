<form method="post" action="./trips/action">
  <div class="form-group">
    <label>Depature Date</label>
    <input name="depatureDate" required="required" type="text" class="form-control" id="depatureDate" placeholder="Date">
  </div>
   <div class="form-group">
    <label>Arrival Date</label>
    <input name="arrivalDate" type="text" class="form-control" id="arrivalDate" placeholder="Date">
  </div>
   <div class="form-group">
  <label for="sel1">Select route:</label>
  <select name="route" class="form-control" id="route">
   <option>---select routes---</option>
    <option>NAIROBI - MOMBASA</option>
    <option>MAMBASA - NAIROBI</option>
    <option>NAIROBI - NAKURU</option>
  </select>
</div>
  <div class="form-group">
  <label for="sel1">Select Vehicle:</label>
  <select name="vehicle" class="form-control" id="vehicle">
  <option>---select vehicle---</option>
    <option>KCE 333F</option>
    <option>KCE 333F</option>
    <option>KCE 333F</option>
  </select>
</div>
 
  <div class="form-group">
    <label class="sr-only" for="exampleInputAmount">Price (in KSH)</label>
    <div class="input-group">
      <div class="input-group-addon">$</div>
      <input name="price" type="text" class="form-control" id="price" placeholder="Amount">
      <div class="input-group-addon">.00</div>
    </div>
  </div>
  
</form>
 <a class="btn btn-success" onclick="trip.save()">Create</a>