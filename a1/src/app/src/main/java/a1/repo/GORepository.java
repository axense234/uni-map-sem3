package a1.repo;

import a1.models.GeometricalObject;

public class GORepository implements RepositoryInterface<GeometricalObject> {
    protected GeometricalObject[] entities;
    protected int size = 0;

    public GeometricalObject[] getEntities() {
        return this.entities;
    }

    public GeometricalObject getEntityById(int entityId) {
        for (int i = 0; i < this.getEntitiesSize(); ++i) {
            if (this.entities[i].getId() == entityId) {
                return this.entities[i];
            }
        }

        throw new Error("Could not find entity by id.");
    }

    public int getEntitiesSize() {
        return this.size;
    }

    public void store(GeometricalObject entity) {
        this.entities[this.size] = entity;
        this.size++;
    }

    public void removeById(int entityId) {
        int foundEntityIndex = -1;

        for (int i = 0; i < this.size; ++i) {
            if (this.entities[i].getId() == entityId) {
                foundEntityIndex = i;
                break;
            }
        }

        if (foundEntityIndex == -1) {
            throw new Error("Could not find entity by index in order to remove it.");
        }

        GeometricalObject[] newEntities = new GeometricalObject[this.size - 1];

        for (int i = 0; i < foundEntityIndex; ++i) {
            newEntities[i] = this.entities[i];
        }

        for (int i = foundEntityIndex + 1; i < this.size; ++i) {
            newEntities[i] = this.entities[i];
        }

        this.entities = newEntities;
        this.size--;

    }

}
