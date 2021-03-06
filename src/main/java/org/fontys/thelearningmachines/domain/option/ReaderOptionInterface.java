package org.fontys.thelearningmachines.domain.option;

public interface ReaderOptionInterface {
    void setPathname(String pathname);

    void setDelimiter(String delimiter);

    void setSkipRows(Integer skipRows);

    String getPathname();

    String getDelimiter();

    Integer getSkipRows();
}
