package test.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    CoordinateTest.class,
    PieceTest.class,
    GameTest.class,})
public final class AllModelTest {
}
