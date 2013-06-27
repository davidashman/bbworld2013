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

import blackboard.bbworld2013.api.Geekifier;
import blackboard.platform.extension.service.ExtensionRegistry;

@RunWith( MockitoJUnitRunner.class )
public class ExtensionsControllerTest
{

  @Mock private Geekifier _mockGeekifier;
  @Mock private ExtensionRegistry _mockRegistry;
  
  @Test
  public void modelPhrasesEqualsOriginalPhraseWithNoExtensions()
  {
    ExtensionsController cut = new ExtensionsController( _mockRegistry );
    ModelAndView mv = cut.handleIndex( "test" );
    
    Assert.assertEquals( "test<br/>", mv.getModel().get( "phrases" ).toString() );
  }

  @Test
  public void modelPhrasesEqualsOriginalPhraseWithOneExtension()
  {
    Mockito.when( _mockGeekifier.toGeekPhrase( "test" ) ).thenReturn( "geek" );
    
    Collection<Object> extensions = new LinkedList<Object>();
    extensions.add( _mockGeekifier );
    
    Mockito.when( _mockRegistry.getExtensions( Mockito.anyString() ) ).thenReturn( extensions );
    ExtensionsController cut = new ExtensionsController( _mockRegistry );
    ModelAndView mv = cut.handleIndex( "test" );
    
    Assert.assertEquals( "test<br/>geek<br/>", mv.getModel().get( "phrases" ).toString() );
  }
  
}
