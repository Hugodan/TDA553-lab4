public class CarEventHandler {
    private final Controller controller;
    private final CarView carUI;

    public CarEventHandler(Controller controller, CarView carUI) {
        this.controller = controller;
        this.carUI = carUI;
        attachListeners();
    }

    private void attachListeners() {
        carUI.getGasButton().addActionListener(e -> controller.gas(carUI.getGasAmount()));
        carUI.getBrakeButton().addActionListener(e -> controller.brake(carUI.getGasAmount()));
        carUI.getTurboOnButton().addActionListener(e -> controller.turboOn());
        carUI.getTurboOffButton().addActionListener(e -> controller.turboOff());
        carUI.getLiftBedButton().addActionListener(e -> controller.raiseFlatbed(70));
        carUI.getLowerBedButton().addActionListener(e -> controller.lowerFlatbed(0));
        carUI.getStartButton().addActionListener(e -> controller.startEngine());
        carUI.getStopButton().addActionListener(e -> controller.stopEngine());
        carUI.getAddCarButton().addActionListener(e -> controller.addCar());
        carUI.getRemoveCarButton().addActionListener(e -> controller.removeCar());
    }
}
