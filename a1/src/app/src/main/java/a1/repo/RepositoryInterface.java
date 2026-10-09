package a1.repo;

public interface RepositoryInterface<EntityWithId> {
    public EntityWithId[] getEntities();

    public EntityWithId getEntityById(int entityId);

    public void store(EntityWithId entity);

    public void removeById(int entityId);

    public int getEntitiesSize();
}
