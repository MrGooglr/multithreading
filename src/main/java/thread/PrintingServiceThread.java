package thread;

import service.PrintingService;

public class PrintingServiceThread implements Runnable{
    @Override
    public void run() {
        PrintingService printingService = new PrintingService();
        printingService.print();
    }
}
