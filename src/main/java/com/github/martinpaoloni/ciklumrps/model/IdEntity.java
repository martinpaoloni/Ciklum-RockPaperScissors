package com.github.martinpaoloni.ciklumrps.model;

/**
 * Represents an object containing only an ID, as a {@link String}.
 */
public class IdEntity {

    /**
     * The ID.
     */
    private String id;

    /**
     * Gets the ID.
     *
     * @return The ID value.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID value.
     *
     * @param id The ID value.
     */
    public void setId(String id) {
        this.id = id;
    }
}
