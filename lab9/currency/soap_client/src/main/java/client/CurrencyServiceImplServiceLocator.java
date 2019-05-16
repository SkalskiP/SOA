/**
 * CurrencyServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package client;

public class CurrencyServiceImplServiceLocator extends org.apache.axis.client.Service implements client.CurrencyServiceImplService {

    public CurrencyServiceImplServiceLocator() {
    }


    public CurrencyServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CurrencyServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CurrencyServiceImplPort
    private java.lang.String CurrencyServiceImplPort_address = "http://localhost:8080/soap_service-1/CurrencyServiceImpl";

    public java.lang.String getCurrencyServiceImplPortAddress() {
        return CurrencyServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CurrencyServiceImplPortWSDDServiceName = "CurrencyServiceImplPort";

    public java.lang.String getCurrencyServiceImplPortWSDDServiceName() {
        return CurrencyServiceImplPortWSDDServiceName;
    }

    public void setCurrencyServiceImplPortWSDDServiceName(java.lang.String name) {
        CurrencyServiceImplPortWSDDServiceName = name;
    }

    public client.CurrencyService getCurrencyServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CurrencyServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCurrencyServiceImplPort(endpoint);
    }

    public client.CurrencyService getCurrencyServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            client.CurrencyServiceImplServiceSoapBindingStub _stub = new client.CurrencyServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getCurrencyServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCurrencyServiceImplPortEndpointAddress(java.lang.String address) {
        CurrencyServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (client.CurrencyService.class.isAssignableFrom(serviceEndpointInterface)) {
                client.CurrencyServiceImplServiceSoapBindingStub _stub = new client.CurrencyServiceImplServiceSoapBindingStub(new java.net.URL(CurrencyServiceImplPort_address), this);
                _stub.setPortName(getCurrencyServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CurrencyServiceImplPort".equals(inputPortName)) {
            return getCurrencyServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service/", "CurrencyServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service/", "CurrencyServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CurrencyServiceImplPort".equals(portName)) {
            setCurrencyServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
