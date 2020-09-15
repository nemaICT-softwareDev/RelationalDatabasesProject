package org.fontys.thelearningmachines.data.model;

import org.fontys.thelearningmachines.data.model.interfaces.SpotifyInterface;

import java.text.MessageFormat;

public final class SpotifyModel implements SpotifyInterface {

    private final String name;
    private final String link;

    public SpotifyModel(String name, String link) {
        this.name = name.trim();
        this.link = link.trim();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getLink() {
        return this.link;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} ({1})", this.getLink(), this.getName());
    }
}
