package org.example.app.slave1;


import lombok.SneakyThrows;
import org.example.app.UartApp;
import org.example.dto.MqttData;
import org.example.uart.UartHelper;

public class SlaveOne implements UartApp {

    private final int[] data = new int[1];
    private int prevData = -1;
    @SneakyThrows
    @Override
    public void action(MqttData mqttData, UartHelper uartHelper) {
        int adcData = mqttData.getSlaveDtoOne().getAdc1();

        if (adcData == 2000) {
            uartHelper.transmitByte(new int[]{254});
            return;
        }

        if (adcData > 1023) adcData = 1023;
        if (adcData < 0) adcData = 0;
        adcData = adcData*180/1023;
        appLogic(adcData); // get data from master


        if(prevData != data[0]) {
            prevData = data[0];
            uartHelper.transmitByte(data);
        }
    }

    private void appLogic(int a) {
        // Your code
        data[0] = a;

    }
}
