package framework.jpa;

import java.io.*;

import framework.common.*;

public class EntityVersion implements Serializable, Comparable<EntityVersion> {

    private static final long serialVersionUID = 1L;

    private EntityVersion(final long version) {
        this.entityVersion = version;
    }

    /**
     * <p>
     * プロパティ<code>entityVersion</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>entityVersion</code>の値
     */
    private long getEntityVersion() {
        return entityVersion;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass().equals(obj.getClass())) {
            final EntityVersion object = (EntityVersion) obj;
            return this.getEntityVersion() == object.getEntityVersion();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Long.valueOf(getEntityVersion()).hashCode();
    }

    public int compareTo(final EntityVersion obj) {
        // 安全性をとってif文で検査している。
        final long result = this.getEntityVersion() - obj.getEntityVersion();
        if (result == 0) {
            return 0;
        }
        if (result < 0) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(getEntityVersion());
    }

    static public EntityVersion valueOf(final String versionString) throws Exception {
        final String normalizedVersionString = Utility.normalizeString(versionString);
        if (normalizedVersionString != null) {
            // FIXME 何らかの変換エラーを定義したら、それに書き換える
            return valueOf(Long.valueOf(normalizedVersionString));
        } else {
            return null;
        }
    }

    static public EntityVersion valueOf(final long version) {
        // TODO Improve performance...
        return new EntityVersion(version);
    }
// org.apache.openjpa.persistence.OptimisticLockException
    private final long entityVersion;
}
