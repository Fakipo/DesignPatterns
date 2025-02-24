package designpatterns.builder;

public class Computer {
    private ComputerType type;
    private Processor processor;
    private RAM ram;
    private Storage storage;

    public Computer(ComputerType type, Processor processor, RAM ram, Storage storage) {
        this.type = type;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "\uD83D\uDCBB Computer [Type: " + type + ", Processor: " + processor + ", RAM: " + ram + ", Storage: " + storage + "]";
    }
}