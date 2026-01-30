package eira.reportservice.fonts;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FontInstaller {

    public static void installFont() {
        try {
            // Path to the font file in resources
            String fontResourcePath = "fonts/Times New Roman.ttf";

            // Load the font file from resources
            InputStream fontStream = FontInstaller.class.getClassLoader().getResourceAsStream(fontResourcePath);
            if (fontStream == null) {
                throw new FileNotFoundException("Font file not found in resources: " + fontResourcePath);
            }

            // Create a custom font directory in the system
            String fontDirPath = "/usr/share/fonts/custom";
            File fontDir = new File(fontDirPath);
            if (!fontDir.exists()) {
                fontDir.mkdirs();
            }

            // Copy the font file to the custom font directory
            File fontFile = new File(fontDir, "Times New Roman.ttf");
            Files.copy(fontStream, fontFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Run font cache update command
            ProcessBuilder pb = new ProcessBuilder("fc-cache", "-fv");
            Process process = pb.start();
            process.waitFor();

            System.out.println("Font installed and font cache updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
