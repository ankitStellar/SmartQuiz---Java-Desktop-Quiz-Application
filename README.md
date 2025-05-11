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






  # Library Management System – PL/SQL Project

## 📚 Project Overview
This is a PL/SQL-based **Library Management System** designed to manage books, members, and borrowing/returning transactions efficiently. It includes automated fine calculation, availability tracking, and late return logging via triggers.

## 💡 Features
- Add, update, and delete book records
- Member registration and management
- Issue and return books with real-time availability update
- Automatic fine calculation for late returns
- Trigger-based notification for overdue returns
- Report generation using cursors

## 🛠 Technologies Used
- Oracle Database 11g/12c
- PL/SQL (Procedures, Functions, Triggers, Cursors, Exception Handling)
- SQL Developer or any Oracle-compatible IDE

## 📂 Database Schema

### Tables
- `books(book_id, title, author, total_copies, available_copies)`
- `members(member_id, name, join_date)`
- `transactions(trans_id, book_id, member_id, issue_date, return_date, actual_return_date, fine)`
- `audit_log(log_id, trans_id, message, log_date)`

## 🧩 Key Components

### Procedures
- `issue_book`: Issues a book to a member and updates inventory.
- `return_book`: Accepts a returned book, calculates fine, and updates records.

### Functions
- `get_fine_amount`: (Optional) Returns fine based on date difference (can be added).

### Triggers
- `trg_late_return`: Inserts a log entry when a fine is applied due to a late return.

### Cursor
- Fetches all available books and prints a report via `DBMS_OUTPUT`.

## ✅ Setup Instructions

1. Install Oracle DB and SQL Developer.
2. Run the SQL script in the provided order:
   - Table creation
   - Sequence creation
   - Procedure/function/trigger scripts
   - Insert sample data
3. Use `EXEC issue_book(...);` and `EXEC return_book(...);` to simulate transactions.
4. Use the cursor block to print available book reports.

## 📌 Example Use

```sql
-- Issue a book
EXEC issue_book(1, 101);

-- Return a book
EXEC return_book(1001);

-- View Available Books
BEGIN
  -- cursor block here
END;

