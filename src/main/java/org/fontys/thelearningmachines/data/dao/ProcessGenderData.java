package org.fontys.thelearningmachines.data.dao;

import org.fontys.thelearningmachines.data.model.GenderModel;
import org.fontys.thelearningmachines.data.model.interfaces.GenderInterface;
import org.fontys.thelearningmachines.data.option.ReaderOptionBuilder;
import org.fontys.thelearningmachines.data.option.ReaderOptionInterface;
import org.fontys.thelearningmachines.data.reader.FileReaderImpl;
import org.fontys.thelearningmachines.data.reader.FileReadException;
import org.fontys.thelearningmachines.data.value.PathNames;
import org.slf4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public final class ProcessGenderData {

    public ProcessGenderData(Logger logger) throws FileReadException {

        ReaderOptionInterface options = ReaderOptionBuilder.aReaderOption()
                .withPathname(PathNames.asGenderList())
                .build();

        List<GenderInterface> genderList = new FileReaderImpl(options).getList().stream()
                .map(gender -> new GenderModel(gender[0]))
                .collect(Collectors.toList());

        genderList.forEach(model -> logger.info(model.toString()));
    }
}
