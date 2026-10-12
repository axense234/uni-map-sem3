package a1.controller;

import java.util.Arrays;

import a1.models.GeometricalObject;
import a1.repo.GORepository;
import a1.repo.RepositoryInterface;

public class GOController {
    protected RepositoryInterface<GeometricalObject> repo;

    public GOController(GORepository repo) {
        this.repo = repo;
    }

    public void addGeometricalObject(GeometricalObject object) {
        this.repo.store(object);
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
