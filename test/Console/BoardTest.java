package Console;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;


class BoardTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();


    @Test
    void getColumnInputToBig() {
        Board.getColumnInput("9");

    }

    @Test
    void getRowInputToBig() {
        Board.getRowInput("9");
    }

    @Test
    void getColumnInputToLow() {
        Board.getColumnInput("0");

    }

    @Test
    void getRowInputToLow() {
        Board.getRowInput("0");
    }

    @Test
    void getColumnInputInvalid() {
        Board.getColumnInput("a");
        exception.expect(NumberFormatException.class);

    }

    @Test
    void getRowInputToInvalid() {
        Board.getRowInput("a");
        exception.expect(NumberFormatException.class);
    }

    @Test
    void getColumnInputCharacter() {
        exception.expect(NumberFormatException.class);
        Board.getColumnInput("*");


    }

    @Test
    void getRowInputToCharacter() {
        Board.getRowInput("*");
        exception.expect(NumberFormatException.class);
    }
}