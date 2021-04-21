package org.iesfm.highschool;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class HighSchool {
    private String name;
    private Map<String, Group> groups;

    public HighSchool(String name, Map<String, Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public boolean groupExists(String groupName) {
        return groups.containsKey(groupName);
    }

    public Set<String> getGroupStudents(String groupName) throws GroupNotFoundException {
        if (!groupExists(groupName)) {
            throw new GroupNotFoundException();
        }

        Group group = groups.get(groupName);
        return group.getStudents();
    }

    public boolean checkStudentInGroup(String student, String groupName) throws GroupNotFoundException {
        return getGroupStudents(groupName).contains(student);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Group> getGroups() {
        return groups;
    }

    public void setGroups(Map<String, Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HighSchool that = (HighSchool) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getGroups(), that.getGroups());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getGroups());
    }
}
