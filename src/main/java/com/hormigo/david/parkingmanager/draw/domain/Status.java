package com.hormigo.david.parkingmanager.draw.domain;
/**
 * Estados para sorteos
 * @author David Hormigo Ramírez
 * @version 0.0.1
 */
public enum Status {
    NEW("Nuevo"),
    FINISHED("Sorteado"),
    CANCELLED("Cancelado");

    private final String displayName;
    /**
     * Crea un estado nuevo
     * @param displayName Nombre del estado
     */
    private Status(String displayName) {
        this.displayName = displayName;
    }
    /**
     * 
     * @return Nombre del estado
     */
    public String getDisplayName() {
        return displayName;
    }
}
