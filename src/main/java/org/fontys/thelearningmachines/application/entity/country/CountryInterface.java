package org.fontys.thelearningmachines.application.entity.country;

public interface CountryInterface {

    void setCountryFullName(String countryFullName);
    void setCountryShortName(String countryShortName);
    void setCountryLocalisationCode(String countryLocalisationCode);

    String getCountryFullName();
    String getCountryShortName();
    String getCountryLocalisationCode();
}
