/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package networking.testing.tool;

/**
 *
 * @author User
 */

import java.net.InetAddress;

public class nslookup {
    public static String getNslookup(String domain) {
        //String domain = "example.com"; // Replace with the domain you want to lookup
           StringBuilder str_build = new StringBuilder();
        try {
            InetAddress[] addresses = InetAddress.getAllByName(domain);

            str_build.append("IP Addresses for ");
            str_build.append(domain);
            str_build.append(":");
            for (InetAddress address : addresses) {
                str_build.append(address.getHostAddress());
                str_build.append("\n");
            }
            
        } catch (Exception e) 
        {
            e.printStackTrace();
            return "Could not find IP for: " + domain;
        }
        return str_build.toString();
    }
}


