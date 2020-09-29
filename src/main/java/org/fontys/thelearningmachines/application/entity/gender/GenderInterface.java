package org.fontys.thelearningmachines.application.entity.gender;

import org.fontys.thelearningmachines.application.entity.EntityInterface;

public interface GenderInterface extends EntityInterface {

    void setGender(String gender);

    String getGender();
}
