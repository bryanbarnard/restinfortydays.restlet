package restinfortydays.restlet.common;

import org.restlet.resource.Get;

    public interface RootResource {
        @Get
        public String represent();
    }
