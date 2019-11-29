package com.darakay.patterns.state.copymachine;

import com.darakay.patterns.state.Device;
import com.darakay.patterns.state.exception.CopyMachineException;

import java.util.List;

public class SettingDeviceState extends MachineState {

    SettingDeviceState(CopyMachine copyMachine) {
        super(copyMachine);
    }

    @Override
    public void depositMoney(int sum) {
        copyMachine.increaseDepositValue(sum);
    }

    @Override
    public String printDocument(String document) {
        throw new CopyMachineException("Устройство не было выбранно!");
    }

    @Override
    public void setDevice(Device device) {
        copyMachine.setState(new ReadyToPrintState(device, super.copyMachine));
    }

    @Override
    public List<String> getAllDocumentNames() {
        throw new CopyMachineException("Устройство не было выбранно!");
    }

}
