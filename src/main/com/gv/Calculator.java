/**
 * Calculator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gv;

public interface Calculator extends javax.xml.rpc.Service {
    public java.lang.String getCalculatorHttpSoap11EndpointAddress();

    public com.gv.CalculatorPortType getCalculatorHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException;

    public com.gv.CalculatorPortType getCalculatorHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getCalculatorHttpSoap12EndpointAddress();

    public com.gv.CalculatorPortType getCalculatorHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException;

    public com.gv.CalculatorPortType getCalculatorHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
