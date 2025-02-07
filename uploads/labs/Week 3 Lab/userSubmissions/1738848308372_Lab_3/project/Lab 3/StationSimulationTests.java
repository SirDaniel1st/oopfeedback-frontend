import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class StationSimulationTests {

    private StringBuilder feedback = new StringBuilder();
    private int totalScore = 0;

    /**
     * Call this method from your lab runner to execute all tests.
     * It returns the total points awarded.
     */
    public int runTests() {
        totalScore += testMethodsExist();
        totalScore += testRandomNumberGeneration();
        totalScore += testSimulationBehavior();
        return totalScore;
    }

    /**
     * Check for expected methods in StationSimulation.
     */
    public int testMethodsExist() {
        int score = 0;
        feedback.append("\n=== Test: Methods in StationSimulation ===\n");
        try {
            Class<?> simulationClass = Class.forName("StationSimulation");

            // Check for getRandomNumber(int, int)
            Method randomMethod = simulationClass.getMethod("getRandomNumber", int.class, int.class);
            if (randomMethod.getReturnType().equals(int.class)) {
                feedback.append("✅ getRandomNumber(int, int) method exists and returns int.\n");
                score++;
            } else {
                feedback.append("❌ getRandomNumber(int, int) method does not return int.\n");
            }

            // Check for main(String[] args)
            Method mainMethod = simulationClass.getMethod("main", String[].class);
            if (mainMethod.getReturnType().equals(void.class)) {
                feedback.append("✅ main(String[] args) method exists.\n");
                score++;
            } else {
                feedback.append("❌ main(String[] args) method is missing or incorrectly declared.\n");
            }

        } catch (NoSuchMethodException e) {
            feedback.append("❌ Error: Required method missing. ").append(e.getMessage()).append("\n");
        } catch (ClassNotFoundException e) {
            feedback.append("❌ Error: StationSimulation class not found. ").append(e.getMessage()).append("\n");
        } catch (Exception e) {
            feedback.append("❌ Unexpected error: ").append(e.getMessage()).append("\n");
        }
        return score;
    }

    /**
     * Test that getRandomNumber(min, max) returns numbers within the correct range.
     */
    public int testRandomNumberGeneration() {
        int score = 0;
        feedback.append("\n=== Test: Random Number Generation ===\n");
        try {
            Class<?> simulationClass = Class.forName("StationSimulation");
            Method randomMethod = simulationClass.getMethod("getRandomNumber", int.class, int.class);

            boolean passed = true;
            for (int i = 0; i < 100; i++) {
                int result = (int) randomMethod.invoke(null, 1, 10);
                if (result < 1 || result > 10) {
                    feedback.append("❌ getRandomNumber(1, 10) returned out-of-range value: ").append(result).append("\n");
                    passed = false;
                    break;
                }
            }

            if (passed) {
                feedback.append("✅ getRandomNumber(int, int) correctly generates numbers within range.\n");
                score++;
            }

        } catch (Exception e) {
            feedback.append("❌ Error testing getRandomNumber(). ").append(e.getMessage()).append("\n");
        }
        return score;
    }

    /**
     * Test the simulation by ensuring the correct number of vehicles and drivers are created.
     */
    public int testSimulationBehavior() {
        int score = 0;
        feedback.append("\n=== Test: Simulation Behavior ===\n");
        try {
            Class<?> simulationClass = Class.forName("StationSimulation");
            Class<?> vehicleClass = Class.forName("Vehicle");
            Class<?> driverClass = Class.forName("VehicleDriver");

            Constructor<?> vehicleConstructor = vehicleClass.getConstructor(int.class, int.class, int.class, int.class);
            Constructor<?> driverConstructor = driverClass.getConstructor(String.class);
            Method addVehicleMethod = driverClass.getMethod("addVehicle", vehicleClass);
            Method getNameMethod = driverClass.getMethod("getName");

            // Simulate vehicles and drivers
            ArrayList<Object> vehicles = new ArrayList<>();
            ArrayList<Object> drivers = new ArrayList<>();
            String[] names = {"Lou", "Sue", "Drew", "Koo", "Murphy"};

            for (int i = 0; i < 10; i++) {
                vehicles.add(vehicleConstructor.newInstance(1, 2, 3, 4));  // Sample values
            }

            for (String name : names) {
                drivers.add(driverConstructor.newInstance(name));
            }

            // Assign vehicles
            for (Object driver : drivers) {
                int index = (int) simulationClass.getMethod("getRandomNumber", int.class, int.class).invoke(null, 0, 9);
                Object vehicle1 = vehicles.get(index);
                addVehicleMethod.invoke(driver, vehicle1);

                do {
                    index = (int) simulationClass.getMethod("getRandomNumber", int.class, int.class).invoke(null, 0, 9);
                } while (!(boolean) addVehicleMethod.invoke(driver, vehicles.get(index)));  // Assign second vehicle
            }

            // Verify that each driver has exactly two vehicles
            for (Object driver : drivers) {
                Method toStringMethod = driverClass.getMethod("toString");
                String driverInfo = (String) toStringMethod.invoke(driver);
                int vehicleCount = driverInfo.split("\n").length - 1;

                if (vehicleCount == 2) {
                    feedback.append("✅ Driver '").append(getNameMethod.invoke(driver))
                            .append("' correctly assigned 2 vehicles.\n");
                    score++;
                } else {
                    feedback.append("❌ Driver '").append(getNameMethod.invoke(driver))
                            .append("' assigned incorrect number of vehicles (").append(vehicleCount).append(").\n");
                }
            }

        } catch (Exception e) {
            feedback.append("❌ Error testing simulation behavior. ").append(e.getMessage()).append("\n");
        }
        return score;
    }

    /**
     * Returns the feedback/log for all tests that have run so far.
     */
    public String getFeedback() {
        return feedback.toString();
    }
}
