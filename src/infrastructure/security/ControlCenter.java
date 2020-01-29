package infrastructure.security;

import human_ressources.Workplace;

public enum ControlCenter {
    instance;
    private final String roomID = "CO1";
    private Workplace[] workplaces = new Workplace[3];


}
