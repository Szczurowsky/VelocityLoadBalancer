# VelocityLoadBalancer

🛣️ Simple plugin for Velocity, which helps in optimizing servers load by balancing players on backend servers.

## Installation
* Download the latest release from the [releases tab](https://github.com/Szczurowsky/VelocityLoadBalancer/releases).
* Put the jar in your Velocity plugins folder
* Restart Velocity

## Configuration
Basically everything you need to do is set up servers on Velocity.
Plugins will automatically detect all backend servers and start balancing players between them.

Example config:
```toml
[servers]
	# Configure your servers here. Each key represents the server's name, and the value
	# represents the IP address of the server to connect to.
    server1 = "127.0.0.1:25565" 
    server2 = "127.0.0.1:25566" 
    server3 = "127.0.0.1:25567" 
    server4 = "127.0.0.1:25568" 
	# In what order we should try servers when a player logs in or is kicked from a server.
	try = [
      "server1",
      "server2",
      "server3",
      "server4"
    ]
```

## Building plugin
* Pull the latest version of the repository
* Run `./gradlew shadowJar`

## Coding Guidelines

### Commit Messages

When contributing to this project please follow the [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/)
specification for writing commit messages, so that changelogs and release versions can be generated automatically.

**Example commit message**

```
fix: prevent racing of requests
Introduce a request id and a reference to latest request. Dismiss
incoming responses other than from latest request.
Remove timeouts which were used to mitigate the racing issue but are
obsolete now.
Reviewed-by: Z
Refs: #123
```

Some tooling that can help you author those commit messages are the following plugins:

* JetBrains Plugin [Conventional Commit](https://plugins.jetbrains.com/plugin/13389-conventional-commit)
  by [Edoardo Luppi](https://github.com/lppedd)
* Visual Studio
  Plugin [Conventional Commits](https://marketplace.visualstudio.com/items?itemName=vivaxy.vscode-conventional-commits)
  by [vivaxy](https://marketplace.visualstudio.com/publishers/vivaxy)
