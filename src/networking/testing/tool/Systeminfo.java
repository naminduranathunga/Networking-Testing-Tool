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

public class Systeminfo {
    public static String getSystemInfo() {
        try {
            String command = "systeminfo";

            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder output = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            process.waitFor();
            return output.toString();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }

        return "Error!";
    }
}

