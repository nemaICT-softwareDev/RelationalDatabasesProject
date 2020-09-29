package org.fontys.thelearningmachines.domain.option;

public final class ReaderOptionBuilder {

    private String pathname;
    private String delimiter;
    private Integer skipRows;
    private Integer limitRows;

    private ReaderOptionBuilder() {
        this.delimiter = ";";
        this.skipRows = 0;
        this.limitRows = 100;
    }

    public static ReaderOptionBuilder aReaderOption() {
        return new ReaderOptionBuilder();
    }

    public ReaderOptionBuilder withPathname(String pathname) {
        this.pathname = pathname;
        return this;
    }

    public ReaderOptionBuilder withDelimiter(String delimiter) {
        this.delimiter = delimiter;
        return this;
    }

    public ReaderOptionBuilder withSkipRows(Integer skipRows) {
        this.skipRows = skipRows;
        return this;
    }

    public ReaderOptionBuilder withLimitRows(Integer limitRows) {
        this.limitRows = limitRows;
        return this;
    }

    public ReaderOptionInterface build() {
        ReaderOption readerOption = new ReaderOption();
        readerOption.setPathname(pathname);
        readerOption.setDelimiter(delimiter);
        readerOption.setSkipRows(skipRows);
        readerOption.setLimitRows(limitRows);
        return readerOption;
    }
}
