package a1.repos;

public interface Repo<EntityWithId> {
    public EntityWithId[] getEntities();

    public EntityWithId getEntityById(int entityId);

    public void store(EntityWithId entity);

    public void removeById(int entityId);

    public int getEntitiesSize();
}
