package org.fontys.thelearningmachines.data.model;

import org.fontys.thelearningmachines.data.model.interfaces.GenderInterface;

import java.text.MessageFormat;

public final class GenderModel implements GenderInterface {

    private String gender;

    public GenderModel(String gender) {
        this.gender = gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Known Genders: {0}", this.getGender() );
    }
}
