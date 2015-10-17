package AcciSave

import IAcciSave.ITrackMyVehicleService;
import grails.transaction.Transactional

@Transactional
class TrackMyVehicleService implements ITrackMyVehicleService  {

	@Override
	public def getTrackDetails(TrackMyRequest myRequest) {

		def vehicle = new ArrayList()
		if (myRequest != null) {
			String geoRadiusScript = "return redis.call('georadius', KEYS[1], ARGV[1], ARGV[2], ARGV[3], ARGV[4], ARGV[5])"
			def geoRadiusScriptKeys = new ArrayList<String>() << "Area"
			Object[] geoRadiusScriptArgs = [ myRequest.latitude, myRequest.longitude,
					myRequest.radius, 'm', "withdistance" ]

			JedisWrapper jedisWrapper = new JedisWrapper(geoRadiusScript, String.class, geoRadiusScriptKeys,
					geoRadiusScriptArgs)
			def scriptOutput = jedisWrapper.executeLuaScript()

            println scriptOutput
			scriptOutput.eachWithIndex { redisobject, i ->
				def myVehicle = new MyVehicle()
				myVehicle.with {
					(message,latitude,longitude) = [getCustomMessage(redisobject.get(0).toString()),
					  Double.parseDouble((redisobject.get(1)).get(0).toString()),
					  Double.parseDouble((redisobject.get(1)).get(1).toString())]
			}
			println vehicle
			vehicle << myVehicle
		}
	}
	vehicle
  }

	private def getCustomMessage(String msg) {
		if(msg.contains("SB")) {
			"Approaching a speed breaker. Kindly reduce your speed."
		} else if(msg.contains("SA")) {
		    "Approaching slippery area. Kindly reduce your speed."
		} else if(msg.contains("AZ")) {
		    "Approaching an accident zone. Kindly reduce your speed."
		} else {
		    "Approaching a man/pot hole. Kindly reduce your speed."
		}
	}
}
