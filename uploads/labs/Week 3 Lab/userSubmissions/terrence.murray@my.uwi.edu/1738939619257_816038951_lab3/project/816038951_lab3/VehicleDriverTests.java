import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class VehicleDriverTests {

    private StringBuilder feedback = new StringBuilder();
    private int totalScore = 0;

    /**
     * Call this method from your lab runner to execute all tests.
     * It returns the total points awarded.
     */
    public int runTests() {
        totalScore += testFieldsAndModifiers();
        totalScore += testConstructor();
        totalScore += testGetName();
        totalScore += testAddVehicle();
        totalScore += testCanDrive();
        return totalScore;
    }

    /**
     * Check the presence and modifiers of required fields in VehicleDriver.
     */
    public int testFieldsAndModifiers() {
        int score = 0;
        feedback.append("\n=== Test: Fields and Modifiers ===\n");
        try {
            Class<?> driverClass = Class.forName("VehicleDriver");

            // name field
            Field nameField = driverClass.getDeclaredField("name");
            nameField.setAccessible(true);
            if (!nameField.getType().equals(String.class)) {
                feedback.append("❌ 'name' field is not a String.\n");
            } else if (!isPrivate(nameField.getModifiers())) {
                feedback.append("❌ 'name' field is not private.\n");
            } else {
                feedback.append("✅ 'name' field is correctly declared (private String).\n");
                score++;
            }

            // vehicle1 field
            Field vehicle1Field = driverClass.getDeclaredField("vehicle1");
            vehicle1Field.setAccessible(true);
            if (!vehicle1Field.getType().getName().equals("Vehicle")) {
                feedback.append("❌ 'vehicle1' field is not a Vehicle.\n");
            } else if (!isPrivate(vehicle1Field.getModifiers())) {
                feedback.append("❌ 'vehicle1' field is not private.\n");
            } else {
                feedback.append("✅ 'vehicle1' field is correctly declared (private Vehicle).\n");
                score++;
            }

            // vehicle2 field
            Field vehicle2Field = driverClass.getDeclaredField("vehicle2");
            vehicle2Field.setAccessible(true);
            if (!vehicle2Field.getType().getSimpleName().equals("Vehicle")) {
                feedback.append("❌ 'vehicle2' field is not a Vehicle.\n");
            } else if (!isPrivate(vehicle2Field.getModifiers())) {
                feedback.append("❌ 'vehicle2' field is not private.\n");
            } else {
                feedback.append("✅ 'vehicle2' field is correctly declared (private Vehicle).\n");
                score++;
            }

        } catch (Exception e) {
            feedback.append("❌ Error: Could not test fields. " + e.getMessage() + "\n");
        }
        return score;
    }

    /**
     * Test the constructor behavior.
     */
    public int testConstructor() {
        int score = 0;
        feedback.append("\n=== Test: Constructor ===\n");
        try {
            Class<?> driverClass = Class.forName("VehicleDriver");
            Constructor<?> constructor = driverClass.getConstructor(String.class);

            Object driver = constructor.newInstance("Alice");

            // Check initial values
            Field nameField = driverClass.getDeclaredField("name");
            Field vehicle1Field = driverClass.getDeclaredField("vehicle1");
            Field vehicle2Field = driverClass.getDeclaredField("vehicle2");

            nameField.setAccessible(true);
            vehicle1Field.setAccessible(true);
            vehicle2Field.setAccessible(true);

            String name = (String) nameField.get(driver);
            Object vehicle1 = vehicle1Field.get(driver);
            Object vehicle2 = vehicle2Field.get(driver);

            if (!"Alice".equals(name)) {
                feedback.append("❌ Constructor did not correctly assign the name.\n");
            } else {
                feedback.append("✅ Constructor correctly assigns the name.\n");
                score++;
            }

            if (vehicle1 == null && vehicle2 == null) {
                feedback.append("✅ Constructor correctly initializes vehicle1 and vehicle2 to null.\n");
                score++;
            } else {
                feedback.append("❌ Constructor should initialize vehicle1 and vehicle2 as null.\n");
            }

        } catch (Exception e) {
            feedback.append("❌ Error: Could not test constructor. " + e.getMessage() + "\n");
        }
        return score;
    }

    /**
     * Test the getName() method.
     */
    public int testGetName() {
        int score = 0;
        feedback.append("\n=== Test: getName() ===\n");
        try {
            Class<?> driverClass = Class.forName("VehicleDriver");
            Constructor<?> constructor = driverClass.getConstructor(String.class);
            Object driver = constructor.newInstance("Bob");

            Method getNameMethod = driverClass.getMethod("getName");
            String name = (String) getNameMethod.invoke(driver);

            if ("Bob".equals(name)) {
                feedback.append("✅ getName() returns correct name.\n");
                score++;
            } else {
                feedback.append("❌ getName() returned incorrect name: " + name + "\n");
            }
        } catch (Exception e) {
            feedback.append("❌ Error: Could not test getName(). " + e.getMessage() + "\n");
        }
        return score;
    }

    /**
     * Test the addVehicle() method.
     */
    public int testAddVehicle() {
        int score = 0;
        feedback.append("\n=== Test: addVehicle() ===\n");
        try {
            Class<?> driverClass = Class.forName("VehicleDriver");
            Class<?> vehicleClass = Class.forName("Vehicle");

            Constructor<?> driverConstructor = driverClass.getConstructor(String.class);
            Constructor<?> vehicleConstructor = vehicleClass.getConstructor(int.class, int.class, int.class);

            Object driver = driverConstructor.newInstance("Eve");
            Object vehicle1 = vehicleConstructor.newInstance(2, 3, 4);
            Object vehicle2 = vehicleConstructor.newInstance(3, 4, 5);

            Method addVehicleMethod = driverClass.getMethod("addVehicle", vehicleClass);

            boolean added1 = (boolean) addVehicleMethod.invoke(driver, vehicle1);
            boolean added2 = (boolean) addVehicleMethod.invoke(driver, vehicle2);

            if (added1 && added2) {
                feedback.append("✅ addVehicle() correctly assigns vehicles.\n");
                score++;
            } else {
                feedback.append("❌ addVehicle() did not assign vehicles correctly.\n");
            }

        } catch (Exception e) {
            feedback.append("❌ Error: Could not test addVehicle(). " + e.getMessage() + "\n");
        }
        return score;
    }

    /**
     * Test the canDrive() method.
     */
    public int testCanDrive() {
        int score = 0;
        feedback.append("\n=== Test: canDrive() ===\n");
        try {
            Class<?> driverClass = Class.forName("VehicleDriver");
            Class<?> vehicleClass = Class.forName("Vehicle");

            Constructor<?> driverConstructor = driverClass.getConstructor(String.class);
            Constructor<?> vehicleConstructor = vehicleClass.getConstructor(int.class, int.class, int.class);

            Object driver = driverConstructor.newInstance("Tom");
            Object vehicle1 = vehicleConstructor.newInstance(2, 3, 4);
            Object vehicle2 = vehicleConstructor.newInstance(3, 4, 5);
            Object vehicle3 = vehicleConstructor.newInstance(5, 6, 7);

            Method addVehicleMethod = driverClass.getMethod("addVehicle", vehicleClass);
            Method canDriveMethod = driverClass.getMethod("canDrive", vehicleClass);

            addVehicleMethod.invoke(driver, vehicle1);
            addVehicleMethod.invoke(driver, vehicle2);

            boolean result1 = (boolean) canDriveMethod.invoke(driver, vehicle1);
            boolean result2 = (boolean) canDriveMethod.invoke(driver, vehicle3);

            if (result1 && !result2) {
                feedback.append("✅ canDrive() correctly identifies assigned vehicles.\n");
                score++;
            } else {
                feedback.append("❌ canDrive() returned incorrect results.\n");
            }

        } catch (Exception e) {
            feedback.append("❌ Error: Could not test canDrive(). " + e.getMessage() + "\n");
        }
        return score;
    }

    /**
     * Returns the feedback/log for all tests that have run so far.
     */
    public String getFeedback() {
        return feedback.toString();
    }

    private boolean isPrivate(int modifiers) {
        return java.lang.reflect.Modifier.isPrivate(modifiers);
    }
}
