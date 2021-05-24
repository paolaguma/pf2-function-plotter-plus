/**
 * An IJVM-like Instruction.
 */
public interface Instruction {
    
    /**
     * Execute this Instruction.
     * @param storage The "memory" to use during the execution
     */
    public abstract void execute(final Storage storage);
    
    /**
     * Get a String with the disassembled Instruction.
     * @return A String-representation of this Instruction.
     */
    public abstract String toString();
    
}
