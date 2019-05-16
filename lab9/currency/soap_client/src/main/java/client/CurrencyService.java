/**
 * CurrencyService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package client;

public interface CurrencyService extends java.rmi.Remote {
    public java.lang.Double getExchangeRateToPLN(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.Double exchangeToPLN(java.lang.String arg0, java.lang.Double arg1) throws java.rmi.RemoteException;
}
