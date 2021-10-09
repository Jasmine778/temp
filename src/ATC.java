import java.util.LinkedList;
import java.util.List;

public class ATC implements Runnable  {

    Airport airport;

    public ATC(Airport airport)
    {
        this.airport = airport;
    }
    public void run()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("----------------ATC started..");

        while(airport.handAirplaneNum <= 10)
        {
            airport.processInGate();
        }

    }
}
