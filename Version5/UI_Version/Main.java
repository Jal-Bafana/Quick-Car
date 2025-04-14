import com.formdev.flatlaf.FlatIntelliJLaf;
import model.*;
import service.RentalService;
import ui.MainUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        FlatIntelliJLaf.setup();

        RentalService service = new RentalService();
        service.addVehicle(new Car("KA01AB1234", "Honda City"));
        service.addVehicle(new SUV("MH12CD5678", "Hyundai Creta"));
        service.addVehicle(new Car("DL09XY1122", "Maruti Swift"));

        SwingUtilities.invokeLater(() -> new MainUI(service).setVisible(true));
    }
}
