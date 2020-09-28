package org.fontys.thelearningmachines;

import org.fontys.thelearningmachines.application.service.dao.ProcessMemberData;
import org.fontys.thelearningmachines.application.service.reader.FileReadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(org.fontys.thelearningmachines.Main.class);

    public static void main(String[] args) {
        try {
//            new ProcessSpotifyData(log);
            new ProcessMemberData(log);
 //           new ProcessGenderData(log);
        } catch (FileReadException e) {
            log.error("{}", e.getMessage());
        }
    }
}
