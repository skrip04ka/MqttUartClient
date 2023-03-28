package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SlaveDtoOne {

    public SlaveDtoOne() {
        this.adc1 = 0;
    }

    private int adc1;
}
