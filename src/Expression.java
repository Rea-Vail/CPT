/*
 * @Author: Arwin Lado
 * Date: 13/01/2025
 * Expression class 
 */

public class Expression {
    // creates a private string for text
    private String text;

    // creates a constructor for the expression 
    public Expression(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Expression{" + "text='" + text + '\'' + '}';
    }
}
