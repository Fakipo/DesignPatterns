package designpatterns.builder;

// 🎯 Director class orchestrates building a Computer using a ComputerBuilder
public class Director {
    private ComputerBuilder builder;

    public Director() {

    }

    public void setBuilder(ComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer constructPC() {
        return builder.setProcessor(Processor.AMD)
                .setRAM(RAM.GB_16)
                .setStorage(Storage.GB_512)
                .setType(ComputerType.MAC)
                .build();
    }

    public Computer constructLaptop() {
        return builder.setProcessor(Processor.Intel_I3)
                .setRAM(RAM.GB_128)
                .setStorage(Storage.TB_1)
                .setType(ComputerType.WINDOWS)
                .build();
    }
}