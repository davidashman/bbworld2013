/*
 * Copyright (c) 2013, Blackboard, Inc.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer 
 * in the documentation and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, 
 * BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT 
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE 
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package blackboard.bbworld2013.geek.impl;

import java.util.Random;

import org.springframework.stereotype.Component;

import blackboard.bbworld2013.api.Geekifier;
import blackboard.platform.spring.beans.annotations.Extension;

/*
 * The @Extension annotation marks the class as an extension that is implementing the extension point
 * described in annotation text.    
 */
@Extension( "blackboard.bbworld2013.api.geekifier" )
@Component
public class TrekGeekifier implements Geekifier
{
  
  public static final String TREK_FORMAT = "On episode %d of Star Trek, Captain Kirk said \"%s\".";

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
