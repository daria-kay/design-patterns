package com.darakay.patterns.state.copymachine;

import com.darakay.patterns.state.Device;

import java.util.List;

public class InitialState extends MachineState {

    public InitialState(CopyMachine copyMachine) {
        super(copyMachine);
    }

    @Override
    public void depositMoney(int sum) {

    }

    @Override
    public String printDocument(String document) {
        return document;
    }

    @Override
    public void setDevice(Device device) {

    }

    @Override
    public List<String> getAllDocumentNames() {
        return null;
    }

    @Override
    public int getCash() {
        return 0;
    }
}
