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
<<<<<<< HEAD
        
        Ifconfig ex=new Ifconfig();
        System.out.println(Ifconfig.getIfconfig()); 
=======
        try{
            System.out.println(HostName.HostName());
            System.out.println(HostName.getMac());
        }catch (Exception ex){
            ex.printStackTrace();
        }
>>>>>>> 69504e46af4441a5d39a87552c02769c3e905df2
        
        MainWindow m = new MainWindow();
        
        m.setVisible(true);
    }
    
}
