import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("test")
@SessionScoped
public class Test implements Serializable {
    @EJB
    private IRemoteTestBeanCounter counter;

    public Long getNumber() {
        return counter.getNumber();
    }

    public void incrementNumber() {
        counter.increment();
    }
}
