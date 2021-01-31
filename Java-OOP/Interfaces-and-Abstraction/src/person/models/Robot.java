package person.models;

import person.interfaces.Identifiable;

public class Robot implements Identifiable {
    private String id;
    private String model;

    public Robot(String id, String model) {
        this.setId(id);
        this.setModel(model);
    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getModel() {
        return model;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
