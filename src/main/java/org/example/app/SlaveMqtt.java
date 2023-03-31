package org.example.app;

import org.example.app.slave1.SlaveOne;
import org.example.dto.MqttData;
import org.example.dto.SlaveDtoOne;
import org.example.server.slave.MqttSlave;
import org.example.uart.UartHelper;


import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import static org.example.Config.*;
import static org.example.Config.PASSWORD;

/** Рабочий класс для slave */
public class SlaveMqtt {

    public static void main(String[] args) {
        MqttSlave helper = new MqttSlave("slave_" + TOPIC_NAME_S1, SERVER_URI, TOPIC_NAME_S1);
        helper.connect(USERNAME, PASSWORD);
        UartHelper uartHelper = new UartHelper(COM_PORT);

        UartApp app = new SlaveOne(); // choice slave class

        AtomicLong time = new AtomicLong(new Date().getTime());
        helper.addSubscriber(mqttData -> {
            time.set(new Date().getTime());
            app.action(mqttData, uartHelper);
        });

        while (new Date().getTime() - time.get() < DEAD_TIME);
        MqttData mqttData = new MqttData();
        mqttData.setSlaveDtoOne(new SlaveDtoOne(2000));
        app.action(mqttData, uartHelper);
        helper.disconnect();

    }


}
