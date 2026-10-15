# Structural Design Patterns - Step By Step Guide

## The Idea

A **design pattern** is a known, proven way to solve a problem that programmers meet again and again.

**Structural** patterns are about one question: **how do we connect classes and objects together?**

In this module you finish small classes for 5 patterns:

| # | Pattern | The problem it solves | Real life |
|---|---|---|---|
| 1 | **Bridge** | Two things can change independently (shapes and colors). I do not want a class for every pair. | Crayons: any drawing can use any crayon. |
| 2 | **Filter** | I need to select some objects from a list, and combine the rules. | Filters in an online shop: "size M" and "under 50 euro". |
| 3 | **Decorator** | I want to add features to an object, without changing its class. | A coffee: add milk, then sugar, then whip. Each one is a layer. |
| 4 | **Facade** | A system is complicated. I want one simple button. | The "Movie mode" button on a remote: it switches on everything. |
| 5 | **Proxy** | I want something that stands in for the real object and controls it. | A photo placeholder: the real photo loads only when you open it. |

## How This Module Works

Each pattern has some classes that are **not finished**. They have `TODO` comments and `TEMPORARY` lines.

For each task: write the code from the `TODO`, and delete the `TEMPORARY` lines.

A test class checks each pattern. Green tests = the task is done.

Many patterns have a **worked example**: a finished class that is almost the same as yours. Read it first!

| Task | Classes to finish | Worked example | Test |
|---|---|---|---|
| 1 Bridge | `Shape`, `Circle`, `GreenColor` | `Square`, `RedColor` | `BridgeTest` |
| 2 Filter | `AdultCriteria`, `AndCriteria` | `CityCriteria` | `FilterTest` |
| 3 Decorator | `MilkDecorator`, `SugarDecorator` | `WhipDecorator` | `DecoratorTest` |
| 4 Facade | `HomeTheaterFacade` | - | `FacadeTest` |
| 5 Proxy | `ImageProxy` | `RealImage` | `ProxyTest` |

All classes are in `src/main/java/com/example/structural/<pattern>/`. Do not change the other classes or the tests.

## Step 1 - Run The Demo

Run `Main` in IntelliJ.

Or in the terminal, from this folder:

```bash
mvn -q compile
java -cp target/classes com.example.structural.Main
```

You see 5 parts. Each part prints what it must show, for example `(must be ...)`. Right now many answers are wrong. This is the starting point. Run `Main` again after each task.

## Step 2 - Run The Tests

```bash
mvn test
```

Many tests are red now. To run only one task:

```bash
mvn test -Dtest=BridgeTest
```

In IntelliJ you can also click the green arrow next to a test class.

---

## Task 1 - Bridge

**Goal:** shapes and colors are **separate**. A shape does not know any color class. It only holds a `Color`. That reference is the **bridge**.

```text
Shape (Circle, Square ...)  ---- bridge ---->  Color (Red, Blue, Green ...)
```

Without a bridge you need `RedCircle`, `BlueCircle`, `RedSquare`, `BlueSquare` ... and every new color means one more class for every shape. With the bridge, a new color is **one** new class.

**1a - `Shape.java`: save the color.** The constructor receives a color. Keep it in the field:

```java
protected Shape(Color color) {
    this._____ = _____;
}
```

**1b - `Circle.java`: write `draw()`.** Read `Square.java` first. It is almost the same:

```java
public String draw() {
    return "Circle filled with " + _____;      // ask the color for its name
}
```

**1c - `GreenColor.java`: a new color.** Read `RedColor.java`. Return the text `"green"`.

Then see the magic: `new Circle(new GreenColor())` and `new Square(new GreenColor())` both work, and you did not change any shape.

Run `BridgeTest`. All 6 tests must be green.

---

## Task 2 - Filter

**Goal:** select people from a list with **rules**, and combine rules.

Every rule is a class with the same method: it takes a list and returns a **new** list with only the matching people. Because they all look the same, you can chain them.

**2a - `AdultCriteria.java`: keep people with age 18 or more.** Read `CityCriteria.java` first. Same loop, different check:

```java
List<Person> result = new ArrayList<>();
for (Person person : people) {
    if (person.getAge() _____ 18) {
        result.add(person);
    }
}
return result;
```

**2b - `AndCriteria.java`: both rules must be true.** The idea is short: filter with the first rule, then filter **that result** with the second rule. No loop needed.

```java
List<Person> afterFirst = first.meetCriteria(people);
return _____.meetCriteria(afterFirst);
```

Run `FilterTest`. All 8 tests must be green.

---

## Task 3 - Decorator

**Goal:** add milk, sugar or whip to a coffee **without changing** the coffee class.

A decorator **is** a coffee, and it also **holds** another coffee. Like layers of an onion:

```text
Sugar( Milk( SimpleCoffee ) )
```

When you ask the outer layer for the price, it asks the layer inside, and then adds its own part.

Read `WhipDecorator.java`. It does exactly this. Now write the two others:

| Class | Description | Price |
|---|---|---|
| `MilkDecorator` | add `", milk"` | add `0.50` |
| `SugarDecorator` | add `", sugar"` | add `0.20` |

```java
public String getDescription() {
    return coffee.getDescription() + _____;
}

public double getCost() {
    return coffee.getCost() + _____;
}
```

Run `DecoratorTest`. All 7 tests must be green. Look at the last tests: you can stack decorators in any order, even the same one twice.

---

## Task 4 - Facade

**Goal:** one simple method instead of many difficult steps.

To watch a movie you must use 3 devices, in the right order. The facade does it for you.

Open `HomeTheaterFacade.java` and write the two methods. The devices are already fields of the class.

`watchMovie(String movie)` - 4 steps, in this order:

```java
projector.on();
sound.on();
sound.setVolume(_____);      // use 10
player.play(_____);          // the movie that was given
```

`endMovie()` - 3 steps, the opposite order:

```java
player.stop();
sound.off();
projector.off();
```

The devices write what they do into a log, and the tests check that the log has the right lines **in the right order**.

Run `FacadeTest`. All 5 tests must be green.

---

## Task 5 - Proxy

**Goal:** do not load the heavy object until somebody really needs it.

`RealImage` is slow to create (in the demo it writes `Loading ...` to the log). `ImageProxy` looks like an `Image`, but it creates the `RealImage` **only at the first `display()`**, and then keeps it.

Open `ImageProxy.java` and write `display()`:

```java
public String display() {
    if (realImage == _____) {                           // not loaded yet?
        realImage = new RealImage(fileName, log);       // load it, one time only
    }
    return realImage._____;                             // ask the real image to show itself
}
```

Run `ProxyTest`. All 7 tests must be green. Two of them check that the image is **not** loaded when the proxy is created, and that it is loaded only **once**, even if you call `display()` many times.

---

## Step Last - Everything Green

```bash
mvn test
```

All 33 tests must be green, and `Main` must print the correct answer in every part.

## Common Mistakes

| Problem | Reason |
|---|---|
| Bridge: `NullPointerException` in `draw()` | `Shape` does not save the color. Write `this.color = color;`. |
| Bridge: the text is `Circle filled with` and nothing after | You forgot `color.fill()`. |
| Filter: `AndCriteria` returns too many people | You did not use the result of the first rule. Give it to the second rule. |
| Filter: the original list changed | Build a **new** list. Never remove from the given list. |
| Decorator: the price is wrong | Use `coffee.getCost()` (the coffee inside), then add. Do not use `super` or a fixed number. |
| Facade: the order is wrong | The tests check the exact order. Follow the numbered steps. |
| Proxy: the image loads many times | Check `realImage == null` before creating it. |
| Proxy: the image loads in the constructor | Load it in `display()`, not when the proxy is created. |

## Rules

Use plain Java only. Do not change the tests or the provided classes.
