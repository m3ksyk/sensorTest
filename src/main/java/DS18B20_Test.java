import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.component.temperature.impl.TmpDS18B20DeviceType;
import com.pi4j.io.w1.W1Device;
import com.pi4j.io.w1.W1Master;

import java.io.IOException;
import java.util.List;

public class DS18B20_Test {

    public static void getTemp(){
        W1Master master = new W1Master();
        List<W1Device> w1DeviceList = master.getDevices(TmpDS18B20DeviceType.FAMILY_CODE);

        for(W1Device device : w1DeviceList) {
            //this line is enought if you want to read the temperature
            System.out.println("Temperature: " + ((TemperatureSensor) device).getTemperature());
            //returns the temperature as double rounded to one decimal place after the point

            try {
                System.out.println("1-Wire ID: " + device.getId() +  " value: " + device.getValue());
                //returns the ID of the Sensor and the  full text of the virtual file
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
