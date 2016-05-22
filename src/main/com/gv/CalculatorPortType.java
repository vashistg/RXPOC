/**
 * CalculatorPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gv;

public interface CalculatorPortType extends java.rmi.Remote {
    public int difference(int a, int b) throws java.rmi.RemoteException;
    public int sum(int a, int b) throws java.rmi.RemoteException;
}
