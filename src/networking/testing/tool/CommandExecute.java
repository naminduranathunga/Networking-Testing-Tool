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
/**
 *
 * @author Namindu
 */
public class CommandExecute {
    public void execute(String ping, JTextArea jTextArea1){
       // jTextArea1.setText("Y");
        try {
            Process process = Runtime.getRuntime().exec(ping);

            // Read the output of the command
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Set the output in the JTextArea
            jTextArea1.setText(output.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

