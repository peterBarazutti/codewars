import java.util.*;

public class BallUpwards {

    public static final double G = 9.81; //m/s^2

    public static int maxBall(int v0) {
        double v0_ms = v0 / 3.6;
        double t = 0;
        double h = 0;
        Map<Integer, Double> distanceLog = new HashMap<>();
        while (h >= 0) {
            h = v0_ms * t - 0.5 * G * t * t;
            distanceLog.put((int)Math.round(t*10), h);
            t += 0.1;
        }
        List<Double> heights = new ArrayList<>(distanceLog.values());
        Map.Entry<Integer, Double> maxValue = distanceLog.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(NoSuchElementException::new);
        return maxValue.getKey();
    }

}
