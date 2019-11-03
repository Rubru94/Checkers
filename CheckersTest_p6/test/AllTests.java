
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
    controllers.PlayControllerTest.class,
    models.BoardTest.class,
    models.CoordinateTest.class,
    models.GameTest.class,
    models.PieceTest.class,
    models.SquareTest.class,
    models.TurnTest.class,
    views.CommandViewTest.class
})

public class AllTests {
}
