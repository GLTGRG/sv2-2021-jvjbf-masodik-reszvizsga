package city;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public void addBuilding(Building building) {
        int areaCoverage = 0;
        for (Building actual : buildings) {
            areaCoverage += actual.getArea();
        }
        if (areaCoverage + building.getArea() <= fullArea) {
            buildings.add(building);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Building findHighestBuilding(){
        Building highestBuilding = buildings.get(0);
        for (Building b : buildings){
            if (b.getLevels() > highestBuilding.getLevels()){
                highestBuilding = b;
            }
        }
        return highestBuilding;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }
}
