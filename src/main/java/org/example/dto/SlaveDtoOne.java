package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SlaveDtoOne {

    public SlaveDtoOne() {
        this.adc1 = 0;
    }

    private int adc1;
}
