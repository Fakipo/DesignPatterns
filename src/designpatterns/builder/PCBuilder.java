package designpatterns.builder;

public class PCBuilder implements ComputerBuilder{
    private ComputerType type;
    private Processor processor;
    private RAM ram;
    private Storage storage;

    @Override
    public ComputerBuilder setType(ComputerType type) {
        this.type = type;
        return this;
    }
    @Override
    public ComputerBuilder setProcessor(Processor processor) {
        this.processor = processor;
        return this;
    }

    @Override
    public ComputerBuilder setRAM(RAM ram) {
        this.ram = ram;
        return this;
    }

    @Override
    public ComputerBuilder setStorage(Storage storage) {
        this.storage = storage;
        return this;
    }

    @Override
    public Computer build() {
        return new Computer(type, processor, ram, storage);
    }

}
