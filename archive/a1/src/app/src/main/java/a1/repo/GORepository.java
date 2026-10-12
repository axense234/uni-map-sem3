package a1.repo;

import a1.models.GeometricalObject;
import java.util.Arrays;

public class GORepository implements RepositoryInterface<GeometricalObject> {
    private static final int INIT_CAP = 10;

    protected GeometricalObject[] entities;
    protected int size;

    public GORepository() {
        this.entities = new GeometricalObject[INIT_CAP];
        this.size = 0;
    }

    @Override
    public void store(GeometricalObject entity) {
        if (this.size == this.entities.length) {
            resize();
        }
        this.entities[this.size++] = entity;
    }

    @Override
    public GeometricalObject getEntityById(int entityId) {
        for (int i = 0; i < this.size; ++i) {
            if (this.entities[i].getId() == entityId) {
                return this.entities[i];
            }
        }
        throw new IllegalArgumentException("No entity with id " + entityId);
    }

    @Override
    public void removeById(int entityId) {
        int idx = -1;
        for (int i = 0; i < this.size; ++i) {
            if (this.entities[i].getId() == entityId) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            throw new IllegalArgumentException("No entity with id " + entityId);
        }

        for (int i = idx; i < this.size - 1; ++i) {
            this.entities[i] = this.entities[i + 1];
        }
        this.entities[--this.size] = null;
    }

    @Override
    public GeometricalObject[] getEntities() {
        return Arrays.copyOf(this.entities, this.size);
    }

    @Override
    public int getEntitiesSize() {
        return this.size;
    }

    private void resize() {
        int newCap = this.entities.length * 2;
        this.entities = Arrays.copyOf(this.entities, newCap);
    }
}