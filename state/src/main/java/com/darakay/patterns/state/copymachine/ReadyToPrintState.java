package com.darakay.patterns.state.copymachine;

import com.darakay.patterns.state.Device;
import com.darakay.patterns.state.exception.CopyMachineException;

import java.util.List;

public class ReadyToPrintState extends MachineState {

    private Device device;

    public ReadyToPrintState(Device device, CopyMachine copyMachine) {
        super(copyMachine);
        this.device = device;
    }

    @Override
    public void depositMoney(int sum) {
        copyMachine.increaseDepositValue(sum);
    }

    @Override
    public String printDocument(String document) {
        copyMachine.decreaseDepositValue(2);
        return device.getDocument(document);
    }

    @Override
    public void setDevice(Device device) {
        //change device
        this.device = device;
    }

    @Override
    public List<String> getAllDocumentNames() {
        return device.getAllDocumentNames();
    }
}
