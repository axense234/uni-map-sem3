package a1.controllers;

import java.util.Arrays;
import a1.models.GeometricalObject;
import a1.repos.Repo;

public class GeometricalObjectController {
    protected Repo<GeometricalObject> repo;

    public GeometricalObjectController(Repo<GeometricalObject> repo) {
        this.repo = repo;
    }

    public void addGeometricalObject(GeometricalObject object) {
        try {
            this.repo.getEntityById(object.getId());
            throw new IllegalStateException("Geometrical object already exists");
        } catch (IllegalArgumentException e){
            this.repo.store(object);
        }

    }

    public void removeGeometricalObjectById(int goId) {
        this.repo.removeById(goId);
    }

    public GeometricalObject[] getAllGeometricalObjects() {
        return Arrays.copyOf(this.repo.getEntities(), this.repo.getEntitiesSize());
    }

    public GeometricalObject[] computeFilteredGeometricalObjectsByVolume() {
        int count = 0;
        for (int i = 0; i < this.repo.getEntitiesSize(); ++i) {
            if (this.repo.getEntities()[i].calculateVolume() > 25) {
                count++;
            }
        }

        GeometricalObject[] filteredGeometricalObjects = new GeometricalObject[count];

        int index = 0;
        for (int i = 0; i < this.repo.getEntitiesSize(); ++i) {
            GeometricalObject currentGO = this.repo.getEntities()[i];
            if (currentGO.calculateVolume() > 25) {
                filteredGeometricalObjects[index++] = currentGO;
            }
        }

        return filteredGeometricalObjects;
    }
}
