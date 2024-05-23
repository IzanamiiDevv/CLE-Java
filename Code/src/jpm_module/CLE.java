package jpm_module;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CLE {
    public static String exec(String command) throws IOException, InterruptedException {
        StringBuilder output = new StringBuilder();
        ProcessBuilder processBuilder = new ProcessBuilder();

        // Split the command into its components for ProcessBuilder
        processBuilder.command("cmd.exe", "/c", command);

        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        while ((line = errorReader.readLine()) != null) {
            output.append(line).append("\n");
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new IOException("Command failed with exit code " + exitCode);
        }

        return output.toString();
    }
}
