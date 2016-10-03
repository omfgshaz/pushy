import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import net.iharder.jpushbullet2.Device;
import net.iharder.jpushbullet2.PushbulletClient;
import net.iharder.jpushbullet2.PushbulletException;

public class PushBulletService{
    
    public static PushbulletClient api;
    
    public static List<Device> devices;    
    
    public static void setAPI(String api_token){
        api = new PushbulletClient(api_token);
    }
    
    public static void setDevicesList() throws PushbulletException{
        devices = api.getActiveDevices();
    }
    
    public static DefaultListModel getDevicesList(){
        DefaultListModel list = new DefaultListModel();
        for(Device d : devices){
            list.addElement(d.getNickname());
        }
        return list;
    }
    
    public static String getDeviceID(int index){
        Device d = devices.get(index);
        return d.getIden();
    }
    
    public static String getDeviceName(int index){
        Device d = devices.get(index);
        return d.getNickname();
    }
    
    public static void sendMessage(String id, String t, String b, String n){
        try{    
            api.sendNote(id, t, b);
            JOptionPane.showMessageDialog(null, String.format("Note successfully pushed to %s", n));
        }catch(PushbulletException e){
            JOptionPane.showMessageDialog(null,"ERROR!!");
        }
    }
}





