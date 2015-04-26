package framework.jpa;

import java.io.*;

import framework.common.*;

abstract public class EntityId implements Serializable {

    private static final long serialVersionUID = 1L;

    EntityId() {
    }

    abstract public Object getId();

    @Override
    abstract public String toString();

    /**
     * <p>
     * このID値を<code>long</code>に変換する。
     * 変換された値は<code>{@link #valueOf(Long)}</code>による逆変換と互換性がある。
     * ID値が数値に変換できない場合は、<code>{@link NumberFormatException}</code>が送出される。
     * </p>
     *
     * @return ID値の<code>long</code>表現
     * @throws NumberFormatException ID値が<code>long</code>で表現できない場合
     */
    abstract public long toLong();

    static public EntityId valueOf(final String idString) throws Exception {
        final String normalizedIdString = Utility.normalizeString(idString);
        if (normalizedIdString != null) {
            // 新しいEntityは通常longのIDを持つはずなのでこのようにしている。
            // StringベースのIDを持つEntityに関しては、パフォーマンス上劣る。
            try {
                return valueOf(Long.valueOf(normalizedIdString));
            } catch (final NumberFormatException e) {
                // TODO インスタンスの使い回しを。
                return new StringEntityId(normalizedIdString);
            }
        } else {
            return null;
        }
    }

    static public EntityId valueOf(final Long idValue) {
        // TODO インスタンスの使い回しを。使い回しはこちらのクラスの責務。
        if (idValue != null) {
            return new LongEntityId(idValue);
        } else {
            return null;
        }
    }
}