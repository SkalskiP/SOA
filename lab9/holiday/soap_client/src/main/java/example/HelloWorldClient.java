package example;

import client.HolidayService;
import client.HolidayServiceImplServiceLocator;

public class HelloWorldClient {
  public static void main(String[] argv) {
      try {
          HolidayServiceImplServiceLocator locator = new HolidayServiceImplServiceLocator();
          HolidayService text = locator.getHolidayServiceImplPort();
          System.out.println(text.countDaysToHolidays());
      } catch (javax.xml.rpc.ServiceException ex) {
          ex.printStackTrace();
      } catch (java.rmi.RemoteException ex) {
          ex.printStackTrace();
      }
  }
}
