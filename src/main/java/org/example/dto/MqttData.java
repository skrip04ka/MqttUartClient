package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MqttData {
    private SlaveDtoOne slaveDtoOne;
    private SlaveDtoTwo slaveDtoTwo = new SlaveDtoTwo();
    private SlaveDtoThree slaveDtoThree;
}
