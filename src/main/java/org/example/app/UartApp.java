package org.example.app;

import org.example.dto.MqttData;
import org.example.uart.UartHelper;

public interface UartApp {
    void action(MqttData mqttData, UartHelper uartHelper);
}
