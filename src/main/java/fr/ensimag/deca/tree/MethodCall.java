package fr.ensimag.deca.tree;

import java.io.PrintStream;

import org.apache.commons.lang.Validate;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;

public class MethodCall extends AbstractExpr {
    
    private final AbstractExpr expr;
    private final AbstractIdentifier ident;
    private final ListExpr l;

    public MethodCall(AbstractExpr expr, AbstractIdentifier ident, ListExpr l) {
        Validate.notNull(expr);
        Validate.notNull(ident);
        Validate.notNull(l);
        this.expr = expr;
        this.ident = ident;
        this.l = l;
    }

    public Type verifyExpr(DecacCompiler compiler,
            EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError{return null;} // À modifier

    @Override
    public void decompile(IndentPrintStream s) {
        s.print("class { ... A FAIRE ... }");
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        expr.iter(f);
        ident.iter(f);
        l.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        expr.prettyPrint(s, prefix, false);
        ident.prettyPrint(s, prefix, false);
        l.prettyPrint(s, prefix, true);
    }
}