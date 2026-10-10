# Creational Design Patterns - Step By Step Guide

## The Idea

A **design pattern** is a known, proven way to solve a problem that programmers meet again and again.

**Creational** patterns are about one question: **how do we create objects?**

In this module you finish 4 small classes, one for each pattern:

| # | Pattern | The problem it solves | Real life |
|---|---|---|---|
| 1 | **Singleton** | I need exactly **one** object in the whole program. | One president of a country. |
| 2 | **Factory** | I want an object by **name**, without writing `new` myself. | Order "pizza" or "burger" at a counter. The kitchen decides how to make it. |
| 3 | **Builder** | An object has many parts, and some are optional. | Ordering a custom sandwich: bread, then cheese, then salad... |
| 4 | **Immutable** | An object that can **never change** after it is created. | A printed receipt. For a different one, you print a new one. |

## How This Module Works

Each pattern is a class that is **not finished**. It has `TODO` comments and `TEMPORARY` lines.

For each class: write the code from the `TODO`, and delete the `TEMPORARY` lines.

A test class checks each task. Green tests = the task is done.

| Task | Class to finish | Test that checks it |
|---|---|---|
| 1 Singleton | `singleton/AppSettings.java` | `SingletonTest` |
| 2 Factory | `factory/NotificationFactory.java` | `FactoryTest` |
| 3 Builder | `builder/Pizza.java` (the `Builder` inside) | `BuilderTest` |
| 4 Immutable | `immutable/Order.java` | `ImmutableTest` |

Already done, do not change: `Notification`, `EmailNotification`, `SmsNotification`, `PushNotification`, `Main`, and all tests.

## Step 1 - Run The Demo

Run `Main` in IntelliJ.

Or in the terminal, from this folder:

```bash
mvn -q compile
java -cp target/classes com.example.patterns.Main
```

You see 4 parts. Each part prints what it must show, for example `(must be true)`. Right now many answers are wrong. This is the starting point. Run `Main` again after each task.

## Step 2 - Run The Tests

```bash
mvn test
```

Many tests are red now. To run only one task:

```bash
mvn test -Dtest=SingletonTest
```

In IntelliJ you can also click the green arrow next to a test class.

---

## Task 1 - Singleton

**Goal:** only **one** `AppSettings` object can exist.

Today, anybody can write `new AppSettings()` and get a second object. Three changes fix it:

1. Create the one object, inside the class, once.
2. Make the constructor **private**, so nobody else can call `new`.
3. Make `getInstance()` return that one object.

Open `singleton/AppSettings.java` and make it look like this:

```java
public class AppSettings {

    private static final AppSettings INSTANCE = _____;   // 1. create the one object

    private String appName = "My App";

    _____ AppSettings() {                                // 2. which word makes it private?
    }

    public static AppSettings getInstance() {
        return _____;                                    // 3. return the one object
    }
    // ... getAppName / setAppName stay as they are
}
```

Help:

1. `new AppSettings()` is allowed here, inside the class. `static` means "one for the whole class", `final` means "never replaced".
2. The word is `private`.
3. Return `INSTANCE`.

Run `SingletonTest`. All 4 tests must be green.

---

## Task 2 - Factory

**Goal:** `NotificationFactory.create("email")` gives an `EmailNotification`. The caller never writes `new EmailNotification()`.

All 3 notifications have the same type, `Notification`. So the factory can return the right one and the caller only uses `.send(...)`.

Open `factory/NotificationFactory.java`:

```java
public static Notification create(String type) {
    if (type == null) {
        throw new IllegalArgumentException("Type is required");
    }

    switch (type.toLowerCase()) {
        case "email": return _____;
        case "sms":   return _____;
        case "push":  return _____;
        default:      throw new IllegalArgumentException("Unknown type: " + type);
    }
}
```

Help: each blank is `new` + the class name, for example `new EmailNotification()`.

`toLowerCase()` makes `"EMAIL"`, `"Email"` and `"email"` the same.

Run `FactoryTest`. All 7 tests must be green.

---

## Task 3 - Builder

**Goal:** create a pizza step by step, with names, instead of one long constructor.

```java
Pizza pizza = new Pizza.Builder()
        .size("large")
        .cheese(true)
        .mushrooms(true)
        .build();
```

This works because **every builder method returns the builder itself** (`this`). So you can write the next method right after it ("chaining").

Open `builder/Pizza.java` and find the `Builder` class at the bottom. Each small method has two jobs: save the value, and return `this`:

```java
public Builder size(String size) {
    this.size = _____;           // save the value
    return this;
}
```

Do the same for `cheese`, `pepperoni` and `mushrooms`.

Then write `build()`. The size is **required**. Without it, the pizza is not valid:

```java
public Pizza build() {
    if (size == null || _____) {                         // size is missing or empty
        throw new IllegalStateException("Size is required");
    }
    return new Pizza(_____);                             // give the builder to Pizza
}
```

Help: for the empty check use `size.isEmpty()`. The constructor of `Pizza` wants the builder, and the builder is `this`.

Run `BuilderTest`. All 5 tests must be green.

---

## Task 4 - Immutable

**Goal:** an `Order` can never change after it is created.

Today `Order` can be changed in 4 ways. You close them one by one. Each step matches a `TODO` in the file.

| TODO | What to do | Why |
|---|---|---|
| 1 | Write `final` before `class Order`. | Nobody can extend the class and add setters. |
| 2 | Write `final` on both fields. | The fields can never get a new value. |
| 3 | In the constructor: `this.items = List.copyOf(items);` | Keep **your own copy** of the list. If you keep the caller's list, the caller can still change it from outside. `copyOf` makes a copy that also cannot be changed. |
| 4 | Nothing to change in `getItems()`. | The list is already unchangeable, so it is safe to return. |
| 5 | **Delete** `setCustomer` and `addItem`. | An immutable object has no methods that change it. |
| 6 | Write `withItem` (below). | If you want a different order, you create a **new** one. |

`withItem` makes a new order with one more item. The old order stays the same:

```java
public Order withItem(String item) {
    List<String> newItems = new ArrayList<>(items);   // 1. a new list with the same items
    newItems.add(_____);                              // 2. add the new item
    return new Order(_____, newItems);                // 3. a NEW order (same customer)
}
```

You need `import java.util.ArrayList;` at the top.

Run `ImmutableTest`. All 6 tests must be green. The messages tell you which TODO is missing.

---

## Step Last - Everything Green

```bash
mvn test
```

All 22 tests must be green, and `Main` must print the correct answer in every part.

## Common Mistakes

| Problem | Reason |
|---|---|
| `getInstance()` still gives different objects | You wrote `new AppSettings()` inside `getInstance()`. Return `INSTANCE`. |
| `SingletonTest`: constructor must be private | You wrote `public` or nothing. Write `private`. |
| Builder: the pizza has no size | The builder method does not save the value (`this.size = size;`). |
| Builder: chaining does not compile | The method must return `this`, with return type `Builder`. |
| Immutable: the order changes when the list changes | You kept the same list. Use `List.copyOf(items)`. |
| Immutable: `withItem` changes the old order | You added to `items`. Add to the **new** list. |

## Rules

Use plain Java only. Do not change the tests or the provided classes.
