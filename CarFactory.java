public class CarFactory {
    public static Car createCar(String type) {
        return switch (type) {
            case "Volvo240" -> new Volvo240();
            case "Saab95" -> new Saab95();
            case "Scania" -> new Scania();
            default -> throw new IllegalArgumentException("Unknown car type");
        };
    }
}