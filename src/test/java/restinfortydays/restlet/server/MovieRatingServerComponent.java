package restinfortydays.restlet.server;

import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;

public class MovieRatingServerComponent extends Component {

    public static void main(String[] args) throws Exception {
        new MovieRatingServerComponent().start();
    }

    public MovieRatingServerComponent() {
        Server server = getServers().add(Protocol.HTTP, 8111);
        server.getContext().getParameters().set("tracing", "true");         //enable tracing to console
        getDefaultHost().attachDefault(new MovieRatingServerApplication());
    }
}
