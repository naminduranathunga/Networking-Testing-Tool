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
    CommandExecute parent = null;
    
    public TroubleShootNet(CommandExecute p){
        parent = p; 
    }
    
    public void Ping(String ip, JTextArea textArea){
        // Use java class 
        String[] args = new String[2];
        args[0] = "ping";
        args[1] = ip;
        ExecuteCmdRealtime(args, textArea);
    }
    
    public void Tracert(String ip, JTextArea textArea){
        // Use java class 
        String[] args = new String[2];
        args[0] = "tracert";
        args[1] = ip;
        ExecuteCmdRealtime(args, textArea);
    }
    
    public void Netstat(JTextArea textArea){
        // Use java class 
        String[] args = new String[1];
        args[0] = "netstat";
        ExecuteCmdRealtime(args, textArea);
    }
    
    public void Arp(JTextArea textArea){
        // Use java class 
        String[] args = new String[2];
        args[0] = "arp";        
        args[1] = "-a";

        ExecuteCmdRealtime(args, textArea);
    }
    
    private void ExecuteCmdRealtime(String [] args, JTextArea textArea){
        try { //ping google.lk
            textArea.setText("");
            ProcessBuilder processBuilder = new ProcessBuilder(args);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            InputStreamReader isr = new InputStreamReader(process.getInputStream());
            char[] buffer = new char[1024];
            int length = 0;
            
            while ((length = isr.read(buffer)) > 0 && !parent.terminate_next) { //terminate imidiately
                StringBuilder stribuilder = new StringBuilder();
                for (int i = 0; i < length; i++){
                    stribuilder.append(buffer[i]);
                }
                textArea.append(stribuilder.toString());
                //textArea.append("\n");
            }
               
            if (parent.terminate_next){
                //
                process.destroy();
                return;
            }
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
}
