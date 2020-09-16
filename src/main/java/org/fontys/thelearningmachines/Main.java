package org.fontys.thelearningmachines;

import lombok.extern.slf4j.Slf4j;
import org.fontys.thelearningmachines.data.dao.ProcessSpotifyData;
import org.fontys.thelearningmachines.data.reader.FileReadException;

@Slf4j
public class Main {

    public static void main(String[] args) {
        try {
            new ProcessSpotifyData(log);
//            new ProcessMemberData(log);
//            new ProcessGenderData(log);
        } catch (FileReadException e) {
            log.error("{}", e.getMessage());
        }
    }
}
