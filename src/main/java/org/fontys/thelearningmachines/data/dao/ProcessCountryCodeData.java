package org.fontys.thelearningmachines.data.dao;

import org.fontys.thelearningmachines.data.reader.FileReadException;
import org.fontys.thelearningmachines.data.value.PathNames;
import org.slf4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ProcessCountryCodeData {

    public ProcessCountryCodeData(Logger logger) throws FileReadException, FileNotFoundException {

        String filePath = PathNames.asISO3166_1ContryCodes();
        FileInputStream fs = new FileInputStream(filePath);

    }


}
