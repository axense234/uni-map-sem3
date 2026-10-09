package a1.controller;

import a1.models.GeometricalObject;
import a1.repo.GORepository;
import a1.repo.RepositoryInterface;

public class GOController {
    protected RepositoryInterface<GeometricalObject> repo;

    public GOController(GORepository repo) {
        this.repo = repo;
    }

    protected void addGeometricalObject(GeometricalObject object) {
        this.repo.store(object);
    }

    protected void removeGeometricalObjectById(int goId) {
        this.repo.removeById(goId);
    }

    protected GeometricalObject[] computeFilteredGeometricalObjectsByVolume() {
        GeometricalObject[] filteredGeometricalObjects;

        // for(int i = 0; i < this.repo.getEntitiesSize();++i){
        // if(this.repo.getEntities()[i])
        // }
    }
}
