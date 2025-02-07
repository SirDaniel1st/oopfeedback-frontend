import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class VehicleTests {

    private StringBuilder feedback = new StringBuilder();
    private int totalScore = 0;

    /**
     * Call this method from your lab runner to execute all tests.
     * It returns the total points awarded.
     */
    public int runTests() {
        totalScore += testFieldsAndModifiers();
        totalScore += testThreeArgConstructor();
        totalScore += testFourArgConstructor();
        totalScore += testToStringMethod();
        totalScore += testVehicleClassification();
        totalScore += testEqualsMethod();
        return totalScore;
    }

    /**
     * Check the presence and modifiers of the following fields in Vehicle:
     *  - plateID (String, private)
     *  - plateNumberCounter (int, private static)
     *  - vehicleClassification (int, private)
     */
    public int testFieldsAndModifiers() {
        int score = 0;
        feedback.append("\n=== Test: Fields and Modifiers ===\n");
        try {
            Class<?> vehicleClass = Class.forName("Vehicle");

            // plateID
            Field plateIDField = vehicleClass.getDeclaredField("plateID");
            if (!plateIDField.getType().equals(String.class)) {
                feedback.append("❌ 'plateID' field is not a String.\n");
            } else if (!isPrivate(plateIDField.getModifiers())) {
                feedback.append("❌ 'plateID' field is not private.\n");
            } else {
                feedback.append("✅ 'plateID' field is declared correctly (private String).\n");
                score++;
            }

            // plateNumberCounter
            Field plateCounterField = vehicleClass.getDeclaredField("plateNumberCounter");
            if (plateCounterField.getType() != int.class) {
                feedback.append("❌ 'plateNumberCounter' field is not an int.\n");
            } else if (!isPrivate(plateCounterField.getModifiers()) || !isStatic(plateCounterField.getModifiers())) {
                feedback.append("❌ 'plateNumberCounter' field is not private static.\n");
            } else {
                feedback.append("✅ 'plateNumberCounter' field is declared correctly (private static int).\n");
                score++;
            }

            // vehicleClassification
            Field vehicleClassField = vehicleClass.getDeclaredField("vehicleClassification");
            if (vehicleClassField.getType() != int.class) {
                feedback.append("❌ 'vehicleClassification' field is not an int.\n");
            } else if (!isPrivate(vehicleClassField.getModifiers())) {
                feedback.append("❌ 'vehicleClassification' field is not private.\n");
            } else {
                feedback.append("✅ 'vehicleClassification' field is declared correctly (private int).\n");
                score++;
            }
        } catch (ClassNotFoundException e) {
            feedback.append("❌ Error: Vehicle class not found. ").append(e.getMessage()).append("\n");
        } catch (NoSuchFieldException e) {
            feedback.append("❌ Error: A required field was not found: ").append(e.getMessage()).append("\n");
        } catch (Exception e) {
            feedback.append("❌ Error: Could not complete field checks: ").append(e.getMessage()).append("\n");
        }
        return score;
    }

    /**
     * Test the 3-arg constructor: Vehicle(int length, int breadth, int width)
     * - Creates a Vehicle object, checks if tankCapacity and fuelType are set.
     */
    public int testThreeArgConstructor() {
        int score = 0;
        feedback.append("\n=== Test: 3-Arg Constructor ===\n");
        try {
            Class<?> vehicleClass = Class.forName("Vehicle");
            Constructor<?> threeArgCtor = vehicleClass.getConstructor(int.class, int.class, int.class);

            // Create a Vehicle object
            Object vehicle = threeArgCtor.newInstance(2, 3, 4);  // tankCapacity = 2*3*4=24
            // Check tankCapacity
            Method getTankCapacity = vehicleClass.getMethod("getTankCapacity");
            int tankCapacity = (int) getTankCapacity.invoke(vehicle);

            if (tankCapacity == 24) {
                feedback.append("✅ 3-arg constructor correctly computed tankCapacity (24).\n");
                score++;
            } else {
                feedback.append("❌ 3-arg constructor gave tankCapacity: ").append(tankCapacity)
                        .append(" (expected 24).\n");
            }

            // Check fuelType
            Method getFuelType = vehicleClass.getMethod("getFuelType");
            String fuelType = (String) getFuelType.invoke(vehicle);

            // For even tankCapacity, your code sets "gasoline", odd => "diesel".
            // 24 is even => expected "gasoline".
            if ("gasoline".equals(fuelType)) {
                feedback.append("✅ 3-arg constructor sets correct fuelType ('gasoline').\n");
                score++;
            } else {
                feedback.append("❌ 3-arg constructor sets fuelType: ").append(fuelType)
                        .append(" (expected 'gasoline').\n");
            }
        } catch (NoSuchMethodException e) {
            feedback.append("❌ 3-Arg constructor not found: ").append(e.getMessage()).append("\n");
        } catch (ClassNotFoundException e) {
            feedback.append("❌ Vehicle class not found: ").append(e.getMessage()).append("\n");
        } catch (Exception e) {
            feedback.append("❌ Error testing 3-arg constructor: ").append(e.getMessage()).append("\n");
        }
        return score;
    }

    /**
     * Test the 4-arg constructor: Vehicle(int length, int breadth, int width, int vehicleClassification)
     */
    public int testFourArgConstructor() {
        int score = 0;
        feedback.append("\n=== Test: 4-Arg Constructor ===\n");
        try {
            Class<?> vehicleClass = Class.forName("Vehicle");
            Constructor<?> fourArgCtor = vehicleClass.getConstructor(int.class, int.class, int.class, int.class);

            // Create a Vehicle object
            Object vehicle = fourArgCtor.newInstance(5, 6, 7, 1); 
            // tankCapacity = 5*6*7 = 210 => even => gasoline

            // Check tankCapacity
            Method getTankCapacity = vehicleClass.getMethod("getTankCapacity");
            int capacity = (int) getTankCapacity.invoke(vehicle);

            if (capacity == 210) {
                feedback.append("✅ 4-arg constructor correctly computed tankCapacity (210).\n");
                score++;
            } else {
                feedback.append("❌ 4-arg constructor gave tankCapacity: ")
                        .append(capacity).append(" (expected 210).\n");
            }

            // Check classification
            Method getVehicleClassification = vehicleClass.getMethod("getVehicleClassification");
            int classification = (int) getVehicleClassification.invoke(vehicle);

            if (classification == 1) {
                feedback.append("✅ 4-arg constructor sets correct vehicleClassification (1).\n");
                score++;
            } else {
                feedback.append("❌ 4-arg constructor sets vehicleClassification: ")
                        .append(classification).append(" (expected 1).\n");
            }
        } catch (NoSuchMethodException e) {
            feedback.append("❌ 4-Arg constructor not found: ").append(e.getMessage()).append("\n");
        } catch (ClassNotFoundException e) {
            feedback.append("❌ Vehicle class not found: ").append(e.getMessage()).append("\n");
        } catch (Exception e) {
            feedback.append("❌ Error testing 4-arg constructor: ").append(e.getMessage()).append("\n");
        }
        return score;
    }

    /**
     * Test the toString() method output
     */
    public int testToStringMethod() {
        int score = 0;
        feedback.append("\n=== Test: toString Method ===\n");
        try {
            Class<?> vehicleClass = Class.forName("Vehicle");
            Constructor<?> threeArgCtor = vehicleClass.getConstructor(int.class, int.class, int.class);

            // Create a sample vehicle
            Object vehicle = threeArgCtor.newInstance(2, 3, 4);

            Method toStringMethod = vehicleClass.getMethod("toString");
            String result = (String) toStringMethod.invoke(vehicle);

            // We expect something like:
            // "VEHICLE TANK CAPACITY: 24 FUEL TYPE: gasoline PLATE ID: TABxx VEHICLE CLASSIFICATION: 3 Light Motor Vehicle"
            // We'll do a partial check to see if certain keywords show up:
            if (result == null || result.isBlank()) {
                feedback.append("❌ toString() returned null or blank.\n");
            } else if (!result.contains("VEHICLE TANK CAPACITY: 24") 
                    || !result.contains("FUEL TYPE: gasoline") 
                    || !result.contains("PLATE ID: TAB")
                    || !result.contains("VEHICLE CLASSIFICATION: 3")) {
                feedback.append("❌ toString() does not contain expected details. Got:\n   ")
                        .append(result).append("\n");
            } else {
                feedback.append("✅ toString() appears to include correct capacity, fuel type, plateID, classification.\n");
                score++;
            }
        } catch (Exception e) {
            feedback.append("❌ Error testing toString method: ").append(e.getMessage()).append("\n");
        }
        return score;
    }

    /**
     * Test classification logic: 
     * - setVehicleClassification( int ) 
     * - getVehicleClassification( ) (overload that returns an int)
     * - getVehicleClassification( int ) (overload that returns the corresponding string)
     */
    public int testVehicleClassification() {
        int score = 0;
        feedback.append("\n=== Test: Vehicle Classification ===\n");
        try {
            Class<?> vehicleClass = Class.forName("Vehicle");
            Constructor<?> threeArgCtor = vehicleClass.getConstructor(int.class, int.class, int.class);
            Object vehicle = threeArgCtor.newInstance(1, 1, 2); // capacity=2 => even => gasoline

            Method setVehicleClassification = vehicleClass.getMethod("setVehicleClassification", int.class);
            Method getVehicleClassification = vehicleClass.getMethod("getVehicleClassification");
            Method getVehicleClassificationOverloaded = vehicleClass.getMethod("getVehicleClassification", int.class);

            // Try setting classification to 1 => Motorcycle
            setVehicleClassification.invoke(vehicle, 1);
            int actualClass = (int) getVehicleClassification.invoke(vehicle);
            if (actualClass != 1) {
                feedback.append("❌ setVehicleClassification(1) did not set classification to 1.\n");
            } else {
                String classificationName = (String) getVehicleClassificationOverloaded.invoke(vehicle, 1);
                if ("Motorcycle".equals(classificationName)) {
                    feedback.append("✅ classification=1 => Motorcycle as expected.\n");
                    score++;
                } else {
                    feedback.append("❌ classification=1 => expected 'Motorcycle', got: ")
                            .append(classificationName).append("\n");
                }
            }

            // Try setting classification to 4 => Heavy Motor Vehicle
            setVehicleClassification.invoke(vehicle, 4);
            actualClass = (int) getVehicleClassification.invoke(vehicle);
            if (actualClass != 4) {
                feedback.append("❌ setVehicleClassification(4) did not set classification to 4.\n");
            } else {
                String classificationName = (String) getVehicleClassificationOverloaded.invoke(vehicle, 4);
                if ("Heavy Motor Vehicle".equals(classificationName)) {
                    feedback.append("✅ classification=4 => Heavy Motor Vehicle as expected.\n");
                    score++;
                } else {
                    feedback.append("❌ classification=4 => expected 'Heavy Motor Vehicle', got: ")
                            .append(classificationName).append("\n");
                }
            }

            // Try setting classification to something invalid => defaults to 3
            setVehicleClassification.invoke(vehicle, 2); 
            actualClass = (int) getVehicleClassification.invoke(vehicle);
            if (actualClass == 3) {
                feedback.append("✅ classification=2 => defaulted to 3 as expected.\n");
                score++;
            } else {
                feedback.append("❌ classification=2 => expected 3 (Light Motor Vehicle) fallback, got: ")
                        .append(actualClass).append("\n");
            }
        } catch (Exception e) {
            feedback.append("❌ Error testing classification: ").append(e.getMessage()).append("\n");
        }
        return score;
    }

    /**
     * Test equals(Object obj): 
     * - Create two different Vehicles => should be false
     * - Compare a vehicle with itself => should be true
     */
    public int testEqualsMethod() {
        int score = 0;
        feedback.append("\n=== Test: equals(Object) ===\n");
        try {
            Class<?> vehicleClass = Class.forName("Vehicle");
            Constructor<?> threeArgCtor = vehicleClass.getConstructor(int.class, int.class, int.class);

            // Create two distinct vehicles
            Object v1 = threeArgCtor.newInstance(2, 2, 2);  // capacity=8 => gasoline
            Object v2 = threeArgCtor.newInstance(2, 2, 2);  // capacity=8 => gasoline

            Method equalsMethod = vehicleClass.getMethod("equals", Object.class);

            boolean v1EqualsV2 = (boolean) equalsMethod.invoke(v1, v2);
            boolean v1EqualsV1 = (boolean) equalsMethod.invoke(v1, v1);

            if (!v1EqualsV1) {
                feedback.append("❌ A vehicle should equal itself, but returned false.\n");
            } else {
                feedback.append("✅ A vehicle equals itself.\n");
                score++;
            }

            // Because each new Vehicle normally has a unique plateID,
            // we expect equals to return false here:
            if (v1EqualsV2) {
                feedback.append("❌ Two distinct vehicles have same plateID => equals returned true.\n");
            } else {
                feedback.append("✅ Two distinct vehicles have different plateIDs => equals returned false.\n");
                score++;
            }
        } catch (Exception e) {
            feedback.append("❌ Error testing equals method: ").append(e.getMessage()).append("\n");
        }
        return score;
    }

    // --------------------------------------------------------------------------
    // Helper methods
    // --------------------------------------------------------------------------

    /**
     * Returns the feedback/log for all tests that have run so far.
     */
    public String getFeedback() {
        return feedback.toString();
    }

    private boolean isPrivate(int modifiers) {
        return java.lang.reflect.Modifier.isPrivate(modifiers);
    }

    private boolean isStatic(int modifiers) {
        return java.lang.reflect.Modifier.isStatic(modifiers);
    }
}
