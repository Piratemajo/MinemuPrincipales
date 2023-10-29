package es.minemu.minemuprincipales;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;




import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinemuPrincipales extends JavaPlugin implements CommandExecutor {

    private Map<Player, EntityType> playerPets = new HashMap<Player, EntityType>();
    private Map<Player, Location> homeLocations = new HashMap<>();
    private Map<Player, Player> teleportRequests = new HashMap<>();

    private Set<Player> sittingPlayers = new HashSet<>();


    @Override
    public void onEnable() {
        // Registra los comandos y asigna este objeto como su ejecutor
        getCommand("saludo").setExecutor(this);
        getCommand("curar").setExecutor(this);
        getCommand("teleport").setExecutor(this);
        getCommand("fly").setExecutor(this);
        getCommand("sethome").setExecutor(this);
        getCommand("home").setExecutor(this);
        getCommand("tpa").setExecutor(this);
        getCommand("tpaccept").setExecutor(this);
        getCommand("tpall").setExecutor(this);
        getCommand("broadcast").setExecutor(this);
        getCommand("heal").setExecutor(this);
        getCommand("setspawn").setExecutor(this);
        getCommand("workbench").setExecutor(this);
        getCommand("nick").setExecutor(this);
        getCommand("timeleft").setExecutor(this);
        getCommand("weatherclear").setExecutor(this);
        getCommand("feed").setExecutor(this);
        getCommand("gm").setExecutor(this);
        getCommand("spawn").setExecutor(this);
        getCommand("setwarp").setExecutor(this);
        getCommand("warp").setExecutor(this);
        getCommand("vanish").setExecutor(this);
        getCommand("pet").setExecutor(this);
        getCommand("petlist").setExecutor(this);
        getCommand("petrename").setExecutor(this);
        getCommand("petrelease").setExecutor(this);
        getCommand("god").setExecutor(this);
        getCommand("petcall").setExecutor(this);
        getCommand("ayuda").setExecutor(new Ayuda());
    }

    @Override
    public void onDisable() {
        // Cualquier limpieza o tareas de apagado aquí
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("saludo")) {
            sender.sendMessage("¡Hola, Minecraft!");
            return true;
        }

        if (command.getName().equalsIgnoreCase("curar")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.setHealth(20.0);
                player.sendMessage("¡Te has curado!");
                return true;
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("teleport")) {
            if (sender instanceof Player && args.length == 3) {
                try {
                    double x = Double.parseDouble(args[0]);
                    double y = Double.parseDouble(args[1]);
                    double z = Double.parseDouble(args[2]);
                    Player player = (Player) sender;
                    player.teleport(new Location(player.getWorld(), x, y, z));
                    player.sendMessage("¡Te has teletransportado!");
                    return true;
                } catch (NumberFormatException e) {
                    sender.sendMessage("Utiliza /teleport <x> <y> <z> para teletransportarte.");
                    return false;
                }
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego y requiere coordenadas válidas.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("fly")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.getAllowFlight()) {
                    player.setAllowFlight(false);
                    player.sendMessage("Modo vuelo desactivado.");
                } else {
                    player.setAllowFlight(true);
                    player.sendMessage("Modo vuelo activado.");
                }
                return true;
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("sethome")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                homeLocations.put(player, player.getLocation());
                player.sendMessage("Ubicación de inicio establecida.");
                return true;
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("home")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location homeLocation = homeLocations.get(player);
                if (homeLocation != null) {
                    player.teleport(homeLocation);
                    player.sendMessage("¡Te has teletransportado a tu ubicación de inicio!");
                } else {
                    player.sendMessage("Primero debes establecer una ubicación de inicio con /sethome.");
                }
                return true;
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }


        if (command.getName().equalsIgnoreCase("tpa")) {
            // Este comando podría usarse para enviar solicitudes de teletransporte a otros jugadores
            if (sender instanceof Player) {
                if (args.length == 1) {
                    Player player = (Player) sender;
                    String targetName = args[0];
                    Player target = Bukkit.getPlayer(targetName);
                    if (target != null) {
                        //     la lógica para enviar una solicitud de teletransporte
                        player.sendMessage("Solicitud de teletransporte enviada a " + target.getName() + ".");
                        target.sendMessage(player.getName() + " te ha enviado una solicitud de teletransporte. Usa /tpaccept para aceptar.");
                        // Guarda la solicitud en algún lugar (por ejemplo, en un mapa de solicitudes)
                        return true;
                    } else {
                        sender.sendMessage("Jugador no encontrado.");
                        return false;
                    }
                } else {
                    sender.sendMessage("Uso incorrecto. Debes proporcionar el nombre del jugador al que deseas teletransportarte.");
                    return false;
                }
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("tpaccept")) {
            //     la lógica para el comando /tpaccept aquí
            // Este comando podría usarse para aceptar solicitudes de teletransporte pendientes
            if (sender instanceof Player) {
                Player player = (Player) sender;
                // Asegúrate de tener una forma de gestionar las solicitudes pendientes
                player.sendMessage("Has aceptado la solicitud de teletransporte.");
                return true;
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("tpall")) {
            // Este comando podría usarse para teletransportar a todos los jugadores a tu ubicación
            if (sender instanceof Player) {
                Player player = (Player) sender;
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    if (onlinePlayer != player) {
                        onlinePlayer.teleport(player.getLocation());
                    }
                }
                player.sendMessage("Te has teletransportado a todos los jugadores.");
                return true;
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("broadcast")) {
            // Este comando podría usarse para enviar un mensaje a todo el servidor
            if (args.length > 0) {
                String message = String.join(" ", args);
                Bukkit.broadcastMessage(ChatColor.GOLD + "Broadcast: " + ChatColor.RESET + message);
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "Debes proporcionar un mensaje para el broadcast.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("heal")) {
            // Este comando podría usarse para curar al jugador
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.setHealth(20.0);
                player.setFoodLevel(20);
                player.sendMessage(ChatColor.GREEN + "¡Te has curado y llenado de comida!");
                return true;
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("setspawn")) {
            // Este comando podría usarse para establecer el punto de aparición del mundo
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location spawnLocation = player.getLocation();
                getServer().getWorlds().get(0).setSpawnLocation(spawnLocation.getBlockX(), spawnLocation.getBlockY(), spawnLocation.getBlockZ());
                sender.sendMessage(ChatColor.GREEN + "Punto de aparición establecido.");
                return true;
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("workbench")) {
            // Este comando podría usarse para abrir un banco de trabajo para el jugador
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.openWorkbench(null, true);
                return true;
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("nick")) {
            // Este comando podría usarse para cambiar el nombre visible del jugador
            if (args.length == 1) {
                String newNick = args[0];
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    player.setDisplayName(newNick);
                    player.sendMessage(ChatColor.GREEN + "Tu nuevo nombre es: " + newNick);
                    return true;
                } else {
                    sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                    return false;
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Uso incorrecto. Debes proporcionar un nombre.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("timeleft")) {
            // Este comando podría usarse para mostrar el tiempo restante hasta el próximo día
            long timeUntilDay = 24000 - (getServer().getWorlds().get(0).getTime() % 24000);
            long hours = timeUntilDay / 1000;
            long minutes = (timeUntilDay % 1000) * 60 / 1000;
            sender.sendMessage(ChatColor.GREEN + "Tiempo restante hasta el próximo día: " + hours + " horas y " + minutes + " minutos.");
            return true;
        }

        if (command.getName().equalsIgnoreCase("weatherclear")) {
            // Este comando podría usarse para limpiar el clima y establecer el tiempo en claro
            getServer().getWorlds().get(0).setStorm(false);
            getServer().getWorlds().get(0).setThundering(false);
            sender.sendMessage(ChatColor.GREEN + "El clima se ha despejado.");
            return true;
        }

        if (command.getName().equalsIgnoreCase("feed")) {
            // Este comando podría usarse para rellenar la barra de hambre del jugador
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.setFoodLevel(20);
                player.sendMessage(ChatColor.GREEN + "Has sido alimentado.");
                return true;
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("gm")) {
            // Este comando podría usarse para cambiar el modo de juego del jugador
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 1) {
                    try {
                        int mode = Integer.parseInt(args[0]);
                        if (mode >= 0 && mode <= 3) {
                            player.setGameMode(GameMode.values()[mode]);
                            sender.sendMessage(ChatColor.GREEN + "Modo de juego cambiado a " + GameMode.values()[mode]);
                            return true;
                        } else {
                            sender.sendMessage(ChatColor.RED + "El modo de juego debe estar entre 0 y 3.");
                            return false;
                        }
                    } catch (NumberFormatException e) {
                        sender.sendMessage(ChatColor.RED + "Uso incorrecto. Debes proporcionar un número entre 0 y 3.");
                        return false;
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "Uso incorrecto. Debes proporcionar un número entre 0 y 3.");
                    return false;
                }
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("spawn")) {
            // Este comando podría usarse para teletransportar al jugador al punto de aparición del mundo
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location spawnLocation = player.getWorld().getSpawnLocation();
                player.teleport(spawnLocation);
                player.sendMessage(ChatColor.GREEN + "Te has teletransportado al punto de aparición.");
                return true;
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("setwarp")) {
            // Este comando podría usarse para establecer una ubicación de warp en el mundo
            if (sender instanceof Player) {
                if (args.length == 1) {
                    Player player = (Player) sender;
                    String warpName = args[0];
                    Location warpLocation = player.getLocation();
                    // Guarda la ubicación en algún lugar (por ejemplo, en un mapa de warps)
                    player.sendMessage(ChatColor.GREEN + "Ubicación de warp '" + warpName + "' establecida.");
                    return true;
                } else {
                    sender.sendMessage(ChatColor.RED + "Uso incorrecto. Debes proporcionar un nombre para el warp.");
                    return false;
                }
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("warp")) {
            // Este comando podría usarse para teletransportar al jugador a una ubicación de warp previamente establecida
            if (sender instanceof Player) {
                if (args.length == 1) {
                    Player player = (Player) sender;
                    String warpName = args[0];
                    // Obtiene la ubicación del warp desde algún lugar (por ejemplo, un mapa de warps)
                    // Teletransporta al jugador a la ubicación del warp
                    player.sendMessage(ChatColor.GREEN + "Te has teletransportado al warp '" + warpName + "'.");
                    return true;
                } else {
                    sender.sendMessage(ChatColor.RED + "Uso incorrecto. Debes proporcionar un nombre de warp.");
                    return false;
                }
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("vanish")) {
            // Este comando podría usarse para activar o desactivar el modo invisible del jugador
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("minemu.vanish")) {
                    if (player.isInvisible()) {
                        player.setInvisible(false);
                        player.sendMessage(ChatColor.GREEN + "Modo invisible desactivado.");
                    } else {
                        player.setInvisible(true);
                        player.sendMessage(ChatColor.GREEN + "Modo invisible activado.");
                    }
                    return true;
                } else {
                    player.sendMessage(ChatColor.RED + "No tienes permiso para utilizar este comando.");
                    return false;
                }
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("pet")) {
            // Este comando podría usarse para permitir a los jugadores obtener una mascota
            if (sender instanceof Player) {
                Player player = (Player) sender;
                EntityType petType = EntityType.WOLF;// Por ejemplo, una mascota lobo
                // Crea la mascota y configura su dueño
                // Añade la mascota a la lista de mascotas del jugador
                player.sendMessage(ChatColor.GREEN + "¡Has obtenido una mascota!");
                playerPets.put(player, petType);
                return true;
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("petlist")) {
            // Implementa la lógica para el comando /petlist aquí
            // Este comando podría usarse para mostrar la lista de mascotas del jugador
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (playerPets.containsKey(player)) {
                    EntityType petType = playerPets.get(player);
                    sender.sendMessage(ChatColor.GREEN + "Tienes una mascota de tipo: " + petType);
                } else {
                    sender.sendMessage(ChatColor.GREEN + "No tienes mascotas.");
                }
                return true;
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("petrename")) {
            // Este comando podría usarse para cambiar el nombre de una mascota
            if (sender instanceof Player) {
                if (args.length == 1) {
                    Player player = (Player) sender;
                    if (playerPets.containsKey(player)) {
                        EntityType petType = playerPets.get(player);
                        String newPetName = args[0]:
                        sender.sendMessage(ChatColor.GREEN + "Has cambiado el nombre de tu mascota a: " + newPetName);
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.RED + "No tienes mascotas para renombrar.");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "Uso incorrecto. Debes proporcionar un nombre para la mascota.");
                }
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
            }
            return false;
        }

        if (command.getName().equalsIgnoreCase("petrelease")) {
            // Este comando podría usarse para liberar a una mascota
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (playerPets.containsKey(player)) {
                    EntityType pet = playerPets.get(player);
                    player.sendMessage(ChatColor.GREEN + "Has liberado a tu mascota de tipo " + pet + ".");
                    playerPets.remove(player);
                    return true;
                } else {
                    sender.sendMessage(ChatColor.RED + "No tienes mascotas para liberar.");
                }
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
            }
            return false;
        }

        if (command.getName().equalsIgnoreCase("god")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (player.hasPermission("minemu.god")) {
                    if (args.length == 0) {
                        if (player.isInvulnerable()) {
                            player.setInvulnerable(false);
                            player.sendMessage("Modo Dios desactivado.");
                        } else {
                            player.setInvulnerable(true);
                            player.sendMessage("Modo Dios activado.");
                        }
                    } else {
                        player.sendMessage("Uso incorrecto. No debes proporcionar argumentos.");
                    }
                } else {
                    player.sendMessage("No tienes permiso para utilizar este comando.");
                }
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
            }
            return true;
        }

        if (command.getName().equalsIgnoreCase("callpet")) {
            // Este comando podría usarse para llamar a la mascota y hacer que siga al jugador
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (playerPets.containsKey(player)) {
                    EntityType pet = playerPets.get(player);
                    // Puedes usar métodos como .teleport() para lograrlo.
                    pet.isSpawnable();
                    player.sendMessage("Tu mascota te sigue.");
                } else {
                    player.sendMessage("No tienes una mascota para llamar.");
                }
            } else {
                sender.sendMessage("Este comando solo puede ser utilizado por un jugador en el juego.");
            }
            return true;
        }




        //Return del propia clase del comando
        return false;


    }





}
