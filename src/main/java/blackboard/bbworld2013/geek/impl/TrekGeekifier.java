package blackboard.bbworld2013.geek.impl;

import java.util.Random;

import blackboard.bbworld2013.api.Geekifier;
import blackboard.platform.spring.beans.annotations.Extension;

@Extension( "blackboard.bbworld2013.api.geekifier" )
public class TrekGeekifier implements Geekifier
{
  
  public static final String TREK_FORMAT = "On episode %d of Star Trek, %s";

  private Random _random;
  
  public TrekGeekifier()
  {
    this( new Random() );
  }
  
  public TrekGeekifier( Random random )
  {
    _random = random;
  }

  @Override
  public String toGeekPhrase( String normalPhrase )
  {
    return String.format( TREK_FORMAT, (int) ( _random.nextDouble() * 100.0 ), normalPhrase );
  }

}
