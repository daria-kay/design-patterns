package com.darakay.patterns.state.copymachine;

import com.darakay.patterns.state.Device;

import java.util.List;

public class CopyMachine {
    private MachineState currentState;

    public CopyMachine() {
        this.currentState = new InitialState(this);
    }

    public void depositMoney(int sum){
        currentState.depositMoney(sum);
    }

    public void setDevice(Device device){
        this.currentState.setDevice(device);
    }

    public List<String> getAllDocumentNames(){
        return this.currentState.getAllDocumentNames();
    }

    public String printDocument(String documentName){
        return this.currentState.printDocument(documentName);
    }

    public int getCash(){
        return this.currentState.getCash();
    }

    void setState(MachineState machineState){
        this.currentState = machineState;
    }
}
