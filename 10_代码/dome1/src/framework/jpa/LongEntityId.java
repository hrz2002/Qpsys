package framework.jpa;

final class LongEntityId extends EntityId {

    private static final long serialVersionUID = 1L;

    LongEntityId(final long idValue) {
        this.idValue = idValue;
    }

    @Override
    public Object getId() {
        return Long.valueOf(getIdValue());
    }

    /**
     * Gets the property value of <code>id</code>.
     * 
     * @return The value of <code>id</code>
     */
    private final long getIdValue() {
        return idValue;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        // MEMO 相手が文字列IDだったときに、文字列表現をLongに変換してみることは
        // やったほうがよいかもしれない(現在は、Longに変換できるものは全て
        // このclassのインスタンスにはるようにはなっている)
        if (obj.getClass().equals(this.getClass())) {
            final LongEntityId object = (LongEntityId) obj;
            return this.getIdValue() == object.getIdValue();
        } else {
            return false;
        }
    }

    @Override
    public final int hashCode() {
        return Long.valueOf(getIdValue()).hashCode();
    }

    @Override
    public String toString() {
        return String.valueOf(getIdValue());
    }

    @Override
    public long toLong() {
        return getIdValue();
    }

    private final long idValue;
}