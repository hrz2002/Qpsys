package framework.jpa;

import java.io.*;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntityWithLongId implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long entityId;

    @Version
    @Column(nullable = false)
    private long entityVersion;

    public final EntityId getEntityId() {
        return EntityId.valueOf(entityId);
    }

    public final EntityVersion getEntityVersion() {
        return EntityVersion.valueOf(entityVersion);
    }
}
