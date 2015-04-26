package business.entity;

import java.io.*;

public enum Sex implements Serializable {
    MALE("男"), FEMALE("女");

    Sex(final String label) {
        this.label = label;
    }

    /**
     * Gets the property value of <code>label</code>.
     *
     * @return The value of <code>label</code>
     */
    public String getLabel() {
        return label;
    }

    private final String label;
}