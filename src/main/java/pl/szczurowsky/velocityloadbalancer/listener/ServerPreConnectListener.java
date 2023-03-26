package pl.szczurowsky.velocityloadbalancer.listener;

import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.ServerPreConnectEvent;
import com.velocitypowered.api.proxy.ProxyServer;
import pl.szczurowsky.velocityloadbalancer.util.ServerUtil;

import java.util.List;
import java.util.UUID;

public class ServerPreConnectListener {

    private final ProxyServer server;
    private final List<UUID> connectedPlayers;

    public ServerPreConnectListener(ProxyServer server, List<UUID> connectedPlayers) {
        this.server = server;
        this.connectedPlayers = connectedPlayers;
    }

    @Subscribe(order = PostOrder.FIRST)
    public void onServerPreConnect(ServerPreConnectEvent event) {
        if (this.connectedPlayers.contains(event.getPlayer().getUniqueId())) return;
        this.connectedPlayers.add(event.getPlayer().getUniqueId());
        event.setResult(ServerPreConnectEvent.ServerResult.allowed(ServerUtil.getLowestPlayersServer(server)));
    }

}
