package org.fontys.thelearningmachines.data.model;

import org.fontys.thelearningmachines.data.model.interfaces.CountryInterface;

public final class CountryModel implements CountryInterface {

    private String countryFullnName;
    private String countryShortName;
    private String localisationCode;

    @Override
    public void setCountryFullName(String countryFullName) {
        this.countryFullnName = countryFullName;
    }

    @Override
    public void setCountryShortName(String countryShortName) {
        this.countryShortName = countryShortName;
    }

    @Override
    public void setCountryLocalisationCode(String countryLocalizationCode) {
        this.localisationCode = countryLocalizationCode;
    }

    @Override
    public String getCountryFullName() {
        return countryFullnName;
    }

    @Override
    public String getCountryShortName() {
        return countryShortName;
    }

    @Override
    public String getCountryLocalisationCode() {
        return localisationCode;
    }
}
