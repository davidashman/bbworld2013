package blackboard.bbworld2013.geek.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import blackboard.bbworld2013.api.Geekifier;
import blackboard.platform.extension.service.ExtensionRegistry;

@Controller
public class ExtensionsController
{

  @Autowired
  private ExtensionRegistry _registry;
  
  public ExtensionsController()
  {
  }
  
  public ExtensionsController( ExtensionRegistry registry )
  {
    _registry = registry;
  }
  
  @RequestMapping( "/extensions" )
  public ModelAndView handleIndex( @RequestParam( value = "p", defaultValue = "Hello World!" ) String phrase )
  {
    Collection<Geekifier> extensions = _registry.getExtensions( "blackboard.bbworld2013.api.geekifier" );

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
