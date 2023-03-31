package org.example;

public class Config {
    // .\mosquitto -v -c mosquitto.conf

//    public static String SERVER_URI = "tcp://localhost:1883";
    public static String SERVER_URI = "tcp://26.83.131.30:1883";
    public static String TOPIC_NAME_S1 = "one_topic";
    public static String TOPIC_NAME_S2 = "two_topic";
    public static String TOPIC_NAME_S3 = "three_topic";
    public static String USERNAME = "mqtt";
    public static String PASSWORD = "pass";
    public static String COM_PORT = "COM4";
    public static long DEAD_TIME = 2000;

}
