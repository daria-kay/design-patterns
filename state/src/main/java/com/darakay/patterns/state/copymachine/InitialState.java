package com.darakay.patterns.state.copymachine;

import com.darakay.patterns.state.Device;
import com.darakay.patterns.state.exception.CopyMachineException;

import java.util.List;

public class InitialState extends MachineState {

    public InitialState(CopyMachine copyMachine) {
        super(copyMachine);
    }

    @Override
    public void depositMoney(int sum) {
        copyMachine.increaseDepositValue(sum);
        super.copyMachine.setState(new SettingDeviceState(super.copyMachine));
    }

    @Override
    public String printDocument(String document) {
        throw new CopyMachineException("Деньги не были внесены!");
    }

    @Override
    public void setDevice(Device device) {
        throw new CopyMachineException("Деньги не были внесены!");
    }

    @Override
    public List<String> getAllDocumentNames() {
        throw new CopyMachineException("Деньги не были внесены!");
    }
}
