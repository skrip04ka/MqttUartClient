package org.example.app.slave1;


import lombok.SneakyThrows;
import org.example.app.UartApp;
import org.example.dto.MqttData;
import org.example.uart.UartHelper;

public class SlaveOne implements UartApp {

    private int[] data = new int[1];
    @SneakyThrows
    @Override
    public void action(MqttData mqttData, UartHelper uartHelper) {

        data[0] = mqttData.getSlaveDtoOne().getAdc1();
        uartHelper.transmitByte(data);

    }
}
