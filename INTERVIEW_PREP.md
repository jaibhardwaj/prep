# LLD & Java Interview Preparation Guide

This guide provides a structured framework for approaching Low-Level Design (LLD) interviews, applying object-oriented design principles, and structuring your solution.

---

## ⏱️ The 45-Minute LLD Interview Framework

In a typical 45-minute LLD interview, use this breakdown to ensure you cover all critical components:

### 1. Requirements Clarification (5-10 mins)
*   **Do not start coding immediately.** Ask clarifying questions to define the scope.
*   **Functional Requirements:** What should the system do? (e.g., "Can users book multiple tickets?", "Does the parking lot support trucks?"). List 3-5 core use cases.
*   **Non-Functional Requirements:** Scalability, concurrency requirements, thread safety (e.g., "Multiple users trying to book the same seat simultaneously").
*   **Define Constraints:** Scale of the system, parking space size, active booking windows.

### 2. Identify Core Entities / API Design (10 mins)
*   Look at the nouns in your requirements; these usually translate to **Classes/Entities**.
*   Look at the verbs; these translate to **Methods/APIs**.
*   Write down the signatures of the main API methods (e.g., `bookTicket(Show show, List<Seat> seats, User user)`).

### 3. Establish Relationships & Design Patterns (10 mins)
*   Define how entities interact:
    *   **Association:** Class A uses Class B (e.g., `Driver` has a `Car`).
    *   **Aggregation:** Class A has Class B, but B can exist independently (e.g., `Department` has `Professors`).
    *   **Composition:** Class A owns Class B, and B cannot exist without A (e.g., `Room` belongs to `House`).
*   Incorporate Design Patterns:
    *   Need to support different pricing algorithms? Use **Strategy**.
    *   Need to instantiate complex families of objects? Use **Factory**.
    *   Need to notify multiple subsystems of state changes? Use **Observer**.

### 4. Code Implementation (15 mins)
*   Focus on coding the core logic first. Don't waste time writing getters/setters unless necessary.
*   Write **Clean Code**:
    *   Use descriptive variable and method names.
    *   Keep methods short and focused (Single Responsibility).
    *   Write defensive code (check for nulls, invalid inputs).
*   Address **Concurrency & Thread Safety**: Use `synchronized`, `ReentrantLock`, or thread-safe collections (`ConcurrentHashMap`) where appropriate.

---

## 🛠️ SOLID Principles Checklist

Keep these five principles in mind as you design and implement your classes:

| Principle | Description | How to Apply in LLD |
| :--- | :--- | :--- |
| **S**ingle Responsibility | A class should have only one reason to change. | A `PrintTicket` class should handle ticket formatting, while `ParkingLot` handles spot assignment. |
| **O**pen/Closed | Software entities should be open for extension, but closed for modification. | Use interfaces. If you need a new Payment method, implement a new `PaymentStrategy` instead of editing `PaymentProcessor`. |
| **L**iskov Substitution | Subtypes must be substitutable for their base types without altering correctness. | If `Motorcycle` extends `Vehicle`, it must not override a method in a way that throws `UnsupportedOperationException`. |
| **I**nterface Segregation | Clients should not be forced to depend on methods they do not use. | Break large interfaces into smaller, specific ones (e.g., `Refundable` instead of putting `refund()` in `Payment`). |
| **D**ependency Inversion | Depend on abstractions, not concretions. | Use constructor injection to pass interfaces (e.g., pass `PaymentProcessor` interface, not `StripePaymentProcessor` concrete class). |

---

## 💡 Key Coding Best Practices for Interviews

1.  **Prefer Composition over Inheritance:**
    *   Instead of making `ElectricCar` inherit from `Car`, give `Car` a `FuelType` member variable or composition of `Engine`.
2.  **Encapsulation:**
    *   Keep member variables `private` and expose them through controlled methods.
3.  **State Management:**
    *   Use Enums for states (e.g., `BookingStatus { PENDING, CONFIRMED, CANCELLED }`) rather than raw strings or integers.
4.  **Error Handling:**
    *   Throw custom, descriptive exceptions (e.g., `SeatAlreadyBookedException`) instead of generic `RuntimeExceptions`.
