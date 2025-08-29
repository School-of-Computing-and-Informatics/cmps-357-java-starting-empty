# CMPS 357 – Java Starter Project with GPT Workflow

This repository contains a minimal Java starter project used in **CMPS 357: Accelerated Software Development Using AI Tools**.  
The goal is to practice **incremental development** while also learning how to use GPT effectively as a coding partner.

---

## What This Example Demonstrates

- A simple **command-line menu system** (`Main` class) that runs until the user chooses to quit.
- **Safe input handling** with `Scanner` to avoid crashes on invalid input.
- A step-by-step build of a **`BankAccount` class**:
    - Start with a stub
    - Add constructor and `toString`
    - Add test objects in `main`
- Implementation and testing of a **`payBills`** method using sample transactions.
- Debugging a **NullPointerException** and fixing it by returning an **unmodifiable copy** of internal lists.

---

## Commit Sequence

The history of this repo is designed as a learning path.  
Each commit corresponds to a step you can follow or reproduce yourself:

1. **Scaffold the CLI menu loop**
    - GPT can generate a while loop with numbered options and input validation.
    - Handlers are left as stubs for you to fill in later.

2. **Refactor and comment**
    - Move `System.out.println` calls into `printMenu()`.
    - Add explanatory comments for input validation.

3. **Create `BankAccount` class (stub → constructor)**
    - Define fields (`id`, `owner`, `balance`).
    - Add constructor, getters, and `toString`.
    - Instantiate a few sample accounts in `main`.

4. **Implement and test `payBills`**
    - Use GPT to generate sample bills in the format:
      ```
      CGI 123.45
      Bellsouth_Telecom 456.78
      ```
    - Apply them to accounts and verify balances.

5. **Debug and fix NullPointerException**
    - GPT suggests safe coding patterns:
        - Return `Collections.unmodifiableList(new ArrayList<>(list))`
        - Add null checks before iteration

---

## How to Use GPT in This Workflow

- **Keep prompts small.** Paste only the relevant method or class.
- **Be explicit.** Say “Add Javadoc only” or “Refactor menu printing.”
- **Iterate.** Compile and run between GPT steps, then commit small changes.
- **Verify.** GPT accelerates coding, but you are responsible for correctness.

---

## How to Run Locally

1. Clone the repository:
   ```bash
   git clone https://github.com/School-of-Computing-and-Informatics/cmps-357-java-starting-empty.git
   cd cmps-357-java-starting-empty
