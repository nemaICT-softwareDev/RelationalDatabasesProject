package org.fontys.thelearningmachines.data.model;

import org.fontys.thelearningmachines.data.interfaces.SpotifyInterface;

import java.text.MessageFormat;

public class SpotifyDataModel implements SpotifyInterface {

    String id;

    String name;

    public SpotifyDataModel(String id, String name) {
        this.id = id;
        this.name = name;
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
