<h4>New End location </h4><hr>
<form>
  <div class="form-group">
    <label for="idNumber">Location Number</label>
    <input type="text" class="form-control" id="loc_Id" name="locNo" placeholder="Location Id" required>
  </div>
  <div class="form-group">
    <label for="name">Location Name</label>
    <input type="text" class="form-control" id="loc_Name" name="name" placeholder="location Name" required>
  </div>
  
  <div class="form-group">
   <label for="name">Location Description</label>
    <input type="text" class="form-control" id="loc_Descr" name="Descr" placeholder="location Descripiton" required>
  </div>
  
</form>
<button class="btn btn-large btn-success" id="submit"  onclick="tripLocation.save()">  Submit</button>
