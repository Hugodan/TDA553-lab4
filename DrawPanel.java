import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawPanel extends JPanel implements Observer {
    private static class CarImage {
        BufferedImage image;
        Point position;
        CarImage(String imagePath, Car car) {
            try {
                image = ImageIO.read(getClass().getResource(imagePath));
                position = new Point((int) car.getPosX(), (int) car.getPosY());
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
    
    private final CarController carController;
    private final Map<Car, CarImage> carImageMap = new HashMap<>();
    private BufferedImage volvoWorkshopImage;
    private final Point volvoWorkshopPoint = new Point(0, 400);
    
    public DrawPanel(CarController carController, int width, int height) {
        this.carController = carController;
        setDoubleBuffered(true);
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.green);
        carController.addObserver(this);
        for (Car car : carController.getCars()) {
            String imagePath = getCarImagePath(car);
            carImageMap.put(car, new CarImage(imagePath, car));
        }
        try {
            volvoWorkshopImage = ImageIO.read(getClass().getResource("/pics/VolvoBrand.jpg"));
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    
    private String getCarImagePath(Car car) {
        if (car instanceof Volvo240) return "/pics/Volvo240.jpg";
        if (car instanceof Saab95) return "/pics/Saab95.jpg";
        if (car instanceof Scania) return "/pics/Scania.jpg";
        return "/pics/default.jpg";
    }
    
    public void removeCar(Car car) {
        carImageMap.remove(car);
        repaint();
    }
    
    @Override
    public void update() {
        for (Car car : carController.getCars()) {
            if (!carImageMap.containsKey(car)) {
                String imagePath = getCarImagePath(car);
                carImageMap.put(car, new CarImage(imagePath, car));
            }
        }
        carImageMap.keySet().removeIf(car -> !carController.getCars().contains(car));
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : carController.getCars()) {
            CarImage ci = carImageMap.get(car);
            if (ci != null) {
                ci.position.setLocation(car.getPosX(), car.getPosY());
                g.drawImage(ci.image, ci.position.x, ci.position.y, null);
            }
        }
        if (volvoWorkshopImage != null) {
            g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        }
    }
}
