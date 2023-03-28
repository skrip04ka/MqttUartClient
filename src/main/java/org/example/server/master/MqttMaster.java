package org.example.server.master;

import lombok.SneakyThrows;
import org.example.dto.MqttData;
import org.example.server.other.JsonParser;
import org.example.server.mqtt.MqttHelper;

public class MqttMaster {

    private final MqttHelper helper;
    private final String topicName;

    @SneakyThrows
    public MqttMaster(String id, String serverUri, String topicName) {
        helper = new MqttHelper(id, serverUri);
        this.topicName = topicName;
    }

    @SneakyThrows
    public void sendMessage(MqttData mqttData) {
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
