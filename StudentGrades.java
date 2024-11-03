import java.util.Scanner;
public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      int numSubjects;
        do {
            System.out.print("Enter the number of subjects (positive integer): ");
            numSubjects = scanner.nextInt();
            if (numSubjects <= 0) {
                System.out.println("Please enter a valid positive number.");
            }
        } while (numSubjects <= 0);

        int[] marks = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            marks[i] = getValidMarks(scanner, i + 1);
        }

        int totalMarks = calculateTotalMarks(marks);
        double averagePercentage = calculateAverage(totalMarks, numSubjects);
        char grade = assignGrade(averagePercentage);
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
    private static int getValidMarks(Scanner scanner, int subjectNumber) {
        int marks;
        do {
            System.out.print("Enter marks for subject " + subjectNumber + " (0-100): ");
            marks = scanner.nextInt();
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid input. Please enter a number between 0 and 100.");
            }
        } while (marks < 0 || marks > 100);
        return marks;
    }
    private static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    
    private static double calculateAverage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }
     private static char assignGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

