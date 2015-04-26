package framework.jpa;

final class StringEntityId extends EntityId {

    private static final long serialVersionUID = 1L;

    StringEntityId(final String idValue) {
        assert (idValue != null);
        //
        this.idValue = idValue;
    }

    @Override
    public Object getId() {
        return getIdValue();
    }

    /**
     * Gets the property value of <code>id</code>.
     * 
     * @return The value of <code>id</code>
     */
    private final String getIdValue() {
        return idValue;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(this.getClass())) {
            final StringEntityId object = (StringEntityId) obj;
            return this.getIdValue().equals(object.getIdValue());
        } else {
            return false;
        }
    }

    @Override
    public final int hashCode() {
        assert (getIdValue() != null);
        return getIdValue().hashCode();
    }

    @Override
    public String toString() {
        return getIdValue();
    }

    @Override
    public long toLong() {
        assert (getIdValue() != null);
        //
        return Long.valueOf(getIdValue());
    }

    private final String idValue;
}