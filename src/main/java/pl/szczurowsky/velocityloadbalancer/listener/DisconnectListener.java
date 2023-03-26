package pl.szczurowsky.velocityloadbalancer.listener;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.DisconnectEvent;
import com.velocitypowered.api.proxy.ProxyServer;

import java.util.List;
import java.util.UUID;

public class DisconnectListener {

    private final ProxyServer server;
    private final List<UUID> connectedPlayers;

    public DisconnectListener(ProxyServer server, List<UUID> connectedPlayers) {
        this.server = server;
        this.connectedPlayers = connectedPlayers;
    }

    @Subscribe
    public void onDisconnect(DisconnectEvent event) {
        connectedPlayers.remove(event.getPlayer().getUniqueId());
    }

}
