package pl.szczurowsky.velocityloadbalancer.listener;

import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.ServerPreConnectEvent;
import com.velocitypowered.api.proxy.ProxyServer;
import pl.szczurowsky.velocityloadbalancer.util.ServerUtil;

public class ServerPreConnectListener {

    private final ProxyServer server;

    public ServerPreConnectListener(ProxyServer server) {
        this.server = server;
    }

    @Subscribe(order = PostOrder.FIRST)
    public void onServerPreConnect(ServerPreConnectEvent event) {
        event.setResult(ServerPreConnectEvent.ServerResult.allowed(ServerUtil.getLowestPlayersServer(server)));
    }

}
