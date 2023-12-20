package fr.ensimag.deca.context;

import fr.ensimag.deca.tools.SymbolTable.Symbol;
import java.util.HashMap;
/**
 * Dictionary associating identifier's ExpDefinition to their names.
 * 
 * This is actually a linked list of dictionaries: each EnvironmentExp has a
 * pointer to a parentEnvironment, corresponding to superblock (eg superclass).
 * 
 * The dictionary at the head of this list thus corresponds to the "current" 
 * block (eg class).
 * 
 * Searching a definition (through method get) is done in the "current" 
 * dictionary and in the parentEnvironment if it fails. 
 * 
 * Insertion (through method declare) is always done in the "current" dictionary.
 * 
 * @author gl36
 * @date 01/01/2024
 */
public class EnvironmentExp {
    // A FAIRE : implémenter la structure de donnée représentant un
    // environnement (association nom -> définition, avec possibilité
    // d'empilement).
    private HashMap<Symbol, ExpDefinition> assocNomDef;
    private EnvironmentExp parentEnvironment;
    
    public EnvironmentExp(EnvironmentExp parentEnvironment) {
        this.parentEnvironment = parentEnvironment;
        this.assocNomDef = new HashMap<Symbol, ExpDefinition>();
    }

    public static class DoubleDefException extends Exception {
        private static final long serialVersionUID = -2733379901827316441L;

        public DoubleDefException(String message) {
            super(message);
        }
    }

    /**
     * Return the definition of the symbol in the environment, or null if the
     * symbol is undefined.
     */
    public ExpDefinition get(Symbol key) {
        if (!assocNomDef.containsKey(key)) {
            return this.parentEnvironment.getAssocNomDef().get(key);
            // Doute: pourquoi pas appel recursive + condition d arret si 
            // env parent est 0 (cad class Object)
        } else {
            return assocNomDef.get(key);
        }
    }

    /**
     * Add the definition def associated to the symbol name in the environment.
     * 
     * Adding a symbol which is already defined in the environment,
     * - throws DoubleDefException if the symbol is in the "current" dictionary 
     * - or, hides the previous declaration otherwise.
     * 
     * @param name
     *            Name of the symbol to define
     * @param def
     *            Definition of the symbol
     * @throws DoubleDefException
     *             if the symbol is already defined at the "current" dictionary
     *
     */
    public void declare(Symbol name, ExpDefinition def) throws DoubleDefException {
        if (assocNomDef.containsKey(name)) {
            throw new DoubleDefException("Symbol already defined in the environment");
        }
        assocNomDef.put(name, def);
    }

    public HashMap<Symbol, ExpDefinition> getAssocNomDef() {
        return this.assocNomDef;
    }

}
