package patterns.structural.adapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class PrinterData {
    LocalDateTime dateTime;
    String message;

    public PrinterData(LocalDateTime dateTime, String message) {
        this.dateTime = dateTime;
        this.message = message;
    }

    public static PrinterData of(String message) {
        return new PrinterData(LocalDateTime.now(), message);
    }
}

interface Printer {
    void printData(PrinterData object);
}

class ConsolePrinter implements Printer {
    @Override
    public void printData(PrinterData object) {
        System.out.println(object.dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(object.message);
    }
}

class IncompatiblePrinter {

    boolean oldAndUglyMethod(char[] mess, String date, String time) {
        System.out.println(date + " " + time);
        System.out.println(mess);
        return true; //No paper jam.
    }
}

public class AdapterExample {
    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        printMessage(printer);

//        IncompatiblePrinter oldPrinter = new IncompatiblePrinter();
//        printMessage(oldPrinter);
    }

    public static void printMessage(Printer printerToUse)
    {
        PrinterData data = PrinterData.of("This is the message to print");
        printerToUse.printData(data);
    }
}
