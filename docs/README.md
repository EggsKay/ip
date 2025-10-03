# Beta User Guide

## 📝 Introduction

**Beta** is a simple, command-line task management application designed for tracking to-do lists, deadlines, and events.
All tasks are saved automatically to your disk and reloaded when you restart the application.

This guide provides an overview of the commands you can use to manage your tasks effectively.

---

## 🚀 Key Features and Commands

ℹ️ **Notes about the command format:**
> * **Commands are case-insensitive.** You can use any capitalization you prefer (e.g., `LIST`, `List`, or `list` are
    all recognized).
> * Words in **UPPER\_CASE** are the parameters to be supplied by the user.
> * Extraneous parameters for commands that do not take parameters (such as `list` or `bye`) will be ignored.
    > e.g. list 123 will be interpreted as list.

### 1. Adding Tasks

#### **`todo`**

* **Format:** `todo DESCRIPTION`
* **Purpose:** Adds a task with no time constraints.

Example: `todo finish A-JavaDoc`

```
Got it. I've added this task:

[T][ ] finish A-JavaDoc

Now you have 1 tasks in the list.
```

---

#### **`deadline`**

* **Format:** `deadline DESCRIPTION /by DATE/TIME`
* **Purpose:** Adds a task that needs to be completed by a specific date/time.

Example: `deadline submit report /by Monday 6pm`

```
Got it. I've added this task:

[D][ ] submit report (by: Monday 6pm)

Now you have 2 tasks in the list.
```

---

#### **`event`**

* **Format:** `event DESCRIPTION /from START_TIME /to END_TIME`
* **Purpose:** Adds a task that starts at a specific time and ends at another.

Example: `event Project Meeting /from 10am /to 11am`

```
Got it. I've added this task:
[E][ ] Project Meeting (from: 10am, to: 11am)
Now you have 3 tasks in the list.
```

---

### 2. Viewing and Searching Tasks

---

#### **`list`**

* **Format:** `list`
* **Purpose:** Displays all tasks currently in the list with their status (marked or unmarked).

Example: `list`

```
Your tasks are:
1.[T][ ] finish A-JavaDoc
2.[D][ ] submit report (by: Monday 6pm)
3.[E][ ] Project Meeting (from: 10am, to: 11am)
```

---

#### **`find`**

* **Format:** `find KEYWORD`
* **Purpose:** Searches for tasks whose descriptions contain the specified keyword.

```
Here are the matching tasks in your list:
1.[D][ ] submit report (by: Monday 6pm)
```

---

### 3. Modifying Tasks

---

#### **`mark`**

* **Format:** `mark INDEX`
* **Purpose:** Marks the task at the specified index as completed.

```
Nice! I've marked this task as done:
[T][X] finish A-JavaDoc
```

---

#### **`unmark`**

* **Format:** `unmark INDEX`
* **Purpose:** Marks the task at the specified index as not completed.
  Example: `unmark 1`

```
OK, I've marked this task as not done yet:
[T][ ] finish A-JavaDoc
```

---

#### **`delete`**

* **Format:** `delete INDEX`
* **Purpose:** Removes the task at the specified index from the list.

Example: `delete 3`

```
Noted. I've removed this task:
[E][ ] Project Meeting (from: 10am, to: 11am)
Now you have 2 tasks in the list.
```

---

### 4. Exiting the Application

#### **`bye`**

* **Format:** `bye`
* **Purpose:** Exits the application and saves all changes automatically.
  Example: `bye`

```
Bye. See you soon!
```

---