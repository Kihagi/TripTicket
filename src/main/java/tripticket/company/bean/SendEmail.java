package tripticket.company.bean;

import javax.enterprise.event.Observes;

import trioticket.location.model.Location;

public class SendEmail {
	
    public void send(@Observes Location location){
        System.out.println(" Email sent for location: " + location.getName());
    }

}
