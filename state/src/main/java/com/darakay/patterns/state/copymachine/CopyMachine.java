package com.darakay.patterns.state.copymachine;

import com.darakay.patterns.state.Device;
import com.darakay.patterns.state.exception.CopyMachineException;

import java.util.List;

public class CopyMachine {
    private MachineState currentState;
    private int currentDeposit;

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
        int cash = this.currentDeposit;
        this.decreaseDepositValue(cash);
        this.setState(new InitialState(this));
        return cash;
    }

    void setState(MachineState machineState){
        this.currentState = machineState;
    }

    void increaseDepositValue(int sum){
        this.currentDeposit += sum;
    }

    void decreaseDepositValue(int sum){
        checkToValidDepositValue(sum);
        this.currentDeposit -= sum;
    }

    private void checkToValidDepositValue(int decrement){
        if(currentDeposit - decrement < 0){
            throw new CopyMachineException("На счету не достаточно денег!");
        }
    }
}
