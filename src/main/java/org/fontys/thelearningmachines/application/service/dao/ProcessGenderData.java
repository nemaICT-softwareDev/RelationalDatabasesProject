package org.fontys.thelearningmachines.application.service.dao;

import org.fontys.thelearningmachines.application.entity.gender.GenderModel;
import org.fontys.thelearningmachines.application.entity.gender.GenderInterface;
import org.fontys.thelearningmachines.domain.option.ReaderOptionBuilder;
import org.fontys.thelearningmachines.domain.option.ReaderOptionInterface;
import org.fontys.thelearningmachines.application.service.reader.FileReaderImpl;
import org.fontys.thelearningmachines.application.service.reader.FileReadException;
import org.fontys.thelearningmachines.domain.value.PathNames;
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
