package com.company;

import javax.security.auth.login.FailedLoginException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyTreePerson {
    private String firstName;
    private String lastName;
    private String birthdate;
    private List<FamilyTreePerson> parents;
    private List<FamilyTreePerson> children;

    public FamilyTreePerson(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthdate("n/a");
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public FamilyTreePerson(String birthdate) {
        setFirstName("n/a");
        setLastName("n/a");
        setBirthdate(birthdate);
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public List<FamilyTreePerson> getParents() {
        return parents;
    }

    public List<FamilyTreePerson> getChildren() {
        return children;
    }

    public void addFamilyMember(FamilyTreePerson person, String familyMember) {
        if (familyMember.equals("parent")) {
            this.parents.add(person);
        } else if (familyMember.equals("child")) {
            this.children.add(person);
        }
    }

    @Override
    public String toString() {
        String parents = this.getParents().stream()
                .map(FamilyTreePerson::toStringParentChild)
                .collect(Collectors.joining("\n"));
        String children = this.getChildren().stream()
                .map(FamilyTreePerson::toStringParentChild)
                .collect(Collectors.joining("\n"));

        return String.format("%s %s %s%nParents:%n%sChildren:%n%s",
                this.firstName, this.lastName, this.birthdate, parents, children);
    }

    public String toStringParentChild() {
        return String.format("%s %s %s", this.firstName, this.lastName, this.birthdate);
    }
}
