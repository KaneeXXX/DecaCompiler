package fr.ensimag.deca.tree;

import java.io.PrintStream;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;

public class Return extends AbstractInst {

    private AbstractExpr returnExpr;
    public Return(AbstractExpr returnExpr) {
        this.returnExpr = returnExpr;
    }
    @Override
    protected void codeGenInst(DecacCompiler compiler) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    protected void verifyInst(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass, Type returnType)
            throws ContextualError {
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print("class { ... A FAIRE ... }");
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        returnExpr.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        returnExpr.prettyPrint(s, prefix, true);
    }
    
}
