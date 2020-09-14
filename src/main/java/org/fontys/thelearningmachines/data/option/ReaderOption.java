package org.fontys.thelearningmachines.data.option;

public class ReaderOption implements ReaderOptionInterface {

    private String pathname;
    private String delimiter = ";";
    private Integer skipRows = 0;

    @Override
    public void setPathname(String pathname) {
        this.pathname = pathname;
    }

    @Override
    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public void setSkipRows(Integer skipRows) {
        this.skipRows = skipRows;
    }

    @Override
    public String getPathname() {
        return pathname;
    }

    @Override
    public String getDelimiter() {
        return delimiter;
    }

    @Override
    public Integer getSkipRows() {
        return skipRows;
    }
}
