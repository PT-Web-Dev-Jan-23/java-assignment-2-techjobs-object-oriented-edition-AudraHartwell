package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public Job (String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
            this();
            this.name = name;
            this.employer=employer;
            this.location = location;
            this.positionType = positionType;
            this.coreCompetency = coreCompetency;
    }



    public int getId() {
        return id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
    @Override
    public String toString() {
        String nameString = (name == null || name.isBlank()) ? "Data not available" : name;
        String employerString = (employer == null || employer.getValue().isBlank()) ? "Data not available" : String.valueOf(employer);
        String locationString = (location == null || location.getValue().isBlank()) ? "Data not available" : String.valueOf(location);
        String positionTypeString = (positionType == null || positionType.getValue().isBlank()) ? "Data not available" : String.valueOf(positionType);
        String coreCompetencyString = (coreCompetency == null || coreCompetency.getValue().isBlank()) ? "Data not available" : String.valueOf(coreCompetency);

        if ((name == null || name.isBlank()) && (employer == null || employer.getValue().isBlank()) && (location == null || location.getValue().isBlank())
                && (positionType == null || positionType.getValue().isBlank()) && (coreCompetency == null || coreCompetency.getValue().isBlank())) {
            return "OOPS! This job does not seem to exist.";
        }

        return "\n" +
                "ID: " + id + "\n" +
                "Name: " + nameString + "\n" +
                "Employer: " + employerString + "\n" +
                "Location: " + locationString + "\n" +
                "Position Type: " + positionTypeString + "\n" +
                "Core Competency: " + coreCompetencyString +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.id;
    }
}
