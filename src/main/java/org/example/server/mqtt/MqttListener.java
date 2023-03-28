package org.example.server.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.example.dto.MqttData;
import org.example.server.other.JsonParser;

import java.nio.charset.StandardCharsets;

public interface MqttListener extends IMqttMessageListener {


    @Override
    default void messageArrived(String s, MqttMessage mqttMessage) {
        action(JsonParser.stringToObject(
                new String(mqttMessage.getPayload(), StandardCharsets.UTF_8),
                MqttData.class));
    }

    void action(MqttData data);
}
