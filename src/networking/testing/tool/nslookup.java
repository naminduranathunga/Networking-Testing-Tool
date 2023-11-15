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

        try {
            InetAddress[] addresses = InetAddress.getAllByName(domain);

            System.out.println("IP Addresses for " + domain + ":");
            for (InetAddress address : addresses) {
                System.out.println(address.getHostAddress());
            }
            
        } catch (Exception e) 
        {
            System.out.println("Could not find IP for: " + domain);
            e.printStackTrace();
        }
        return " ";
    }
}


