# Student Management System

**CSIS-1410: Object-Oriented Programming, Team Project**

The Student Management System is a Java-based desktop application designed to manage student records through a graphical user interface. It allows users to add, edit, and delete student information stored in a tabular format, using JPanel components to display and organize data.

The structure includes three primary classes:
- Student, representing individual student entries with properties like UUID, student ID, first and last names, major, and academic year
- StudentPanel, extending JPanel for rendering student details
- Action, an interface extending JButton for defining operations such as adding, editing, and deleting student records.

The application utilizes collections to cache and manage student data, with file I/O operations to read from and write to a CSV file.
