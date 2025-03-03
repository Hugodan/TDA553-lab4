import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CarEventHandler {
    private Controller con;
    private CarView carUI;

    public CarEventHandler(Controller c, CarView carUI) {
        this.con = con;
        this.carUI = carUI;
        attachListeners();
    }

    private void attachListeners(){
        carUI.getGasSpinner().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            }
        });
        
        
        carUI.getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con.gas(carUI.getGasAmount());
            }
        });

        carUI.getBrakeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con.brake(carUI.getGasAmount());
            }
        });

        carUI.getTurboOnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con.turboOn();
            }
        });

        carUI.getTurboOffButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con.turboOff();
            }
        });

        carUI.getLiftBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con.raiseFlatbed(70);
            }
        });

        carUI.getLowerBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con.lowerFlatbed(0);
            }
        });

        carUI.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con.startEngine();
            }
        });

        carUI.getStopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con.stopEngine();
            }
        });
    }
}