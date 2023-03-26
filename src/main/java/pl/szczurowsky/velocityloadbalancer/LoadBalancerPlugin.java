package pl.szczurowsky.velocityloadbalancer;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;
import pl.szczurowsky.velocityloadbalancer.listener.DisconnectListener;
import pl.szczurowsky.velocityloadbalancer.listener.ServerPreConnectListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Plugin(
        id = "velocity-load-balancer",
        name = "Velocity Load Balancer",
        version = "@version@",
        authors = "Szczurowsky"

)
public class LoadBalancerPlugin {

    private final ProxyServer server;
    private final Logger logger;
    private List<UUID> connectedPlayers;

    @Inject
    public LoadBalancerPlugin(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
        this.connectedPlayers = new ArrayList<>();
    }

    @Subscribe
    public void onInitialize(ProxyInitializeEvent event) {
        this.registerListeners();
    }

    private void registerListeners() {
        this.server.getEventManager().register(this, new ServerPreConnectListener(this.server, this.connectedPlayers));
        this.server.getEventManager().register(this, new DisconnectListener(this.server, this.connectedPlayers));
    }

}
