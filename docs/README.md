# Beta User Guide


## 📝 Introduction

**Beta** is a simple, command-line task management application designed for tracking to-do lists, deadlines, and events. All tasks are saved automatically to your disk and reloaded when you restart the application.

This guide provides an overview of the commands you can use to manage your tasks effectively.

---

## 🚀 Key Features and Commands

ℹ️ **Notes about the command format:**
> * **Commands are case-insensitive.** You can use any capitalization you prefer (e.g., `LIST`, `List`, or `list` are all recognized).
> * Words in **UPPER\_CASE** are the parameters to be supplied by the user.
> * Extraneous parameters for commands that do not take parameters (such as `list` or `bye`) will be ignored.
>   e.g. list 123 will be interpreted as list.
### 1. Adding Tasks

| Command | Format | Purpose |
| :--- | :--- | :--- |
| **`todo`** | `todo DESCRIPTION` | Adds a task with no time constraints. |
| **`deadline`** | `deadline DESCRIPTION /by DATE/TIME` | Adds a task that needs to be completed by a specific date/time. |
| **`event`** | `event DESCRIPTION /from START_TIME /to END_TIME` | Adds a task that starts at a specific time and ends at another. |
---
#### **`todo`**
Adds a generic task to your list.

Example: `todo finish A-JavaDoc`
```
Got it. I've added this task:

[T][ ] finish A-JavaDoc

Now you have 1 tasks in the list.
```
---
#### **`deadline`**
Adds a deadline task with a specified due time.

Example: `deadline submit report /by Monday 6pm`

```
Got it. I've added this task:

[D][ ] submit report (by: Monday 6pm)

Now you have 2 tasks in the list.
```
---
#### **`event`**
Adds an event with a specified start and end time.

Example: `event Project Meeting /from 10am /to 11am`
```
Got it. I've added this task:
[E][ ] Project Meeting (from: 10am, to: 11am)
Now you have 3 tasks in the list.
```
---
### 2. Viewing and Searching Tasks


| Command | Format          | Purpose |
| :--- |:----------------| :--- |
| **`list`** | `list`          | Displays all tasks currently in the list with their status (marked or unmarked). |
| **`find`** |<code>find&nbsp;KEYWORD</code> | Searches for tasks whose descriptions contain the specified keyword. |
---
#### **`list`**
Displays all tasks currently in your list with their status (marked or unmarked).

Example: `list`
```
Your tasks are:
1.[T][ ] finish A-JavaDoc
2.[D][ ] submit report (by: Monday 6pm)
3.[E][ ] Project Meeting (from: 10am, to: 11am)
```
---
#### **`find`**
Searches the list for tasks whose descriptions contain the specified keyword.

Example: `find report`
```
Here are the matching tasks in your list:
1.[D][ ] submit report (by: Monday 6pm)
```

---
### 3. Modifying Tasks
| Command | Format | Purpose |
| :--- | :--- | :--- |
| **`mark`** | `mark INDEX` | Marks the task at the specified index as completed. |
| **`unmark`** | `unmark INDEX` | Marks the task at the specified index as not completed. |
| **`delete`** | `delete INDEX` | Removes the task at the specified index from the list. |
---
#### **`mark`**
Marks a task as completed using its number from the `list` command.

Example: `mark 1`
```
Nice! I've marked this task as done:
[T][X] finish A-JavaDoc
```
---
#### **`unmark`**
Marks a task as not completed (incomplete).

Example: `unmark 1`
```
OK, I've marked this task as not done yet:
[T][ ] finish A-JavaDoc
```
---
#### **`delete`**
Removes a task from the list using its number.

Example: `delete 3`
```
Noted. I've removed this task:
[E][ ] Project Meeting (from: 10am, to: 11am)
Now you have 2 tasks in the list.
```

---

### 4. Exiting the Application
| Command | Format | Purpose |
| :--- | :--- | :--- |
| **`bye`** | `bye` | Exits the application and saves all changes automatically. |
#### **`bye`**
Exits the application. All changes are saved automatically upon exit.

Example: `bye`
```
Bye. See you soon!
```
---