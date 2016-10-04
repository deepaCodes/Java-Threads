package gym_Design_Semaphores;

public enum ApparatusType {
	LEGPRESSMACHINE, BARBELL, HACKSQUATMACHINE , LEGEXTENSIONMACHINE ,
	LEGCURLMACHINE, LATPULLDOWNMACHINE , PECDECKMACHINE,  CABLECROSSOVERMACHINE ;
	
	public static ApparatusType randomApparatus(){
		double r=  Math.random()*ApparatusType.values().length;
		return ApparatusType.values()[(int )r];
	}
}
