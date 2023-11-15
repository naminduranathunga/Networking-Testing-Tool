/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package networking.testing.tool;

/**
 *
 * @author Namindu
 */
public class NetworkingTestingTool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //System.out.println(Ifconfig.getIfconfig()); 
        
        try{
            System.out.println(HostName.HostName());
            System.out.println(HostName.getMac());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
        MainWindow m = new MainWindow();
        
        m.setVisible(true);
    }
    
}
