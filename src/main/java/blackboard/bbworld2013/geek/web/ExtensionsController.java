package blackboard.bbworld2013.geek.web;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import blackboard.bbworld2013.api.Geekifier;
import blackboard.platform.extension.service.ExtensionRegistryFactory;

@Controller
public class ExtensionsController
{

  @RequestMapping( "/extensions" )
  public ModelAndView handleIndex()
  {
    Collection<Geekifier> extensions = ExtensionRegistryFactory.getInstance()
        .getExtensions( "blackboard.bbworld2013.api.geekifier" );

    String phrase = "Hello World!";
    StringBuilder str = new StringBuilder();
    str.append( phrase );
    str.append( "<br/>" );
    
    for ( Geekifier geek : extensions )
    {
      str.append( geek.toGeekPhrase( phrase ) );
      str.append( "<br/>" );
    }
    
    return new ModelAndView( "extensionList", "phrases", str );
  }

}
