package org.fontys.thelearningmachines;

import org.fontys.thelearningmachines.data.dao.ProcessGenderData;
import org.fontys.thelearningmachines.data.dao.ProcessMemberData;
import org.fontys.thelearningmachines.data.dao.ProcessSpotifyData;
import org.fontys.thelearningmachines.data.reader.FileReadException;

@lombok.extern.slf4j.Slf4j
public class Main {

    public static void main(String[] args) {

        try {
            new ProcessSpotifyData(log);
            new ProcessMemberData(log);
            new ProcessGenderData(log);
        } catch (FileReadException ex) {
            log.error("{}", ex.getMessage());
        }
    }
}
