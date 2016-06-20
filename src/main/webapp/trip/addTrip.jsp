<form>
  <div class="form-group">
    <label for="exampleInputEmail1">Depature Date</label>
    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Date">
  </div>
   <div class="form-group">
    <label for="exampleInputEmail1">Arrival Date</label>
    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Date">
  </div>
   <div class="form-group">
  <label for="sel1">Select route:</label>
  <select class="form-control" id="sel1">
   <option>---select routes---</option>
    <option>NAIROBI - MOMBASA</option>
    <option>MAMBASA - NAIROBI</option>
    <option>NAIROBI - NAKURU</option>
  </select>
</div>
  <div class="form-group">
  <label for="sel1">Select Vehicle:</label>
  <select class="form-control" id="sel1">
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
      <input type="text" class="form-control" id="exampleInputAmount" placeholder="Amount">
      <div class="input-group-addon">.00</div>
    </div>
  </div>
 
  <div class="checkbox">
    <label>
      <input type="checkbox">Keep History
    </label>
  </div>
  <button type="submit" class="btn btn-success">Create</button>
</form>