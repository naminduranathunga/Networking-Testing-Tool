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
        
        Ifconfig ex=new Ifconfig();
        System.out.println(Ifconfig.getIfconfig()); 
        
        MainWindow m = new MainWindow();
        
        m.setVisible(true);
    }
    
}
