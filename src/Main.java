
public class Main {

	public static void main(String[] args) {

		Airport airport = new Airport();


		AirplaneGenerator ag = new AirplaneGenerator(airport);
		ATC atc = new ATC(airport);

	    Thread thAg = new Thread(ag);
	    Thread thAtc = new Thread(atc);
	    Thread thAtc2 = new Thread(atc);
	    Thread thAtc3 = new Thread(atc);
	    Thread thAtc4 = new Thread(atc);
		thAg.start();
		thAtc.start();
		thAtc2.start();
		thAtc3.start();
		thAtc4.start();

	}

}
