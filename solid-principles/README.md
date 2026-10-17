# SOLID Principles - Step By Step Guide

## The Idea

**SOLID** is a set of 5 rules for writing code that is easy to read, easy to change, and easy to test. They are not about one trick. They are about how to **design** classes.

| Letter | Principle | In one sentence | Real life |
|---|---|---|---|
| **S** | Single Responsibility | A class has **one** job, and one reason to change. | A restaurant has a cook and a waiter. If one person does both, everything is slow and messy. |
| **O** | Open / Closed | **Add** new behavior by writing **new** code, not by changing old code. | A power strip: to add a lamp you plug it in. You do not open the wall. |
| **L** | Liskov Substitution | A child class must work **everywhere** its parent works. | If a toy is called "a flying toy", every flying toy must really fly. |
| **I** | Interface Segregation | Many **small** interfaces are better than one **fat** one. | A kids menu does not have the wine list. |
| **D** | Dependency Inversion | Depend on an **interface**, not on a concrete class. | A lamp plugs into a **socket**. It does not care if the power comes from solar or from coal. |

## How This Module Works

This time you mostly **fix the design**, not only write code.

Each principle has:

- a **BAD** example (a class with a `Bad` name, or a comment that says "bad"). It works, but its design is wrong. **Read it, do not change it.**
- a few classes for **you**. They have `TODO` comments and `TEMPORARY` lines. Write the code, and delete the `TEMPORARY` lines.
- a **test class** that checks your work. Many tests also compare your new design with the bad one: the program must do **exactly the same**, only built better. This is called **refactoring**.

| Task | Principle | Classes to finish | Test |
|---|---|---|---|
| 1 | Single Responsibility | `InvoiceCalculator`, `InvoiceFormatter`, `InvoiceRepository`, `InvoiceProcessor` | `SrpTest` |
| 2 | Open / Closed | `DiscountCalculator`, `VipDiscount`, `BlackFridayDiscount` | `OcpTest` |
| 3 | Liskov Substitution | `Eagle`, `Penguin`, `BirdWatcher` | `LspTest` |
| 4 | Interface Segregation | `Printer`, `DocumentScanner`, `FaxSender`, `BasicPrinter`, `AllInOneMachine` | `IspTest` |
| 5 | Dependency Inversion | `SmsSender`, `NotificationService` | `DipTest` |

All classes are in `src/main/java/com/example/solid/<srp|ocp|lsp|isp|dip>/`. Do not change the other classes or the tests.

## Step 1 - Run The Demo

Run `Main` in IntelliJ.

Or in the terminal, from this folder:

```bash
mvn -q compile
java -cp target/classes com.example.solid.Main
```

You see 5 parts. Each part prints what it must show, for example `(must be 800)`. Right now many answers are wrong. This is the starting point. Run `Main` again after each task.

## Step 2 - Run The Tests

```bash
mvn test
```

Many tests are red now. To run only one task:

```bash
mvn test -Dtest=SrpTest
```

---

## Task 1 - Single Responsibility (S)

**Read first:** `srp/BadInvoiceProcessor.java`. One method calculates the total, builds the text, **and** saves the invoice. That is 3 jobs, so 3 reasons to change: the tax changes, the look changes, or the storage changes. Every change risks breaking the other two jobs.

**Your job:** one class for each job, and a small coordinator.

| Class | Its only job |
|---|---|
| `InvoiceCalculator` | numbers (subtotal, total with 20% tax) |
| `InvoiceFormatter` | the text of the invoice |
| `InvoiceRepository` | keeping the invoices (a list in memory) |
| `InvoiceProcessor` | asks the three classes above, in order |

Copy the code of each job from `BadInvoiceProcessor` into the right class. The `TODO` comments tell you how.

Look at the coordinator. It has no `if`, no loop, no tax. It is only 4 lines:

```java
int total = _____.totalInCents(invoice);
String text = _____.format(invoice, total);
_____.save(invoice);
return text;
```

Run `SrpTest`. All 13 tests must be green. One test runs `BadInvoiceProcessor` and your `InvoiceProcessor` with the same invoice and checks that the result is **identical**.

---

## Task 2 - Open / Closed (O)

**Read first:** `ocp/BadDiscountCalculator.java`. For every new kind of customer you must **open the class** and add another `else if`. Old, working code changes again and again.

**Your job:** a calculator that **never changes**. A new discount is a **new class**.

The calculator only knows the `Discount` interface:

```java
public int calculate(int priceInCents, Discount discount) {
    return discount._____(priceInCents);      // the method of the interface
}
```

Then write the two new discounts. Look at `MemberDiscount` first (10% off). `VipDiscount` is 20%, `BlackFridayDiscount` is 30%. The discount is rounded **down**.

Look at the test `calculator_isOpenForExtension...`: it invents a brand new discount **inside the test**, and the calculator accepts it without any change. That is the Open/Closed principle.

Run `OcpTest`. All 9 tests must be green.

---

## Task 3 - Liskov Substitution (L)

**The rule:** if code works with a parent type, it must work with **any child** of it, without surprises.

**The bug:** open `lsp/Penguin.java`. A penguin says it is a `FlyingBird`, and then throws an exception when you ask it to fly:

```java
for (FlyingBird bird : birds) {
    bird.fly();       // BOOM when the bird is a Penguin
}
```

You could "fix" it with a `try/catch`, or an `if (bird instanceof Penguin)`. **That is wrong.** It hides the lie. The real fix is to tell the truth in the design:

- Every `Bird` has a name and eats. (`Bird`)
- Only some birds can fly. (`FlyingBird`, a child of `Bird`)
- A penguin is a `Bird`. It can swim, but it is **not** a `FlyingBird`.

Your steps:

1. `Penguin.java`: change `implements FlyingBird` to `implements Bird`, delete `fly()`, and make `swim()` return `"Penguin swims"`.
2. `Eagle.java`: `fly()` returns `"Eagle soars"` (like `Sparrow`).
3. `BirdWatcher.watch(...)`: call `fly()` on every bird in the list and collect the results.

Look at the type in `watch(List<FlyingBird> birds)`. You cannot give it a penguin, because the **compiler** protects you. That is the best kind of protection.

Run `LspTest`. All 9 tests must be green.

---

## Task 4 - Interface Segregation (I)

**Read first:** `isp/Machine.java`. It is a **fat** interface: `print`, `scan` and `fax`. Now look at `BasicPrinter`. It can only print, but `Machine` forces it to have `scan()` and `fax()`. So it throws "cannot scan". Somebody calls `scan()` on a printer and gets a nasty surprise.

**Your job:** split the fat interface into small ones. Each class gets only what it can do.

| Step | What to do |
|---|---|
| 4a | `Printer`: add `String print(String document);` |
| 4b | `DocumentScanner`: add `String scan();` |
| 4c | `FaxSender`: add `String fax(String document, String number);` |
| 4d | `BasicPrinter`: `implements Printer`. **Delete** `scan()` and `fax()`. |
| 4e | `AllInOneMachine`: `implements Printer, DocumentScanner, FaxSender` |

One method in one interface. That is exactly the idea: a class can **combine** small interfaces, but it is never **forced** to have something it cannot do.

Run `IspTest`. All 9 tests must be green.

---

## Task 5 - Dependency Inversion (D)

**Read first:** `dip/BadNotificationService.java`. The service creates `new EmailSender()` by itself. So:

- it can **never** send an SMS, unless you open and change the service
- you cannot test it without a real email sender

The important class depends on a small detail. We want the opposite: the service depends on the `MessageSender` **interface**, and somebody **gives** it the sender. This is called *dependency injection*.

```text
BEFORE:   NotificationService  ───────►  EmailSender (concrete)
AFTER:    NotificationService  ───────►  MessageSender (interface)  ◄───────  EmailSender
                                                                    ◄───────  SmsSender
```

Your steps:

1. `SmsSender`: write it like `EmailSender` (`"SMS to anna: Hi"`).
2. `NotificationService`: the field must have the type `MessageSender` and must **not** be created with `new`. In the constructor, **save** the sender that was given:

```java
private final _____ sender;               // the interface, not EmailSender

public NotificationService(MessageSender sender) {
    this._____ = sender;
}
```

3. `notifyUsers(...)`: call `notifyUser` for every user and collect the results.

Look at the test `service_usesTheSenderThatWasGiven_evenAFakeOneMadeInTheTest`: the test makes a **fake** sender with one line, and the service works with it. This is why this principle makes code easy to test.

Run `DipTest`. All 9 tests must be green.

---

## Step Last - Everything Green

```bash
mvn test
```

All 49 tests must be green, and `Main` must print the correct answer in every part.

## Common Mistakes

| Problem | Reason |
|---|---|
| SRP: the result is different from the bad version | You changed some logic while moving it. Copy it exactly, then compare. |
| SRP: `InvoiceFormatter` calls the calculator | The formatter gets the total as a parameter. It must not calculate. |
| OCP: you added `if (discount instanceof VipDiscount)` | That is the bad design again. Just call `discount.apply(...)`. |
| LSP: you wrapped `fly()` of the penguin in `try/catch` | Do not hide the lie. Remove `fly()` and `FlyingBird` from the penguin. |
| ISP: `BasicPrinter` still has `scan()` | Delete it. The test checks that the method does not exist. |
| ISP: `BasicPrinter implements Printer, Machine` | It must implement **only** `Printer`. |
| DIP: the service still has `new EmailSender()` | The sender must come from the constructor. |
| DIP: the field has the type `EmailSender` | The type must be the interface `MessageSender`. |

## Rules

Use plain Java only. Do not change the tests, the `Bad...` classes, or the other provided classes.
