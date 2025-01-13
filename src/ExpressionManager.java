/*
 * @Author: Arwin Lado
 * Date: 13/01/2025
 * ExpressionManager class 
 */

import java.util.LinkedList;
import java.util.List;

// some testing and changes will be deleted or used !
public class ExpressionManager {
    // creates a private list for linkedlist of expressions
    private List<Expression> expressions;


    // creagte a constructor for the expression manager and using linkedlist as the data structure
    public ExpressionManager() {
        this.expressions = new LinkedList<>();
    }

    public void addExpression(Expression expression) {
        expressions.add(expression);
    }

    
    public List<Expression> getExpressions() {
        return expressions;
    }

}
