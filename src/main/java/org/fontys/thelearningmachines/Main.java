package org.fontys.thelearningmachines;

import org.apache.commons.io.FileUtils;
import org.fontys.thelearningmachines.data.model.SpotifyDataModel;
import org.fontys.thelearningmachines.data.model.SpotifyInterface;
import org.fontys.thelearningmachines.data.reader.FileReadException;
import org.fontys.thelearningmachines.data.reader.ReaderInterface;
import org.fontys.thelearningmachines.data.reader.SpotifyReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(org.fontys.thelearningmachines.Main.class);

    public static void main(String[] args) {
        try {
            ReaderInterface reader = new SpotifyReader("src/main/resources/spotify.csv");

            for (String s : FileUtils.readLines(reader.getFile(), StandardCharsets.UTF_8)) {
                // Declare the delimiter
                String delimiter = ";";

                // Get the parts as strings
                String[] parts = s.split(delimiter);

                // Put the data into the model
                SpotifyInterface spotify = new SpotifyDataModel(parts[0], parts[1]);

                // Output the sanitized data
                logger.warn(spotify.toString());
            }
        } catch (IOException | FileReadException e) {
            logger.error("{}", e.getMessage());
        }
    }
}
