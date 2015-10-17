package AcciSave

import javax.annotation.PostConstruct

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler
import org.springframework.web.bind.annotation.RestController

import IAcciSave.ITrackMyVehicleService;

@RestController
class TrackMyVehicleController {

	@Autowired
	SimpMessagingTemplate brokerMessageTemplate
	TrackMyRequest myRequest
	ITrackMyVehicleService trackMyVehicleService 
	
	
	@MessageMapping(value = "/myvehicle")
	public void getTrackDetails(TrackMyRequest myRequest) {
		this.myRequest = myRequest
		sendVehicleDetailstoVehicle()
	}
	
	@PostConstruct
	public void sendVehicleDetailstoVehicle() {
		def scheduler = new ConcurrentTaskScheduler()
		
		scheduler.scheduleAtFixedRate(new Runnable() {
			 @Override
			public void run() {
				if (myRequest != null) {
					brokerMessageTemplate.convertAndSend("/topic/vehicle/"+myRequest.username,
							trackMyVehicleService.getTrackDetails(myRequest))
				}
			}
		}, 1000)
	}

}