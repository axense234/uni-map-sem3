package a1.views;

import java.util.Scanner;

import a1.controllers.GeometricalObjectController;
import a1.models.Cube;
import a1.models.Cylinder;
import a1.models.Sphere;
import a1.models.GeometricalObject;

public class GeometricalObjectView {
    protected GeometricalObjectController controller;
    private final Scanner scanner;

    public GeometricalObjectView(GeometricalObjectController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1) Add geometrical object");
            System.out.println("2) Delete geometrical object by id");
            System.out.println("3) Filter and display geometrical objects by volume");
            System.out.println("4) Display geometrical objects");
            System.out.println("0) Exit");
            System.out.print("Choice: ");

            String choice = this.scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    getGeometricalObjectFromUser();
                    break;
                case "2":
                    deleteGeometricalObjectByGivenId();
                    break;
                case "3":
                    filterAndDisplayGeometricalObjectsByVolume();
                    break;
                case "4":
                    displayGeometricalObjects();
                    break;
                case "0":
                    running = false;
                    this.scanner.close();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public void getGeometricalObjectFromUser() {
        GeometricalObject created = null;

        while (created == null) {
            System.out.print("Object Type (Cube, Cylinder, Sphere) or 'cancel': ");
            String type = scanner.nextLine().trim();

            if (type.equalsIgnoreCase("cancel")) {
                System.out.println("Cancelled.");
                return;
            }

            try {
                switch (type.toLowerCase()) {
                    case "cube": {
                        System.out.print("Cube Side: ");
                        int side = Integer.parseInt(scanner.nextLine().trim());
                        created = new Cube(1, side);
                        break;
                    }
                    case "cylinder": {
                        System.out.print("Cylinder Radius: ");
                        int r = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Cylinder Height: ");
                        int h = Integer.parseInt(scanner.nextLine().trim());
                        created = new Cylinder(1, r, h);
                        break;
                    }
                    case "sphere": {
                        System.out.print("Sphere Radius: ");
                        int r = Integer.parseInt(scanner.nextLine().trim());
                        created = new Sphere(1, r);
                        break;
                    }
                    default:
                        System.out.println("Invalid type. Available types: Cube, Cylinder, Sphere.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number: " + e.getMessage());
            }
        }

        controller.addGeometricalObject(created);
        System.out.println("Added: " + created.toString());
    }

    public void deleteGeometricalObjectByGivenId() {
        System.out.print("Id to delete: ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            controller.removeGeometricalObjectById(id);
            System.out.println("Deleted geometrical object with id: " + id + ".");
        } catch (NumberFormatException e) {
            System.out.println("Id must be an integer.");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public void displayGeometricalObjects() {
        System.out.println("Geometrical Objects");
        for (GeometricalObject go : this.controller.getAllGeometricalObjects()) {
            System.out.println(go.toString());
        }
    }

    public void filterAndDisplayGeometricalObjectsByVolume() {
        try {
            System.out.println("Filtered Geometrical Objects (volume > 25)");
            GeometricalObject[] filteredGO = controller.computeFilteredGeometricalObjectsByVolume();
            if (filteredGO.length == 0) {
                System.out.println("No objects match.");
            } else {
                for (GeometricalObject go : filteredGO) {
                    System.out.println(go.toString());
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Volume must be a number.");
        }
    }
}