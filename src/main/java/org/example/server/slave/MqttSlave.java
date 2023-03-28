package org.example.server.slave;

import lombok.SneakyThrows;
import org.example.server.mqtt.MqttHelper;
import org.example.server.mqtt.MqttListener;

public class MqttSlave {
    private final MqttHelper helper;
    private final String topicName;

    @SneakyThrows
    public MqttSlave(String id, String serverUri, String topicName) {
        this.helper = new MqttHelper(id, serverUri);
        this.topicName = topicName;
    }

    @SneakyThrows
    public void addSubscriber(MqttListener mqttListener) {
        helper.addSubscriber(topicName, mqttListener);
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
