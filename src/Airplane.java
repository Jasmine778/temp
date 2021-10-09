import java.util.Date;

public class Airplane implements Runnable {
    int num;

    Date intoTime;

    Airport airport;

    public Airplane(Airport airport)
    {
        this.airport = airport;
    }

    public Date getIntoTime() {
        return intoTime;
    }

    public void setIntoTime(Date intoTime) {
        this.intoTime = intoTime;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void run()
    {
        goForRunway();

    }
    private synchronized void goForRunway()
    {
        airport.add(this);
    }
}
