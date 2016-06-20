package tripticket.location.dao;

import java.util.ArrayList;
import java.util.List;

import trioticket.location.model.Location;

public class LocationDao implements LocationDaoI {

	public Location add(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	public Location remove(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Location> list(Location filter) {
		
		List<Location>  locations = new ArrayList<Location>();
		Location location = new Location();
		
		location.setName("Nairobi");
		location.setId(1);
		locations.add(location);
	
		location = new Location();
		location.setName("Mombasa");
		location.setId(2);
		locations.add(location);
		
		location = new Location();
		location.setName("Kisumu");
		location.setId(3);
		locations.add(location);
		
		location = new Location();
		location.setName("Kampala");
		location.setId(4);
		locations.add(location);
		
		location = new Location();
		location.setName("Malindi");
		location.setId(5);
		locations.add(location);
		
		location = new Location();
		location.setName("Kakamega");
		location.setId(6);
		locations.add(location);
		
		return locations;
	}

	public void delete(Long locationId) {
		// TODO Auto-generated method stub
		
	}

}
