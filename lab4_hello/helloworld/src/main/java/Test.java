import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "test")
public class Test {
    @EJB(lookup = "java:global/ejb-1.0-SNAPSHOT/TestBeanCounter")
    private ITestBeanCounter counter;

    public long getCounter() {
        return counter.getNumber();
    }

    public void increment() {
        this.counter.increment();
    }
}
