package example;

import client.CurrencyService;
import client.CurrencyServiceImplServiceLocator;

public class HelloWorldClient {
  public static void main(String[] argv) {
      try {
          CurrencyServiceImplServiceLocator locator = new CurrencyServiceImplServiceLocator();
          CurrencyService service = locator.getCurrencyServiceImplPort();
          System.out.println(service.exchangeToPLN("USD", 100.00));
      } catch (javax.xml.rpc.ServiceException ex) {
          ex.printStackTrace();
      } catch (java.rmi.RemoteException ex) {
          ex.printStackTrace();
      }  
  }
}
