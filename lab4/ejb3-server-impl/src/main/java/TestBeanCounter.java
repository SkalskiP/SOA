import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Singleton;

@Singleton
@Remote(IRemoteTestBeanCounter.class)
@Local(ILocalTestBeanCounter.class)
public class TestBeanCounter implements IRemoteTestBeanCounter, ILocalTestBeanCounter{
    long counterNumber = 0;
    @Override
    public void increment() {
        counterNumber ++;
    }
    @Override
    public long getNumber() {
        return counterNumber;
    }
}