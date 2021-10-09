import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Airport {

    List<Airplane> listAirplane;

    int handAirplaneNum = 0;

    public Airport()
    {

        listAirplane = new LinkedList<Airplane>();
    }

    public void processInGate()
    {
        Airplane airplane;
        synchronized (listAirplane)
        {

            while(listAirplane.size()==0)
            {
                System.out.println("ATC is waiting for airplane.");

                try
                {
                    listAirplane.wait();
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
            }
            System.out.println("ATC found a airplane in the queue.");
            airplane = (Airplane)((LinkedList<?>)listAirplane).poll();
        }
        long duration=0;
        try
        {
            System.out.println("Disembark passenger of Airplane : "+airplane.getNum());
            System.out.println("Refill supplies and fuel of Airplane : "+airplane.getNum());
            System.out.println("embark new passenger of Airplane : "+airplane.getNum());
            duration = (long)(Math.random()*10);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Completed Disembark passenger of Customer : "+airplane.getNum() + " in "+duration+ " seconds.");
        System.out.println("Completed Refill supplies of Customer : "+airplane.getNum() + " in "+duration+ " seconds.");
        System.out.println("Completed embark new passenger of Customer : "+airplane.getNum() + " in "+duration+ " seconds.");
        System.out.println("------------------------Customer "+airplane.getNum()+" exits...");
        handAirplaneNum ++;
    }


    public void add(Airplane airplane)
    {
        System.out.println("Airplane : "+ airplane.getNum()+ " entering the runway at "+ airplane.getIntoTime());

        synchronized (listAirplane)
        {

            ((LinkedList<Airplane>)listAirplane).offer(airplane);
            System.out.println("Airplane : "+ airplane.getNum()+ " got the Gate.");

            if(listAirplane.size()>=1){
                listAirplane.notify();
            }



        }
    }
}
