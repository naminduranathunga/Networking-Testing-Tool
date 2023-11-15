/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package networking.testing.tool;

import javax.swing.JTextArea;

//new libraries

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JTextArea;
//import static networking.testing.tool.HostName.HostName;
/**
 *
 * @author Namindu
 */
public class CommandExecute {
    public void execute(String command, JTextArea jTextArea1){
        //convert to lowercase
        String[] commands = command.split(" ");
        if (commands.length == 0) {
            //define error
        }
        String command_lower = commands[0].toLowerCase();
        
        jTextArea1.setText("started");
        try {
            if(command_lower.equals("hostname")){
                String output = HostName.getHostName();
                jTextArea1.setText(output);
                
                
            }else if (command_lower.equals("getmac")){
                 String output = HostName.getMac(); 
                 jTextArea1.setText(output);
                 
                 
            }else if (command_lower.equals("getsysteminfo")){
                 String output = Systeminfo.getSystemInfo(); 
                 jTextArea1.setText(output);
                 
                 
            }else if (command_lower.equals("ipconfig") || command_lower.equals("ifconfig")){
                 String output = Ifconfig.getIfconfig(); 
                 jTextArea1.setText(output);
                 
                 
            }else if (command_lower.equals("nslookup")){
                if (commands.length != 2) throw new Exception("The domain is not defined");
                
                 String output = nslookup.getNslookup(commands[1]); 
                 jTextArea1.setText(output);
                 
                 
            }else if (command_lower.equals("ping")){
                 TroubleShootNet t_net = new TroubleShootNet();
                 if (commands.length != 2) throw new Exception("No ip defined");
                 
                 t_net.Ping(commands[1], jTextArea1);
               
                 
            }else{
                jTextArea1.setText("Invaliv command");
            }
        }catch (Exception e) {
            jTextArea1.setText(e.getMessage());
            e.printStackTrace();
        }
    }
}

      
      
           
      
    


