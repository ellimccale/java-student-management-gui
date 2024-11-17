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
├── data/
│   └── StudentData.csv
│
├── src/
│   └── app/
│   	├── Main.java
│   	│
│   	├── model/
│   	│   ├── Student.java
│   	│   ├── Major.java
│   	│
│   	├── ui/
│   	│   ├── MainPanel.java
│   	│   ├── StudentPanel.java
│   	│
│   	├── util/
│   	│   ├── StudentManager.java
│   	│   ├── CsvHandler.java
│
├── test/
│   └── app/
│   	├── model/
│   	│   ├── StudentTest.java
│   	│   ├── MajorTest.java
│   	│
│   	├── util/
│       	├── StudentManagerTest.java
│       	├── CsvHandlerTest.java
```