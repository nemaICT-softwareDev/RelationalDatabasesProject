package org.fontys.thelearningmachines.data.model;

import org.fontys.thelearningmachines.data.model.interfaces.GenderInterface;

import java.text.MessageFormat;

public final class GenderModel implements GenderInterface {

    private String genderId;

    public GenderModel(String genderId) {
        this.genderId = genderId;
    }

    @Override
    public String getGenderId() {
        return genderId;
    }

    @Override
    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}", this.getGenderId());
    }
}
