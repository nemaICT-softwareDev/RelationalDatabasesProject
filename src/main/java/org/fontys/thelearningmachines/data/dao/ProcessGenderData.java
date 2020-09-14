package org.fontys.thelearningmachines.data.dao;

import org.fontys.thelearningmachines.data.model.Gender;
import org.fontys.thelearningmachines.data.model.interfaces.GenderInterface;
import org.fontys.thelearningmachines.data.reader.FileReader;
import org.fontys.thelearningmachines.data.reader.FileReadException;
import org.fontys.thelearningmachines.data.value.PathNames;
import org.slf4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class ProcessGenderData {

    public ProcessGenderData() {}


    public void getGender(Logger logger) throws FileReadException {

        try {
            List<GenderInterface> genderList = new FileReader(PathNames.asGenderList()).getList().stream()
            .map(gender -> new Gender(gender[0]))
                .collect(Collectors.toList());
            genderList.forEach(model -> logger.info(model.toString()));
        }catch (FileReadException ex) {
            logger.error("{}", ex.getMessage());
        }
    }
}
