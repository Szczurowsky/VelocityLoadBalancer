package pl.szczurowsky.velocityloadbalancer;

import com.google.inject.Inject;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;
import pl.szczurowsky.velocityloadbalancer.listener.ServerPreConnectListener;

@Plugin(
        id = "velocity-load-balancer",
        name = "Velocity Load Balancer",
        version = "@version@",
        authors = "Szczurowsky"

)
public class LoadBalancerPlugin {

    private final ProxyServer server;
    private final Logger logger;


    @Inject
    public LoadBalancerPlugin(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
        this.registerListeners();
    }

    private void registerListeners() {
        this.server.getEventManager().register(this, new ServerPreConnectListener(this.server));
    }

}
