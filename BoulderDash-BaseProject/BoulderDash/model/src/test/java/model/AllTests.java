package model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EmptyTest.class, EnemyTest.class, DiamondTest.class, MudTest.class,
		PlayerTest.class, ElementTest.class})
public class AllTests {

}
