import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AirplaneGenerator implements Runnable {
    Airport airport;
    int airplaneNum = 10;
    public AirplaneGenerator(Airport airport)
    {
        this.airport = airport;
    }

    public void run()
    {
        for(int i = 1; i <= airplaneNum ; i++){
            Airplane airplane = new Airplane(airport);
            airplane.setIntoTime(new Date());
            Thread thAirplane = new Thread(airplane);
            airplane.setNum(i);
            thAirplane.start();

            try
            {
                // airplane into time
                TimeUnit.SECONDS.sleep((long)(Math.random()*5));

            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }
}
