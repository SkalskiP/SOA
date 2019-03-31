import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class TestAddBean implements ILocalTestAddBean {
    /**
     * Default constructor.
     */
    public TestAddBean () {
// TODO Auto-generated constructor stub
    }
    public int add(int a,int b){
        int r=a+b;
        return r;
    }
}