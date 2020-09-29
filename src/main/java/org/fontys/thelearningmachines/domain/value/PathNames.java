package org.fontys.thelearningmachines.domain.value;

public final class PathNames {

    private final String pathname;

    public PathNames(String pathname) {
        this.pathname = pathname;
    }

    @Override
    public String toString() {
        return this.getPathname();
    }

    public String getPathname() {
        return pathname;
    }

    public static String asSpotify() {
        return new PathNames("src/main/resources/import/spotify.csv").toString();
    }

    public static String asMemberList() {
        return new PathNames("src/main/resources/import/membersList.csv").toString();
    }

    public static String asPersonList() {
        return new PathNames("src/main/resources/import/CafePerson.txt").toString();
    }

    public static String asGenderList() {
        return new PathNames("src/main/resources/import/LijstGender.txt").toString();
    }

}
