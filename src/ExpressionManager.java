/*
 * @Author: Arwin Lado
 * Date: 13/01/2025
 * ExpressionManager class 
 */

import java.util.LinkedList;
import java.util.List;

/**
 * ExpressionManager class is a manager that will manage expression of words that the user will type
 * @param LinkedList<Expression> a data structure that uses LinkedList to store the expressions 
 * @return LinkedList<Expression> and basically returns the expressions stored in the linkedlist by the user
 **/

class ExpressionManager {
    // instance variable for expressions as linkedlist
    private List<Expression> expressions;

    /**
     * Constructor for the ExpressionManager.
     * Initializes the expressions list as a LinkedList.
     */
    public ExpressionManager() {
        this.expressions = new LinkedList<>();
    }

    /**
     * Adds an expression to the expressions list.
     * 
     * @param expression the expression to be added.
     */
    public void addExpression(Expression expression) {
        expressions.add(expression);
    }

    /**
     * Retrieves the list of expressions.
     * 
     * @return the list of expressions.
     */
    public List<Expression> getExpressions() {
        return expressions;
    }
}
