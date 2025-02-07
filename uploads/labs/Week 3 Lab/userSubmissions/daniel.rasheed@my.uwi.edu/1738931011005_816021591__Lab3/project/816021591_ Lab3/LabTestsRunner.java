import java.io.File;

public class LabTestsRunner {
    public static int labNum = 3;

    public static void main(String[] args) {
        try {
            // Get student ID or name from FeedbackGenerator
            File currentDir = new File(".");
            String folderName = currentDir.getCanonicalFile().getParentFile().getParentFile().getName();
            FeedbackGenerator.generateFeedback(folderName, labNum, "", 0); // Initialize to get student details
            String studentName = FeedbackGenerator.getStudentName();

            // Create instances of test classes
            VehicleTests part1 = new VehicleTests();
            VehicleDriverTests part2   = new VehicleDriverTests();
            StationSimulationTests part3= new StationSimulationTests();
            
            // Initialize CSV tracker
            String csvPath = "../../../lab"+labNum+"progress.csv"; // Adjusted path for the CSV file
            CSVProgressTracker tracker = new CSVProgressTracker(csvPath);
            String[] headers = {
                    "Student Name",
                    "Vehicle testFieldsAndModifiers",
                    "Vehicle testThreeArgConstructor",
                    "Vehicle testFourArgConstructor",
                    "Vehicle testToStringMethod",
                    "Vehicle testVehicleClassification",
                    "Vehicle testEqualsMethod",
                    "VehicleDriver testFieldsAndModifiers",
                    "VehicleDriver testConstructor",
                    "VehicleDriver testGetName",
                    "VehicleDriver testAddVehicle",
                    "VehicleDriver testCanDrive",
                    "StationSimulation testMethodsExist",
                    "StationSimulation testRandomNumberGeneration",
                    "StationSimulation testSimulationBehavior"
            };
            tracker.initializeCSV(headers);
            
            // Initialize variables
            int totalScore = 0;
            StringBuilder feedback = new StringBuilder();
            int[] studentResults = new int[headers.length - 1]; // Exclude "Student Name" from results
            
            
            //Run part 1 Tests(VehicleTests)
            feedback.append("Lab 3 Part 1 tests: \n\n");
            
            try{
                studentResults[0]=part1.testFieldsAndModifiers();
                studentResults[1]=part1.testThreeArgConstructor();
                studentResults[2]=part1.testFourArgConstructor();
                studentResults[3]=part1.testToStringMethod();
                studentResults[4]=part1.testVehicleClassification();
                studentResults[5]=part1.testEqualsMethod();
		        feedback.append(part1.getfeedback());
            }catch (Exception e) {
                feedback.append("❌ Error during Vehicle tests: ").append(e.getMessage()).append("\n");
            }
                        //Run part 2 Tests(VehicleDriverTests)
            feedback.append("Lab 3 Part 2 tests: \n\n");
            
            try{
                studentResults[6]=part2.testFieldsAndModifiers();
                studentResults[7]=part2.testConstructor();
                studentResults[8]=part2.testGetName();
                studentResults[9]=part2.testAddVehicle();
                studentResults[10]=part2.testCanDrive();
		        feedback.append(part2.getfeedback());
            }catch (Exception e) {
                feedback.append("❌ Error during Vehicle Driver tests: ").append(e.getMessage()).append("\n");
            }
                        //Run part 1 Tests(VehicleTests)
            feedback.append("Lab 3 Part 3 tests: \n\n");
            
            try{
                studentResults[11]=part3.testMethodsExist();
                studentResults[12]=part3.testRandomNumberGeneration();
                studentResults[13]=part3.testSimulationBehavior();
            	feedback.append(part3.getfeedback());
	   }catch (Exception e) {
                feedback.append("❌ Error during Simulation Station tests: ").append(e.getMessage()).append("\n");
            }
            
            // Append student results to the CSV
            tracker.appendStudentResults(studentName, studentResults);

            // Generate feedback PDF
            FeedbackGenerator.generateFeedback(folderName, labNum, feedback.toString(), totalScore);

            // Print final feedback
            System.out.println(feedback.toString());
            
        } catch (Exception e) {
            System.err.println("❌ Error during test execution: " + e.getMessage());
        }
    }
}
