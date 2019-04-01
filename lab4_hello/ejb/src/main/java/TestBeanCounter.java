import javax.ejb.Remote;
import javax.ejb.Singleton;

@Singleton
@Remote(IRemoteTestBeanCounter.class)
public class TestBeanCounter implements ITestBeanCounter{
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