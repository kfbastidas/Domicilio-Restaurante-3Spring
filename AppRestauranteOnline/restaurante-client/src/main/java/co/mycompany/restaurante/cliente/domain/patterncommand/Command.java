package co.mycompany.restaurante.cliente.domain.patterncommand;

/**
 * Clase abstracta que representa un Comando cualquiera.
 *
 * @author Kevith Felipe Bastidas
 */
public abstract class Command {

    /**
     * ¿Tiene deshacer?
     *
     */
    protected boolean hasUndo;

    /**
     * Ejecuta el comando
     */
    public abstract void execute();

    /**
     * Dehace el comando
     */
    public abstract void undo();
    
    /**
     * Verifica si tiene un desaser.
     * @return 
     */
    public boolean hasUndo() {
        return hasUndo;
    }

    /**
     * Actualiza si se puede desaser.
     * @param hasUndo 
     */
    public void setHasUndo(boolean hasUndo) {
        this.hasUndo = hasUndo;
    }

}
