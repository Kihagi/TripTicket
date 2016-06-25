<form>
  <fieldset class="form-group">
    <input type="text" class="form-control" id="parcel-to" placeholder="To..." require="required">
  </fieldset>
  <fieldset class="form-group">
    <input type="text" class="form-control" id="parcel-from" placeholder="From..." required="required">
  </fieldset>
  <fieldset class="form-group">
    <input type="text" class="form-control" id="parcel-description" placeholder="Describe parcel.." required>
  </fieldset>
  <fieldset class="form-group">
    <input type="text" class="form-control" id="parcel-route" placeholder="Route..." required>
  </fieldset>
   
   <fieldset class="form-group">
    <input type="number" class="form-control" id="parcel-cost" placeholder="e.g 456" required>
  </fieldset>
 
 
</form>
 <button class="btn btn-large btn-success" id="submit"  onclick="parcel.save()">  Submit</button>