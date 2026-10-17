package com.example.solid;

import com.example.solid.dip.EmailSender;
import com.example.solid.dip.NotificationService;
import com.example.solid.dip.SmsSender;
import com.example.solid.isp.AllInOneMachine;
import com.example.solid.isp.BasicPrinter;
import com.example.solid.lsp.BirdWatcher;
import com.example.solid.lsp.Eagle;
import com.example.solid.lsp.FlyingBird;
import com.example.solid.lsp.Penguin;
import com.example.solid.lsp.Sparrow;
import com.example.solid.ocp.BlackFridayDiscount;
import com.example.solid.ocp.Discount;
import com.example.solid.ocp.DiscountCalculator;
import com.example.solid.ocp.VipDiscount;
import com.example.solid.srp.Invoice;
import com.example.solid.srp.InvoiceCalculator;
import com.example.solid.srp.InvoiceFormatter;
import com.example.solid.srp.InvoiceProcessor;
import com.example.solid.srp.InvoiceRepository;
import com.example.solid.srp.LineItem;

import java.util.List;

/**
 * Shows all five principles working. Run it to SEE your code.
 * (The tests are the real check. This is the "look at it" version.)
 *
 * PROVIDED CODE - do not change.
 */
public class Main {

    public static void main(String[] args) {
        section("S - Single Responsibility", () -> {
            Invoice invoice = new Invoice("Anna", List.of(
                    new LineItem("Phone", 30000, 2),
                    new LineItem("Case", 1500, 1)));
            InvoiceRepository repository = new InvoiceRepository();
            InvoiceProcessor processor = new InvoiceProcessor(new InvoiceCalculator(), new InvoiceFormatter(), repository);

            System.out.println(processor.process(invoice));
            System.out.println("Saved invoices: " + repository.count() + "   (must be 1)");
            System.out.println("(the text must end with: Total: 738.00)");
        });

        section("O - Open/Closed", () -> {
            DiscountCalculator calculator = new DiscountCalculator();
            Discount tenOff = price -> price - 1000;      // a NEW discount, and the calculator did not change
            System.out.println("VIP:          " + calculator.calculate(1000, new VipDiscount()) + "   (must be 800)");
            System.out.println("Black Friday: " + calculator.calculate(1000, new BlackFridayDiscount()) + "   (must be 700)");
            System.out.println("New discount: " + calculator.calculate(5000, tenOff) + "   (must be 4000)");
        });

        section("L - Liskov Substitution", () -> {
            BirdWatcher watcher = new BirdWatcher();
            List<FlyingBird> birds = List.of(new Sparrow(), new Eagle());
            System.out.println(watcher.watch(birds) + "   (must be [Sparrow flies, Eagle soars])");
            System.out.println(new Penguin().swim() + "   (must be: Penguin swims)");
            System.out.println("Penguin is a FlyingBird? " + FlyingBird.class.isAssignableFrom(Penguin.class) + "   (must be false)");
        });

        section("I - Interface Segregation", () -> {
            System.out.println(new BasicPrinter().print("report") + "   (must be: Printing: report)");
            AllInOneMachine machine = new AllInOneMachine();
            System.out.println(machine.scan() + " / " + machine.fax("report", "555-01"));
            List<String> names = new java.util.ArrayList<>();
            for (Class<?> type : BasicPrinter.class.getInterfaces()) {
                names.add(type.getSimpleName());
            }
            System.out.println("BasicPrinter implements " + names + "   (must be [Printer])");
        });

        section("D - Dependency Inversion", () -> {
            NotificationService sms = new NotificationService(new SmsSender());
            NotificationService email = new NotificationService(new EmailSender());
            System.out.println(sms.notifyUser("anna", "Hi") + "   (must be: SMS to anna: Hi)");
            System.out.println(email.notifyUsers(List.of("a", "b"), "Hi") + "   (must be 2 EMAIL results)");
        });
    }

    // Runs one part. If your code is not finished, it prints the problem and goes on.
    private static void section(String title, Runnable code) {
        System.out.println("=== " + title + " ===");
        try {
            code.run();
        } catch (RuntimeException e) {
            System.out.println("   (not finished yet: " + e + ")");
        }
        System.out.println();
    }
}
