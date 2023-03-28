package org.example.app;

import org.example.app.slave1.SlaveOne;
import org.example.server.slave.MqttSlave;
import org.example.uart.UartHelper;


import static org.example.Config.*;
import static org.example.Config.PASSWORD;

/** Рабочий класс для slave */
public class SlaveMqtt {

    public static void main(String[] args) {
        MqttSlave helper = new MqttSlave(Thread.currentThread().getName(),
                SERVER_URI, TOPIC_NAME);
        helper.connect(USERNAME, PASSWORD);
        UartHelper uartHelper = new UartHelper(COM_PORT);

        UartApp app = new SlaveOne(); // choice slave class

        helper.addSubscriber(mqttData -> app.action(mqttData, uartHelper));
    }


}
