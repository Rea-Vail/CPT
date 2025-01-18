/*
 * @Author: Arwin Lado
 * Date: 13/01/2025
 * Expression class 
 */

 /**
  * This class is the expression were the user will type the words out in a string
  * @param String text reoresebts the text of the expression
  * @return text returns the text of the expression
  * It works as a way for the words to be placed here after the user is done typing.
  **/
class Expression {
    // Instance variable for the text of the expression
    private String text;

    /**
     * Constructor for the Expression class.
     * 
     * @param text the text of the expression.
     */
    public Expression(String text) {
        this.text = text;
    }

    /**
     * Retrieves the text of the expression.
     * 
     * @return the text of the expression.
     */
    public String getText() {
        return text;
    }

    /**
     * Returns a string representation of the expression.
     * 
     * @return a string representation of the expression.
     */
    @Override
    public String toString() {
        return "Expression{" + "text='" + text + '\'' + '}';
    }
}