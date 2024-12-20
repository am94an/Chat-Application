package factory;

import model.Group;

class PrivateGroup extends Group {
    public PrivateGroup(String name) {
        super(name);
    }

    @Override
    public String getRules() {
        return "Private Group Rules: Invitation only.";
    }
}