/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package networking.testing.tool;

import java.io.IOException;
import java.net.*;
import javax.swing.JTextArea;
/**
 *
 * @author Namindu
 */
public class HostName {
 
    public static String HostName() throws IOException{
        InetAddress localh = InetAddress.getLocalHost();
        return localh.getHostName();
    }
    
    public static String getMac() throws Exception {
        StringBuilder macs = new StringBuilder();
        java.util.Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()){
            
            NetworkInterface i = interfaces.nextElement();
            byte [] macaddress = i.getHardwareAddress();
            
            if (macaddress == null) continue;
            
            macs.append(PhtsicalAddressStr(i.getHardwareAddress()));
            macs.append("    ");
            macs.append(i.getDisplayName());
            macs.append("\n");
        }
        
        return macs.toString();
    }
    
    private static String PhtsicalAddressStr(byte[] address){
        StringBuilder addr = new StringBuilder();
        for (int i = 0; i < address.length; i++) {
            
            addr.append(String.format("%02X%s", address[i], (i < address.length - 1) ? "-" : ""));
        }
        return addr.toString();
    }
}
