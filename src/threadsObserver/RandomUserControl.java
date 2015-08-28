package threadsObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import randomperson.RandomUser;
import randomperson.RandomUserGenerator;

public class RandomUserControl extends Observable
{

    RandomUser user = null;

    public void fetchRandomUser()
    {
        thread1 t1 = new thread1();
        
        t1.start();
    }

    public class thread1 extends Thread
    {
        @Override
        public void run()
        {
            try
            {
                user = RandomUserGenerator.getRandomUser();
                setChanged();
                notifyObservers(user);
            } catch (InterruptedException ex)
            {
                Logger.getLogger(RandomUserControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
