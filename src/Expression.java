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
