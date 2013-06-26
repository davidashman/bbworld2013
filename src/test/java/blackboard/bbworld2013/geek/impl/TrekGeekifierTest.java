package blackboard.bbworld2013.geek.impl;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class TrekGeekifierTest
{

  @Test
  public void toGeekPhraseAddsStarTrek()
  {
    // Use Mockito, the best mocking framework on the market, to control the random number.
    Random random = Mockito.mock( Random.class );
    Mockito.when( random.nextDouble() ).thenReturn( 0.1 );
    
    TrekGeekifier cut = new TrekGeekifier( random );
    String geeked = cut.toGeekPhrase( "test" );
    
    Assert.assertEquals( String.format( TrekGeekifier.TREK_FORMAT, 10, "test" ), geeked );
  }

}
