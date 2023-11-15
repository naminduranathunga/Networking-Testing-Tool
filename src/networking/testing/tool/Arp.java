/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package networking.testing.tool;

/**
 *
 * @author User
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Arp {
    public static String getArpTable() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            String command;
            if (os.contains("win")) {
                command = "arp -a";
            } else {
                command = "ip neigh show"; // Linux equivalent
            }

            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                return output.toString();
            } else {
                return "Error: Command exited with non-zero status";
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error: Exception occurred";
        }
    }
}