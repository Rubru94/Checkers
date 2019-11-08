package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.controllers.AllControllerTest;
import test.models.AllModelTest;
import test.views.AllViewTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    AllModelTest.class,
    AllControllerTest.class,
    AllViewTest.class})
public final class AllTest {
}
