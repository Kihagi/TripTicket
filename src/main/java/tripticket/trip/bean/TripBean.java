package tripticket.trip.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tripticket.trip.dao.TripDaoI;
import tripticket.trip.model.Trip;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TripBean implements TripBeanI {

	@PersistenceContext
	private EntityManager em;

	@Inject
	private TripDaoI tripDao;

	@PostConstruct
	public void init() {
		tripDao.setEm(em);
	}

	public void add(Trip trip) {
		if (trip == null)
			return;

		tripDao.save(trip);
	}

	public String load(Long id) {
		Trip trip = tripDao.findById(id);

		if (trip != null)
			return trip.getJson();
		else
			return "{}";
	}

	public List<Trip> list() {
		return tripDao.list(new Trip());
	}

	public String listInJson() {
		Map<String, Object> filter = new HashMap<String, Object>();
		
		
		List<Trip> trips = tripDao.list(filter);
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		int count = tripDao.countAll();
		for (Trip trip : trips) {
			sb.append(trip.getJson());

			count--;

			if (count >= 1)
				sb.append(",");
		}

		sb.append("]");

		return sb.toString();
	}

	public boolean delete(Long id) {
		tripDao.delete(id);
		
		return true;
	}

}
