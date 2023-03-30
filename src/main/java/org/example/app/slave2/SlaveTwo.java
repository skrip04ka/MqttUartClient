package org.example.app.slave2;

import org.example.app.UartApp;
import org.example.dto.MqttData;
import org.example.dto.SlaveDtoTwo;
import org.example.uart.UartHelper;

public class SlaveTwo implements UartApp {

    private int[] data = new int[1]; // data array

    @Override
    public void action(MqttData mqttData, UartHelper uartHelper) {
        appLogic(mqttData.getSlaveDtoTwo()); // get data from master
        uartHelper.transmitByte(data); // send data to mk
    }

    private void appLogic(SlaveDtoTwo slaveDto) {
        // Your code



    }
}
