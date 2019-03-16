package com.ensitech.almacenamiento;

public class PersonaInstance {

    private static final PersonaInstance instance = new PersonaInstance();
    public static PersonaInstance getInstance() {
        if(instance == null){
            return new PersonaInstance();
        }
        return instance;
    }

    private Persona persona = new Persona();
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
