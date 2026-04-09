package service.checkoutcommand;


// invoker
public class POSTerminal {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand(){
        command.execute();
    }
}
