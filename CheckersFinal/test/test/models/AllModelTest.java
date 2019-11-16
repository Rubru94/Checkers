package test.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    CoordinateTest.class,
    PawnTest.class,
    DraughtTest.class,
    GameWithDraughtsTest.class,
    GameTest.class,})
public final class AllModelTest {
}
