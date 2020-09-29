package org.fontys.thelearningmachines.domain.option;

public class ReaderOption implements ReaderOptionInterface {

    private String pathname;
    private String delimiter;
    private Integer skipRows;
    private Integer limitRows;

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
    public void setLimitRows(Integer limitRows) {
        this.limitRows = limitRows;
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

    @Override
    public Integer getLimitRows() {
        return limitRows;
    }
}
