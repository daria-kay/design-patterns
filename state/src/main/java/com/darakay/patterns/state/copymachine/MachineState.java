package com.darakay.patterns.state.copymachine;

import com.darakay.patterns.state.Device;

import java.util.List;

public abstract class MachineState {

    protected CopyMachine copyMachine;

    MachineState(CopyMachine copyMachine){
        this.copyMachine = copyMachine;
    }

    public abstract void depositMoney(int sum);

    public abstract String printDocument(String document);

    public abstract void setDevice(Device device);

    public abstract List<String> getAllDocumentNames();

}
