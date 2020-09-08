package org.fontys.thelearningmachines.data.model;

import java.text.MessageFormat;

final public class SpotifyDataModel implements SpotifyInterface {

    private final String id;

    private final String name;

    public SpotifyDataModel(String id, String name) {
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
