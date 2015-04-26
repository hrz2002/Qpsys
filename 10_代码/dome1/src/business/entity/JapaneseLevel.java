package business.entity;

import java.io.*;

public enum JapaneseLevel implements Serializable {
    A("かなりできる"), B("普通"),C("多少できる"), D("できない");

    JapaneseLevel(final String label) {
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