import java.util.LinkedList;
import java.util.List;

// some testing and changes will be deleted or used !
public class ExpressionManager {
    private List<Expression> expressions;

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
