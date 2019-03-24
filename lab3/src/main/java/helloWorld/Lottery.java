package helloWorld;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "Lottery")
@RequestScoped
public class Lottery {
    public String draw() {
        System.out.print("Hello ");
        if (Math.random() < 0.2)
            return "Win";
        else
            return "Loss";
    }
}
