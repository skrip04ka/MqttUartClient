package org.example.uart;

import jssc.SerialPort;
import jssc.SerialPortException;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс создающий коннект к МК по UART
 */
public class UartHelper {
    private final SerialPort serialPort;

    /**
     * Консутруктор
     * @param portName имя порта
     */
    @SneakyThrows
    public UartHelper(String portName) {
        serialPort = new SerialPort(portName);
        serialPort.openPort();
        serialPort.setParams(
                SerialPort.BAUDRATE_115200,
                SerialPort.DATABITS_8,
                SerialPort.PARITY_NONE,
                SerialPort.STOPBITS_1);

    }

    /**
     * Класс передачи данных к МК
     * @param data данные для передачи
     */
    @SneakyThrows
    public void transmitByte(int[] data){
        serialPort.writeIntArray(data);
    }


    /**
     * Добавить листнер для прослушивания
     * После получения данных от МК по UART выполняется код в листнере
     * @param listener листнер
     */
    @SneakyThrows
    public void addListener(UartListener listener) {
        serialPort.addEventListener(serialPortEvent -> {
            if(serialPortEvent.isRXCHAR() && serialPortEvent.getEventValue() > 0) {
                try {
                    listener.event(serialPort.readIntArray(serialPortEvent.getEventValue()));
                } catch (SerialPortException e) {
                    throw new RuntimeException(e);
                }
            }
        }, SerialPort.MASK_RXCHAR);
    }



}
