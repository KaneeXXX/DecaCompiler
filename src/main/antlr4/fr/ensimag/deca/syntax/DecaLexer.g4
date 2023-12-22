lexer grammar DecaLexer;

options {
   language = Java;
   // Tell ANTLR to make the generated lexer class extend the
   // the named class, which is where any supporting code and
   // variables will be placed.
   superClass = AbstractDecaLexer;
}

@members {
}

// fragment rules are used by other rules, but do not produce tokens:
fragment LETTER : 'a' .. 'z' | 'A' .. 'Z';
fragment DIGIT : '0' .. '9';
fragment POSITIVE_DIGIT : '1' .. '9';
fragment NUM : DIGIT+;
fragment SIGN : '+' | '-';
fragment EXP : ('E' | 'e') SIGN NUM;
fragment DEC : NUM '.' NUM;
fragment FLOATDEC : (DEC | DEC EXP) ('F' | 'f' | );
fragment DIGITHEX : '0' .. '9' | 'A' .. 'F' | 'a' .. 'f';
fragment NUMHEX : DIGITHEX+;
fragment FLOATHEX : ('0x' | '0X') NUMHEX '.' NUMHEX ('P' | 'p') SIGN NUM ('F' | 'f' | );
fragment STRING_CAR : ~ ('"' | '\\' | '\n');
fragment FILENAME : (LETTER | DIGIT | '.' | '-' | '_')+;

// Deca lexer rules.
ASM : 'asm';
CLASS : 'class';
EXTENDS : 'extends';
ELSE : 'else';
FALSE : 'false';
IF : 'if';
INSTANCEOF : 'instanceof';
NEW : 'new';
NULL : 'null';
READINT : 'readInt';
READFLOAT : 'readFloat';
PRINT : 'print';
PRINTLN : 'println';
PRINTLNX : 'printlnx';
PRINTX : 'printx';
PROTECTED : 'protected';
RETURN : 'return';
THIS : 'this';
TRUE : 'true';
WHILE : 'while';
IDENT : (LETTER | '$' | '_') (LETTER | DIGIT | '$' | '_')*;
EQUALS : '=';
EQEQ : '==';
NEQ : '!=';
LT : '<';
GT : '>';
LEQ : '<=';
GEQ :'>=';
AND : '&&';
OR : '||';
PLUS : '+';
MINUS : '-';
TIMES : '*';
OPARENT : '(';
CPARENT : ')';
OBRACE : '{';
CBRACE : '}';
DOT :'.';
SEMI : ';';
COMMA : ',';
EXCLAM : '!';
PERCENT : '%';
SLASH : '/';
FLOAT : FLOATDEC | FLOATHEX;
INT : '0' | POSITIVE_DIGIT DIGIT*;
STRING : '"' (STRING_CAR | '\\"' | '\\\\')* '"';
MULTI_LINE_STRING : '"' (STRING_CAR | '\n' | '\\"' | '\\\\')* '"';
// INCLUDE : '#include' (' ')* '"' FILENAME '"' { doInlcude(); };
COMMENT : ('/*' .*? '*/' | '//' .*? '\n') { skip(); };

// Ignore spaces, tabs, newlines and whitespaces
WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {
              skip(); // avoid producing a token
          }
    ;