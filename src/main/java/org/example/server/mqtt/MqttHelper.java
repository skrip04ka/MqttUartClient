package org.example.server.mqtt;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;

@Slf4j
public class MqttHelper {

    private final MqttClient client;

    public MqttHelper(String id, String serverUri) throws MqttException {
//        client = new MqttClient(serverUri, MqttClient.generateClientId());
        client = new MqttClient(serverUri, id);
    }

    public void connect(String username, String password) throws MqttException {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        client.connect(options);
        log.info("connect");
    }


    public void sendMessageToTopic(String message, String topicName) throws MqttException {
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setPayload(message.getBytes());
        client.publish(topicName, mqttMessage);
        log.debug("send message {}", mqttMessage);
    }

    public void addSubscriber(String topicName, IMqttMessageListener iMqttMessageListener) throws MqttException {
        client.subscribe(topicName, iMqttMessageListener);
    }

    public void disconnect() throws MqttException {
        log.info("disconnect");
        client.disconnect();
    }


}
