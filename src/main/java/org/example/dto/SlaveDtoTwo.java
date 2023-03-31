package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SlaveDtoTwo {

    public SlaveDtoTwo() {
        this.adc3 = 1;
        this.adc4 = 1;
    }

    private int adc3;
    private int adc4;
}
