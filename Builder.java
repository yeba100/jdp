class Computer {
    private final String cpu;
    private final String gpu;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.gpu = builder.gpu;
    }

    public void showConfig() {
        System.out.println("CPU: " + cpu);
        System.out.println("GPU: " + gpu);
    }

    public static class Builder {
        private final String cpu;
        private final String gpu;

        public Builder(String cpu, String gpu) {
            this.cpu = cpu;
            this.gpu = gpu;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class Builder {
    public static void main(String[] args) {
        Computer myPC = new Computer.Builder("Intel i9", "RTX 4080")
            .build();

        myPC.showConfig();
    }
}
