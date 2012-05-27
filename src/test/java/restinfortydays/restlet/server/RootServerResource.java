package restinfortydays.restlet.server;

import org.restlet.resource.ServerResource;
import restinfortydays.common.RootResource;

public class RootServerResource extends ServerResource implements RootResource {

    @Override
    public String represent() {
        return "test";
    }
}
