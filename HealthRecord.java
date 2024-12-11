public class HealthRecord {

    private int height;
    private static final int MIN_PERMITTED_HEIGHT = 50;
    private static final int MAX_PERMITTED_HEIGHT = 175;
    private static final int DEFAULT_HEIGHT = 100;

    // Initial values for tallest and shortest height
    private static int tallestHeight = MIN_PERMITTED_HEIGHT;
    private static int shortestHeight = MAX_PERMITTED_HEIGHT;

    // Static fields for counting objects and calculating average height
    private static int counter = 0;
    private static double averageHeight = 0.0;

    // Constructor
    public HealthRecord(int height) {
        counter++;
        setHeight(height);
    }

    // Setter method for height
    public void setHeight(int height) {
        // Temporary variable to store the old height
        int oldHeight = this.height;

        // Check if the input height falls within the permitted range
        if (height >= MIN_PERMITTED_HEIGHT && height <= MAX_PERMITTED_HEIGHT) {
            this.height = height;
        } else {
            this.height = DEFAULT_HEIGHT;
        }

        // Update the tallest and shortest height
        if (this.height > tallestHeight) {
            tallestHeight = this.height;
        }
        if (this.height < shortestHeight) {
            shortestHeight = this.height;
        }

        // Update average height
        averageHeight = ((averageHeight * (counter - 1)) + this.height) / counter;
    }

    // Getter method for height
    public int getHeight() {
        return this.height;
    }

    // Static method to get the tallest height
    public static int getTallestHeight() {
        return tallestHeight;
    }

    // Static method to get the shortest height
    public static int getShortestHeight() {
        return shortestHeight;
    }

    // Static method to get the average height
    public static double getAverageHeight() {
        return averageHeight;
    }

    // Method to display individual student's details
    public void displayDetails() {
        System.out.println("Height (cm): " + getHeight());
    }

    // Static method to display class details
    public static void displayClassDetails() {
        System.out.println("The tallest height (cm): " + getTallestHeight());
        System.out.println("The shortest height (cm): " + getShortestHeight());
        System.out.println("The average height (cm): " + getAverageHeight());
    }

    // Main method to test the HealthRecord class
    public static void main(String[] args) {
        HealthRecord student1 = new HealthRecord(120);
        HealthRecord student2 = new HealthRecord(55);
        HealthRecord student3 = new HealthRecord(180); // This will be replaced by the default value

        student1.displayDetails(); // Should display: 120
        student2.displayDetails(); // Should display: 55
        student3.displayDetails(); // Should display: 100 (default value)

        HealthRecord.displayClassDetails(); // Should display: tallest = 120, shortest = 55, average = 91.666...
    }
}
