package org.example.app;

import org.example.app.master.Master;
import org.example.dto.MqttData;
import org.example.dto.SlaveDtoOne;
import org.example.dto.SlaveDtoThree;
import org.example.dto.SlaveDtoTwo;
import org.example.server.master.MqttMaster;
import org.example.uart.UartHelper;

import static org.example.Config.*;
import static org.example.Config.PASSWORD;

/** Рабочий класс для master */
public class MasterMqtt {
    public static void main(String[] args) {
        MqttMaster master = new MqttMaster(Thread.currentThread().getName(),
                SERVER_URI, TOPIC_NAME);
        master.connect(USERNAME, PASSWORD);
        UartHelper uartHelper = new UartHelper(COM_PORT);

        UartApp app = new Master();

        // init data
        SlaveDtoOne s1 = new SlaveDtoOne();
        SlaveDtoTwo s2 = new SlaveDtoTwo();
        SlaveDtoThree s3 = new SlaveDtoThree();

        MqttData data = new MqttData();
        data.setSlaveDtoOne(s1);
        data.setSlaveDtoTwo(s2);
        data.setSlaveDtoThree(s3);

        // main cycle
        while (true) {
            app.action(data, uartHelper);
            master.sendMessage(data);
        }


    }
}
