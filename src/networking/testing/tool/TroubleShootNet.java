/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package networking.testing.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JTextArea;

/**
 *
 * @author Namindu
 */
public class TroubleShootNet {
    public void Ping(String ip, JTextArea textArea){
        // Use java class 
        String[] args = new String[2];
        args[0] = "ping";
        args[1] = ip;
        ExecuteCmdRealtime(args, textArea);
    }
    
    private void ExecuteCmdRealtime(String [] args, JTextArea textArea){
        try {
            

            ProcessBuilder processBuilder = new ProcessBuilder(args);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            //StringBuilder output = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                textArea.append(line);
                textArea.append("\n");
                //output.append(line).append("\n");
            }

            process.waitFor();
            //return output.toString();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
}
