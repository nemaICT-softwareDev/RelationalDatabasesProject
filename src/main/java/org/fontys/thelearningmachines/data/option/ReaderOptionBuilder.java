package org.fontys.thelearningmachines.data.option;

public final class ReaderOptionBuilder {

    private String pathname;
    private String delimiter = ";";
    private Integer skipRows = 0;

    private ReaderOptionBuilder() {
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

    public ReaderOptionInterface build() {
        ReaderOption readerOption = new ReaderOption();
        readerOption.setPathname(pathname);
        readerOption.setDelimiter(delimiter);
        readerOption.setSkipRows(skipRows);
        return readerOption;
    }
}
