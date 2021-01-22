package traffic.lights.models;

import traffic.lights.enums.Signal;

import java.util.Arrays;

public class TrafficLight {
    private Signal signal;

    public TrafficLight(String signal) {
        this.setSignal(signal);
    }

    public Signal getSignal() {
        return signal;
    }

    private void setSignal(String signal) {
        this.signal = Signal.valueOf(signal);
    }

    public void changeLightSignal() {
        this.signal = Arrays.stream(Signal.values())
                .filter(s -> {
                    int ordinalNum = this.signal.ordinal() + 1;
                    ordinalNum = (ordinalNum > 2) ? 0 : ordinalNum; //

                    return s.ordinal() == ordinalNum;
                }).findFirst()
                .orElseThrow();
    }
}
