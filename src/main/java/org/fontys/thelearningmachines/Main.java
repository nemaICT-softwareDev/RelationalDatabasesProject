package org.fontys.thelearningmachines;

import org.fontys.thelearningmachines.data.dao.ProcessGenderData;
import org.fontys.thelearningmachines.data.dao.ProcessMemberData;
import org.fontys.thelearningmachines.data.dao.ProcessSpotifyData;
import org.fontys.thelearningmachines.data.reader.FileReadException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(org.fontys.thelearningmachines.Main.class);

    public static void main(String[] args) throws FileReadException {

            // Process Spotify data
            new ProcessSpotifyData().getSpotifyData(logger);
            // Process Member data
            new ProcessMemberData().getMembers(logger);

            new ProcessGenderData().getGender(logger);


    }
}
