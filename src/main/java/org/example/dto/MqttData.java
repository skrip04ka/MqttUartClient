package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MqttData {
    private SlaveDtoOne slaveDtoOne;
    private SlaveDtoTwo slaveDtoTwo;
    private SlaveDtoThree slaveDtoThree;
}
