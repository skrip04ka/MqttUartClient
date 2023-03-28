package org.example.app.master;

import org.example.app.UartApp;
import org.example.dto.MqttData;
import org.example.uart.UartHelper;

public class Master implements UartApp {


    public void action(MqttData mqttData, UartHelper uartHelper) {

        uartHelper.addListener(data -> {

            // Your code



        });
    }
}
