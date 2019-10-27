package CheckersOnlyTest;

import CheckersOnlyTest.views.View;
import CheckersOnlyTest.views.console.ConsoleView;

public class ConsoleCheckers extends CheckersOnlyTest {

    @Override
    protected View createView() {
        return new ConsoleView();
    }

    public static void main(String[] args) {
        new ConsoleCheckers().play();
    }

}
