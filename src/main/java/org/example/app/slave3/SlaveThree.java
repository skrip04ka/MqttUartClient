package org.example.app.slave3;

import org.example.app.UartApp;
import org.example.dto.MqttData;
import org.example.dto.SlaveDtoThree;
import org.example.uart.UartHelper;

public class SlaveThree implements UartApp {

    private int[] data = new int[1]; // data array

    @Override
    public void action(MqttData mqttData, UartHelper uartHelper) {
        appLogic(mqttData.getSlaveDtoThree()); // get data from master
        uartHelper.transmitByte(data); // send data to mk
    }

    private void appLogic(SlaveDtoThree slaveDto) {
        // Your code



    }
}
