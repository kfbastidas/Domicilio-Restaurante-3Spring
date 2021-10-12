package co.mycompany.restaurante.cliente.domain.patterncommand;

import java.util.Stack;

/**
 * Invocador de comandos. Ejecuta y deshace los comandos
 *
 * @author Kevith Felipe Bastidas.
 */
public class Invoker {

    /**
     * Comando a ser invocado
     */
    private Command cmd;
    /**
     * Pila de operaciones deshacer
     */
    private final Stack<Command> undoStack;

    /**
     * Constructor
     */
    public Invoker() {
        undoStack = new Stack<>();
    }
    /**
     * Actualiza el command concreto
     * @param cmd 
     */
    public void setCommand(Command cmd) {
        this.cmd = cmd;
    }
    /**
     * Obtiene el commando concreto actual
     * @return 
     */
    public Command getCommand() {
        return cmd;
    }

    /**
     * Ejecuta el comando
     */
    public void execute() {
        if (cmd.hasUndo) {
            undoStack.push(cmd);
        }
        cmd.execute();
    }

    /**
     * Ejecuta la operación de deshacer
     */
    public void undo() {
        if (!undoStack.isEmpty()) {
            Command cmdAux = undoStack.pop();
            cmdAux.undo();
        }
    }

    /**
     * Tiene comandos en la pila?
     *
     * @return true si lo tiene, false si no
     */
    public boolean hasCommandUndo() {
        return !undoStack.isEmpty();
    }

}
