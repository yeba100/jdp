
// Computer.java
class Computer {
    private final String cpu;
    private final String gpu;
    private final String internalMemory;
    private final String externalMemory;
    private final String os;
    private final boolean touchScreen;
    private final boolean bluetoothMouse;
    private final boolean bluetoothKeyboard;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.gpu = builder.gpu;
        this.internalMemory = builder.internalMemory;
        this.externalMemory = builder.externalMemory;
        this.os = builder.os;
        this.touchScreen = builder.touchScreen;
        this.bluetoothMouse = builder.bluetoothMouse;
        this.bluetoothKeyboard = builder.bluetoothKeyboard;
    }

    public void showConfig() {
        System.out.println("CPU: " + cpu);
        System.out.println("GPU: " + gpu);
        System.out.println("Internal Memory: " + internalMemory);
        System.out.println("External Memory: " + (externalMemory != null ? externalMemory : "None"));
        System.out.println("OS: " + (os != null ? os : "None"));
        System.out.println("Touch Screen: " + (touchScreen ? "Yes" : "No"));
        System.out.println("Bluetooth Mouse: " + (bluetoothMouse ? "Yes" : "No"));
        System.out.println("Bluetooth Keyboard: " + (bluetoothKeyboard ? "Yes" : "No"));
    }

    // Builder inner class
    public static class Builder {
        private final String cpu;
        private final String gpu;
        private final String internalMemory;
        private String externalMemory;
        private String os;
        private boolean touchScreen;
        private boolean bluetoothMouse;
        private boolean bluetoothKeyboard;

        public Builder(String cpu, String gpu, String internalMemory) {
            this.cpu = cpu;
            this.gpu = gpu;
            this.internalMemory = internalMemory;
        }

        public Builder externalMemory(String val) { this.externalMemory = val; return this; }
        public Builder os(String val) { this.os = val; return this; }
        public Builder touchScreen(boolean val) { this.touchScreen = val; return this; }
        public Builder bluetoothMouse(boolean val) { this.bluetoothMouse = val; return this; }
        public Builder bluetoothKeyboard(boolean val) { this.bluetoothKeyboard = val; return this; }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class Builder{
    public static void main(String[] args) {
        Computer myPC = new Computer.Builder("Intel i9", "RTX 4080", "1TB SSD")
            .externalMemory("2TB HDD")
            .os("Windows 11 Pro")
            .touchScreen(true)
            .bluetoothMouse(true)
            .bluetoothKeyboard(true)
            .build();

        myPC.showConfig();
    }
}
