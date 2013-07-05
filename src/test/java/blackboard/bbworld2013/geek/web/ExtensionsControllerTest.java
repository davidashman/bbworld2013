package blackboard.bbworld2013.geek.web;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import blackboard.base.IMultiFactory;
import blackboard.bbworld2013.api.Geekifier;

@RunWith( MockitoJUnitRunner.class )
public class ExtensionsControllerTest
{

  @Mock private Geekifier _mockGeekifier;
  @Mock private IMultiFactory<Geekifier> _mockFactory;
  
  @Test
  public void modelPhrasesEqualsOriginalPhraseWithNoExtensions()
  {
    ExtensionsController cut = new ExtensionsController( _mockFactory );
    ModelAndView mv = cut.handleIndex( "test" );
    
    Assert.assertEquals( "test<br/>", mv.getModel().get( "phrases" ).toString() );
  }

  @Test
  public void modelPhrasesEqualsOriginalPhraseWithOneExtension()
  {
    Mockito.when( _mockGeekifier.toGeekPhrase( "test" ) ).thenReturn( "geek" );
    
    Collection<Geekifier> extensions = new LinkedList<Geekifier>();
    extensions.add( _mockGeekifier );
    
    Mockito.when( _mockFactory.getInstances() ).thenReturn( extensions );
    ExtensionsController cut = new ExtensionsController( _mockFactory );
    ModelAndView mv = cut.handleIndex( "test" );
    
    Assert.assertEquals( "test<br/>geek<br/>", mv.getModel().get( "phrases" ).toString() );
  }
  
}
