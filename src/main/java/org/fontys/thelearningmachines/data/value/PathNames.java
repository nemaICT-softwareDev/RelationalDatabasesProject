package org.fontys.thelearningmachines.data.value;

public final class PathNames {

    private final String pathname;

    public PathNames(String pathname) {
        this.pathname = pathname;
    }

    public String getPathname() {
        return pathname;
    }

    public static String asSpotify() {
        return new PathNames("src/main/resources/spotify.csv").getPathname();
    }

    public static String asMemberList() {
        return new PathNames("src/main/resources/membersList.csv").getPathname();
    }

    public static String asGenderList() {
        return new PathNames("src/main/resources/genderList.txt").getPathname();
    }

    public static String asISO3166_1ContryCodes() {
        return new PathNames("src/main/resources/ISO3166-1CountryCodes.xls").getPathname();
    }

}
