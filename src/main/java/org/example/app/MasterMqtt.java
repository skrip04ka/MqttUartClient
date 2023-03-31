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
        MqttMaster master = new MqttMaster("master_id", SERVER_URI);
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

        app.action(data, uartHelper);
        // main cycle
        while (true) {
            master.sendMessage(data, TOPIC_NAME_S1);
            master.sendMessage(data, TOPIC_NAME_S2);
            master.sendMessage(data, TOPIC_NAME_S3);
        }


    }
}
