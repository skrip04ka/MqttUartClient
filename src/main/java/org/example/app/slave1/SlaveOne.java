package org.example.app.slave1;


import lombok.SneakyThrows;
import org.example.app.UartApp;
import org.example.dto.MqttData;
import org.example.dto.SlaveDtoOne;
import org.example.uart.UartHelper;

public class SlaveOne implements UartApp {

    private int[] data = new int[1];
    @SneakyThrows
    @Override
    public void action(MqttData mqttData, UartHelper uartHelper) {
        appLogic(mqttData.getSlaveDtoOne()); // get data from master
        uartHelper.transmitByte(data);
    }

    private void appLogic(SlaveDtoOne slaveDto) {
        // Your code
        data[0] = slaveDto.getAdc1();

    }
}
