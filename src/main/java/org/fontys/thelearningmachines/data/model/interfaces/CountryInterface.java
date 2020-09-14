package org.fontys.thelearningmachines.data.model.interfaces;

public interface CountryInterface {

    void setCountryFullName(String countryFullName);
    void setCountryShortName(String countryShortName);
    void setCountryLocalisationCode(String countryLocalisationCode);

    String getCountryFullName();
    String getCountryShortName();
    String getCountryLocalisationCode();
}
