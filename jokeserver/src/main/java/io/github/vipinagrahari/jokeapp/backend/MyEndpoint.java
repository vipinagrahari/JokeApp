/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package io.github.vipinagrahari.jokeapp.backend;

import com.example.Joker;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.jokeapp.vipinagrahari.github.io",
    ownerName = "backend.jokeapp.vipinagrahari.github.io",
    packagePath=""
  )
)
public class MyEndpoint {
    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi() {
        MyBean response = new MyBean();
        response.setData(new Joker().getJoke());
        return response;
    }

}
