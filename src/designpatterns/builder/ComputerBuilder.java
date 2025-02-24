package designpatterns.builder;

public interface ComputerBuilder {
    ComputerBuilder setType(ComputerType type);
    ComputerBuilder setProcessor(Processor processor);
    ComputerBuilder setRAM(RAM ram);
    ComputerBuilder setStorage(Storage storage);
    Computer build();
}