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

    public static String asMemberList() {
    return new PathNames("C:/Users/lopes/Documents/Studie Software engineering 2021/membersList.csv").getPathname();
}
}
