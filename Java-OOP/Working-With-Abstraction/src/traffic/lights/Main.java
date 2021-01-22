package traffic.lights;

import traffic.lights.models.TrafficLight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] trafficLightSignals = reader.readLine().split("\\s+");
        int signalChangeCount = Integer.parseInt(reader.readLine());

        List<TrafficLight> trafficLights = createTrafficLights(trafficLightSignals);
        changeLightSignal(trafficLights, signalChangeCount);
    }

    private static List<TrafficLight> createTrafficLights(String... trafficLightSignals) {
        List<TrafficLight> trafficLightList = new ArrayList<>();

        for (String signal : trafficLightSignals) {
            TrafficLight trafficLight = new TrafficLight(signal);
            trafficLightList.add(trafficLight);
        }

        return trafficLightList;
    }

    private static void changeLightSignal(List<TrafficLight> trafficLights, int signalChangeCount) {
        while (signalChangeCount-- > 0) {
            trafficLights.forEach(tl -> {
                // Change next signal and print it.
                tl.changeLightSignal();
                System.out.print(tl.getSignal() + " ");
            });
            System.out.println();
        }
    }
}
