package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers ) {

        MinThread minThread = new MinThread(numbers);
        MaxThread maxThread = new MaxThread(numbers);

        minThread.start();
        LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " started");
        maxThread.start();
        LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " started");

        try {
            minThread.join();
            LOGGER.log(Level.INFO, "Thread " + minThread.getName() + " finished");
            maxThread.join();
            LOGGER.log(Level.INFO, "Thread " + maxThread.getName() + " finished");
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }

            Map result = Map.of(
            "min", minThread.getMin(),
            "max", maxThread.getMax()
        );

        LOGGER.log(Level.INFO, "Result: " + result.toString());

        return result;
    }
    // END
}
