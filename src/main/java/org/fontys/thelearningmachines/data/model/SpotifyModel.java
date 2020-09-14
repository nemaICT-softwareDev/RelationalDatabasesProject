package org.fontys.thelearningmachines.data.model;

import org.fontys.thelearningmachines.data.model.interfaces.SpotifyInterface;

import java.text.MessageFormat;

public final class SpotifyModel implements SpotifyInterface {

    private final String id;
    private final String name;

    public SpotifyModel(String id, String name) {
        this.id = id.trim();
        this.name = name.trim();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} ({1})", this.getName(), this.getId());
    }
}
