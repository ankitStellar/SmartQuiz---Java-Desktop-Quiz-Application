# SmartQuiz---Java-Desktop-Quiz-Application
It’s simple, professional, and makes it clear that it's a desktop-based quiz system built in Java.
🧰 Tech Stack
  Java (Swing for GUI)
  SQLite (Embedded database)
  JDBC (for database connectivity
-----------------------------------------------------------------------------------------------------------------
  SmartQuiz/
├── QuizApp.java         // Main GUI and logic
├── DBConnection.java    // Handles database connection
├── quiz.db              // SQLite database with questions
└── README.md

=================================================================================================================
 
 Database Schema
   
   CREATE TABLE questions (
      id INTEGER PRIMARY KEY AUTOINCREMENT,
      question TEXT,
      optionA TEXT,
      optionB TEXT,
      optionC TEXT,
      correct TEXT
  );
