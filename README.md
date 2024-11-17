# Student Management System

**CSIS-1410: Object-Oriented Programming, Team Project**

The Student Management System is a Java-based desktop application designed to manage student records through a graphical user interface. Users can add, edit, and delete student information, which is displayed in a tabular format using JPanel components. The application ensures data persistence through file I/O operations with a CSV file.

## Data Structure

The application models student records with the following data structure:

- **`Student` class**: Represents individual students with the following fields:
  - `uuid`: The seed for `studentId`.
  - `studentId`: A user-provided student ID.
  - `firstName`: The student's first name.
  - `lastName`: The student's last name.
  - `major`: The student's major, represented by the `Major` enum.
  - `year`: The year the student started, as an integer.

- **`Major` enum**: A fixed list of possible student majors. Each major has a display-friendly name for UI purposes.

## File Structure

```
├── data/                              # Resource folder for external data files
│   └── StudentData.csv                # CSV file for storing student records
│
├── src/                               # Main source folder
│   └── app/                           # Base package for the project
│   	├── Main.java                    # Entry point for the application
│   	│
│   	├── model/                       # Package for data-related classes
│   	│   ├── Student.java             # Represents individual students
│   	│   ├── Major.java               # Enum for student majors
│   	│
│   	├── ui/                          # Package for GUI-related classes
│   	│   ├── MainPanel.java           # Main layout for the app
│   	│   ├── StudentPanel.java        # Represents a single student row
│   	│
│   	├── util/                        # Package for utility classes
│   	│   ├── StudentManager.java      # Handles student collection and persistence
│   	│   ├── CsvHandler.java          # Utils for reading/writing CSV files
│
├── test/                              # Unit test source folder
│   └── app/                           # Base package for tests
│   	├── model/
│   	│   ├── StudentTest.java         # Tests for the Student class
│   	│   ├── MajorTest.java           # Tests for the Major enum
│   	│
│   	├── util/
│       	├── StudentManagerTest.java  # Tests for StudentManager
│       	├── CsvHandlerTest.java      # Tests for CsvHandler
```