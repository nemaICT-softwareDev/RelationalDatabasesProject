package org.fontys.thelearningmachines.application.entity.country;

public final class CountryModel implements CountryInterface {

    private String countryFullName;
    private String countryShortName;
    private String localisationCode;

    @Override
    public String getCountryFullName() {
        return countryFullName;
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
    public void setCountryFullName(String countryFullName) {
        this.countryFullName = countryFullName;
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
