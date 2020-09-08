package org.fontys.thelearningmachines.data.value;

public class PathNames {

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
}
