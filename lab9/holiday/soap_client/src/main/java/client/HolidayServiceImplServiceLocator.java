/**
 * HolidayServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package client;

public class HolidayServiceImplServiceLocator extends org.apache.axis.client.Service implements client.HolidayServiceImplService {

    public HolidayServiceImplServiceLocator() {
    }


    public HolidayServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HolidayServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HolidayServiceImplPort
    private java.lang.String HolidayServiceImplPort_address = "http://localhost:8080/soap_service-1/HolidayServiceImpl";

    public java.lang.String getHolidayServiceImplPortAddress() {
        return HolidayServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HolidayServiceImplPortWSDDServiceName = "HolidayServiceImplPort";

    public java.lang.String getHolidayServiceImplPortWSDDServiceName() {
        return HolidayServiceImplPortWSDDServiceName;
    }

    public void setHolidayServiceImplPortWSDDServiceName(java.lang.String name) {
        HolidayServiceImplPortWSDDServiceName = name;
    }

    public client.HolidayService getHolidayServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HolidayServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHolidayServiceImplPort(endpoint);
    }

    public client.HolidayService getHolidayServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            client.HolidayServiceImplServiceSoapBindingStub _stub = new client.HolidayServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getHolidayServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHolidayServiceImplPortEndpointAddress(java.lang.String address) {
        HolidayServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (client.HolidayService.class.isAssignableFrom(serviceEndpointInterface)) {
                client.HolidayServiceImplServiceSoapBindingStub _stub = new client.HolidayServiceImplServiceSoapBindingStub(new java.net.URL(HolidayServiceImplPort_address), this);
                _stub.setPortName(getHolidayServiceImplPortWSDDServiceName());
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
        if ("HolidayServiceImplPort".equals(inputPortName)) {
            return getHolidayServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service/", "HolidayServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service/", "HolidayServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HolidayServiceImplPort".equals(portName)) {
            setHolidayServiceImplPortEndpointAddress(address);
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
