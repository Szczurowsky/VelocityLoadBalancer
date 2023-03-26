package pl.szczurowsky.velocityloadbalancer.util;

import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.server.RegisteredServer;

import java.util.List;

public class ServerUtil {

    private ServerUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static RegisteredServer getLowestPlayersServer(ProxyServer server) {
        List<RegisteredServer> registeredServers = server.getAllServers().stream().toList();
        RegisteredServer lowestPlayersServer = registeredServers.get(0);
        for (RegisteredServer registeredServer : registeredServers) {
            if (registeredServer.getPlayersConnected().size() < lowestPlayersServer.getPlayersConnected().size()) {
                lowestPlayersServer = registeredServer;
            }
        }
        return lowestPlayersServer;
    }

}
