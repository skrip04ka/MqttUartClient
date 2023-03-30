package org.example.server.master;

import lombok.SneakyThrows;
import org.example.dto.MqttData;
import org.example.server.other.JsonParser;
import org.example.server.mqtt.MqttHelper;

public class MqttMaster {

    private final MqttHelper helper;


    @SneakyThrows
    public MqttMaster(String id, String serverUri) {
        helper = new MqttHelper(id, serverUri);
    }

    @SneakyThrows
    public void sendMessage(Object mqttData, String topicName) {
        helper.sendMessageToTopic(JsonParser.objectToString(mqttData), topicName);
    }

    @SneakyThrows
    public void connect(String username, String password) {
        helper.connect(username, password);
    }

    @SneakyThrows
    public void disconnect() {
        helper.disconnect();
    }




}
