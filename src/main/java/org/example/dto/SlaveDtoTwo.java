package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SlaveDtoTwo {

    public SlaveDtoTwo() {
        this.adc3 = 0;
        this.adc4 = 0;
    }

    private double adc3;
    private double adc4;
}
