package factory;

import model.Group;

class PublicGroup extends Group {
    public PublicGroup(String name) {
        super(name);
    }

    @Override
    public String getRules() {
        return "Public Group Rules: Everyone can join.";
    }
}
