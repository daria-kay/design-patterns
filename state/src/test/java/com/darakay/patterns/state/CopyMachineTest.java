package com.darakay.patterns.state;

import com.darakay.patterns.state.exception.CopyMachineException;
import com.darakay.patterns.state.copymachine.CopyMachine;
import com.google.common.collect.ImmutableList;
import org.assertj.core.api.ThrowableAssert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CopyMachineTest {

    private CopyMachine copyMachine;

    private Device testDevice = mock(Device.class);

    @Before
    public void  setUp(){
        this.copyMachine = new CopyMachine();
    }

    //печать одного документа с выполнением всей последовательности шагов
    @Test
    public void positive_printOnlyOneDocument(){
        when(testDevice.getAllDocumentNames()).thenReturn(ImmutableList.of("Document1.txt", "Document2.txt"));
        when(testDevice.getDocument("Document2.txt")).thenReturn("Text of Document2.txt");

        copyMachine.depositMoney(10);
        copyMachine.setDevice(testDevice);
        String documentName = copyMachine.getAllDocumentNames().get(1);
        String output = copyMachine.printDocument(documentName);
        int cash = copyMachine.getCash();

        assertThat(output).isEqualTo("Text of Document2.txt");
        assertThat(cash).isEqualTo(8);
    }

    //печать нескольких документов с выполнением всей последовательности шагов
    @Test
    public void positive_printFewDocuments(){
        when(testDevice.getAllDocumentNames()).thenReturn(ImmutableList.of("Document1.txt", "Document2.txt"));
        when(testDevice.getDocument("Document1.txt")).thenReturn("Text of Document1.txt");
        when(testDevice.getDocument("Document2.txt")).thenReturn("Text of Document2.txt");

        copyMachine.depositMoney(10);
        copyMachine.setDevice(testDevice);
        String firstDocumentName = copyMachine.getAllDocumentNames().get(1);
        String firstOutput = copyMachine.printDocument(firstDocumentName);
        String secondDocumentName = copyMachine.getAllDocumentNames().get(0);
        String secondOutput = copyMachine.printDocument(secondDocumentName);
        int cash = copyMachine.getCash();

        assertThat(firstOutput).isEqualTo("Text of Document2.txt");
        assertThat(secondOutput).isEqualTo("Text of Document1.txt");
        assertThat(cash).isEqualTo(6);
    }

    @Test
    public void positive_attemptToPrintSecondDocument_AfterPrintingFirstDocumentAndIncreasingDepositValue(){
        when(testDevice.getAllDocumentNames()).thenReturn(ImmutableList.of("Document1.txt", "Document2.txt"));
        when(testDevice.getDocument("Document1.txt")).thenReturn("Text of Document1.txt");
        when(testDevice.getDocument("Document2.txt")).thenReturn("Text of Document2.txt");

        copyMachine.depositMoney(2);
        copyMachine.setDevice(testDevice);
        String firstOutput = copyMachine.printDocument("Document2.txt");
        copyMachine.depositMoney(2);
        String secondOutput = copyMachine.printDocument("Document1.txt");
        int cash = copyMachine.getCash();

        assertThat(firstOutput).isEqualTo("Text of Document2.txt");
        assertThat(secondOutput).isEqualTo("Text of Document1.txt");
        assertThat(cash).isEqualTo(0);
    }

    @Test
    public void positive_attemptToPrintingDocumentFromOtherDevice_AfterPrintingFirstDocument(){
        Device otherDevice = mock(Device.class);

        when(otherDevice.getDocument("DocFromOtherDevice.txt"))
                .thenReturn("Text of DocFromOtherDevice.txt");

        when(testDevice.getAllDocumentNames()).thenReturn(ImmutableList.of("Document1.txt", "Document2.txt"));
        when(testDevice.getDocument("Document2.txt")).thenReturn("Text of Document2.txt");

        copyMachine.depositMoney(4);
        copyMachine.setDevice(testDevice);
        String firstOutput = copyMachine.printDocument("Document2.txt");
        copyMachine.setDevice(otherDevice);
        String secondOutput = copyMachine.printDocument("DocFromOtherDevice.txt");
        int cash = copyMachine.getCash();

        assertThat(firstOutput).isEqualTo("Text of Document2.txt");
        assertThat(secondOutput).isEqualTo("Text of DocFromOtherDevice.txt");
        assertThat(cash).isEqualTo(0);
    }

    @Test
    public void positive_attemptToIncreaseDepositValue_AfterSettingDevice(){
        when(testDevice.getDocument("Document2.txt")).thenReturn("Text of Document2.txt");

        copyMachine.depositMoney(1);
        copyMachine.setDevice(testDevice);
        copyMachine.depositMoney(1);

        String output = copyMachine.printDocument("Document2.txt");

        assertThat(output).isEqualTo("Text of Document2.txt");
        assertThat(copyMachine.getCash()).isEqualTo(0);
    }

    @Test
    public void negative_deviceSetting_WhenNoCashWasDeposited(){
        assertThatThrownBy(() -> copyMachine.setDevice(testDevice))
                .isInstanceOf(CopyMachineException.class)
                .hasMessage("Деньги не были внесены!");
    }

    @Test
    public void negative_documentSetting_WhenNoDeviceWasSetting(){
        copyMachine.depositMoney(10);

        assertThatThrownBy(() -> copyMachine.printDocument("testName"))
                .isInstanceOf(CopyMachineException.class)
                .hasMessage("Устройство не было выбранно!");
    }

    @Test
    public void negative_attemptToBackCash_WhenNoCashWasDeposited(){
        assertThatThrownBy(() -> copyMachine.printDocument("testName"))
                .isInstanceOf(CopyMachineException.class)
                .hasMessage("Деньги не были внесены!");
    }

    @Test
    public void negative_attemptToPrintTooManyDocuments_WhenDepositedMoneyIsNotEnough(){
        when(testDevice.getAllDocumentNames()).thenReturn(ImmutableList.of("Document1.txt", "Document2.txt"));
        when(testDevice.getDocument("Document2.txt")).thenReturn("Text of Document2.txt");

        copyMachine.depositMoney(3);
        copyMachine.setDevice(testDevice);
        String firstDocumentName = copyMachine.getAllDocumentNames().get(1);

        ThrowableAssert.ThrowingCallable testAction = () -> Stream.iterate(0, i -> i++).limit(5)
                .map(i -> copyMachine.printDocument(firstDocumentName)).forEach((text)-> {});

        assertThatThrownBy(testAction)
                .isInstanceOf(CopyMachineException.class)
                .hasMessage("На счету не достаточно денег!");
        assertThat(copyMachine.getCash()).isEqualTo(1);
    }

    @Test
    public void negative_attemptToGetAllDocumetNames_WhenNoDeviceWasSelected(){
        when(testDevice.getAllDocumentNames()).thenReturn(ImmutableList.of("Document1.txt", "Document2.txt"));
        when(testDevice.getDocument("Document2.txt")).thenReturn("Text of Document2.txt");

        copyMachine.depositMoney(3);

        assertThatThrownBy(() -> copyMachine.getAllDocumentNames())
                .isInstanceOf(CopyMachineException.class)
                .hasMessage("Устройство не было выбранно!");
    }
}