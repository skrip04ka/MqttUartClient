package org.example.app;

import org.example.app.slave1.SlaveOne;
import org.example.dto.MqttData;
import org.example.dto.SlaveDtoOne;
import org.example.uart.UartHelper;

import java.util.Scanner;

import static org.example.Config.COM_PORT;

/** Для тестов без MQTT */
public class TestClass {
    public static void main(String[] args) {

        UartHelper uartHelper = new UartHelper(COM_PORT);
        UartApp app = new SlaveOne();

        SlaveDtoOne slaveDtoOne = new SlaveDtoOne();

        MqttData mqttData = new MqttData();
        mqttData.setSlaveDtoOne(slaveDtoOne);

        Scanner sc = new Scanner(System.in);

        while (true) {
            slaveDtoOne.setAdc1(Integer.parseInt(sc.nextLine()));
            app.action(mqttData, uartHelper);
        }
    }
}
